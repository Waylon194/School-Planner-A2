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

    public Simulation() throws IOException, ParseException {
        tileset = new Tileset();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(1920, 1080);
        this.stage = primaryStage;
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        camera = new Camera(canvas, this::drawMap, g2d);
        drawMap(g2d);
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();

//       new AnimationTimer() {
//            long last = -1;
//            @Override
//            public void handle(long now) {
//                if(last == -1)
//                    last = now;
//                update((now - last) / 1.0e9);
//                last = now;
//
//               try {
//
//                   drawMap(g2d);
//                   draw(g2d);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();


    }

    public void init() {

        visitors = new ArrayList<>();

        while (visitors.size() < 1) {
            double x = Math.random() * 1920;
            double y = Math.random() * 1080;
            boolean hasCollision = false;
            for (Visitor visitor : visitors)
                if (visitor.hasCollision(new Point2D.Double(x, y)))
                    hasCollision = true;
            if (!hasCollision)
                visitors.add(new Visitor(new Point2D.Double(x, y)));
        }
    }


    public void draw(FXGraphics2D graphics) throws IOException, ParseException {
        graphics.clearRect(0, 0, (int) stage.getWidth(), (int) stage.getHeight());
        for (Visitor visitor : visitors)
            visitor.draw(graphics);
    }

    public void drawMap(FXGraphics2D graphics) {
        graphics.setTransform(new AffineTransform());
        graphics.clearRect(0, 0, 1920, 1080);
        graphics.setTransform(camera.getTransform((int) canvas.getWidth(), (int) canvas.getHeight()));

        int y = 0;
        int x = 0;
        int scaleFactor = 32;
        for (int layer = 0; layer < 4; layer++) {
            for (int tile = 0; tile < 10000; tile++) {
                long value = tileset.getValue(tile, layer);
                if (value != 0) {
                    if (value < 2715) {
                        AffineTransform tx = new AffineTransform();
                        tx.translate(x * scaleFactor, y * scaleFactor);
                        graphics.drawImage(tileset.getTile((int) value - 1), tx, null);
                    } else {
                        AffineTransform tx = new AffineTransform();
                        tx.translate(x * scaleFactor, y * scaleFactor);
                        graphics.drawImage(tileset.getTile((int) calculateRotatedValue(value) - 1), tx, null);
                    }

                }
                if ((tile != 0) && ((tile + 1) % 100 == 0) && tile != 9999) {
                    x = 0;
                    y++;
                } else if (tile == 9999) {
                    x = 0;
                    y = 0;

                } else {
                    x++;
                }
            }
        }
        graphics.setTransform(camera.getTransform((int) canvas.getWidth(), (int) canvas.getHeight()));
    }

    private long calculateRotatedValue(long value) {

        long FLIPPED_HORIZONTALLY_FLAG = 0x80000000;
        long FLIPPED_VERTICALLY_FLAG = 0x40000000;
        long FLIPPED_DIAGONALLY_FLAG = 0x20000000;
        long JOHANS_CONSTANTEXD = ~0xE0000000;


        return value & JOHANS_CONSTANTEXD;


    }

    public void update(double deltaTime) {
        for (Visitor visitor : visitors)
            visitor.update(visitors);
    }

    public static void main(String[] args) {
        launch(Simulation.class);
    }

}