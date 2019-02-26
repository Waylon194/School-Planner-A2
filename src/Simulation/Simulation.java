package Simulation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulation extends Application {

    private Tileset tileset;
    private Canvas canvas;

    public Simulation() throws IOException, ParseException {
        tileset = new Tileset();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();


    }

    public void draw(FXGraphics2D graphics) throws IOException, ParseException {
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
    
    public static void main(String[] args) {
        launch(Simulation.class);
    }

}
