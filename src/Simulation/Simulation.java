package Simulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Simulation extends Application {

    private Camera camera;
    private Tileset tileset;
    private Canvas canvas;
    private Stage stage;
    private ArrayList<Visitor> visitors;
    private Map map;
    private PathFinder pathFinder;
    private int c = 32;

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
        map = new Map(this, this.camera);


        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();


        new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                update((now - last) / 1.0e9);
                last = now;
                draw(g2d);

            }
        }.start();


    }

    public void init() throws Exception {
        pathFinder = new PathFinder();


        visitors = new ArrayList<>();

        while (visitors.size() < 2) {
            double x = 36 * c;
            double y = 48 * c;
            visitors.add(new Visitor(new Point2D.Double(x, y), pathFinder));
            x = 69*c;
            y = 39*c;
            visitors.add(new Visitor(new Point2D.Double(x, y), pathFinder));
            x = 49*c;
            y = 14*c;
            visitors.add(new Visitor(new Point2D.Double(x, y), pathFinder));

        }
    }


    public void draw(FXGraphics2D graphics) {
        graphics.setBackground(Color.pink);
        graphics.clearRect(0, 0, (int) stage.getWidth(), (int) stage.getHeight());

        map.draw(graphics);
        for (Visitor visitor : visitors) {
            visitor.draw(graphics);
        }
    }


    public void update(double deltaTime) {
        for (Visitor visitor : visitors)
            visitor.update(visitors, deltaTime);
    }

    public static void main(String[] args) {
        launch(Simulation.class);
    }


    public Canvas getCanvas() {
        return this.canvas;
    }

}