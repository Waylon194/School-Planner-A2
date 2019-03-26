package Simulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Simulation extends Application {

    private Camera camera;
    private Tileset tileset;
    private Canvas canvas;
    private Stage stage;
    private ArrayList<Visitor> visitors;
    private Map map;

    public Simulation() throws Exception {

        tileset = new Tileset();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(3840, 3840);
        this.stage = primaryStage;
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        camera = new Camera(canvas, graphics -> {

                draw(graphics);

        }, g2d);
        map = new Map(this,this.camera);


        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        PathFinder pathFinder = new PathFinder();
        pathFinder.calculateDistanceMap(45, 18);

        new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if(last == -1)
                    last = now;
                update((now - last) / 1.0e9);
                last = now;
                draw(g2d);

            }
        }.start();


    }

    public void init() throws Exception{



        visitors = new ArrayList<>();

        while(visitors.size() < 3) {
            double x = Math.random()*1000;
            double y =Math.random()*100;
            boolean hasCollision = false;
            for(Visitor visitor : visitors)
                if(visitor.hasCollision(new Point2D.Double(x,y)))
                    hasCollision = true;
            if(!hasCollision)
                visitors.add(new Visitor(new Point2D.Double(x, y)));

        }
    }


    public void draw(FXGraphics2D graphics)  {
        graphics.setBackground(Color.pink);
        graphics.clearRect(0,0,(int)stage.getWidth(), (int)stage.getHeight());

        map.draw(graphics);
        for(Visitor visitor : visitors) {
            visitor.draw(graphics);
        }
    }





    public void update(double deltaTime) {
        for(Visitor visitor : visitors)
            visitor.update(visitors, deltaTime);
    }

    public static void main(String[] args) {
        launch(Simulation.class);
    }


    public Canvas getCanvas(){
        return this.canvas;
    }

}