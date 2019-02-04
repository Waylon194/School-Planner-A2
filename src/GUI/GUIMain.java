package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class GUIMain extends Application {

    public static void main(String[] args) {
	launch("Gui.java");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Gui.Gui gui = new Gui.Gui();
        primaryStage.setScene(new Scene(gui));
        primaryStage.setTitle("School Planner");
        primaryStage.show();
    }
}
