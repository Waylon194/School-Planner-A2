package Simulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation extends Application {

    private Tileset tileset;
    private Canvas canvas;
    private Stage stage;
    private ArrayList<Visitor> visitors;
    public Simulation() throws IOException, ParseException {
        tileset = new Tileset();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(1920, 1080);
        this.stage = primaryStage;
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        drawMap(g2d);
        draw(g2d);
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if(last == -1)
                    last = now;
                update((now - last) / 1.0e9);
                last = now;
                try {
                    draw(g2d);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }.start();




    }
    public void init()
    {

        visitors = new ArrayList<>();

        while(visitors.size() < 1) {
            double x = Math.random()*1920;
            double y = Math.random()*1080;
            boolean hasCollision = false;
            for(Visitor visitor : visitors)
                if(visitor.hasCollision(new Point2D.Double(x,y)))
                    hasCollision = true;
            if(!hasCollision)
                visitors.add(new Visitor(new Point2D.Double(x, y)));
        }
    }


    public void draw(FXGraphics2D graphics) throws IOException, ParseException {
        graphics.setBackground(Color.pink);
        graphics.clearRect(0,0,(int)stage.getWidth(), (int)stage.getHeight());

        for(Visitor visitor : visitors)
            visitor.draw(graphics);
    }

    public void drawMap(FXGraphics2D graphics){
        int y = 0;
        int x = 0;
        int scaleFactor = 16;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 10000; i++) {
                int value = tileset.getValue(i, j);
                if (value != 0) {
                    graphics.drawImage(tileset.getTile(value - 1), (int) this.canvas.getWidth() / 5 + x * scaleFactor, y * scaleFactor, scaleFactor, scaleFactor, null);
                }

                if ((i != 0) && ((i + 1) % 100 == 0) && i != 9999) {
                    x = 0;
                    y++;
                }
                else if (i == 9999) {
                    x = 0;
                    y = 0;

                }
                else {
                    x++;
                }
            }
        }
    }
    public void update(double deltaTime)
    {
        for(Visitor visitor : visitors)
            visitor.update(visitors);
    }
    
    public static void main(String[] args) {
        launch(Simulation.class);
    }

}
