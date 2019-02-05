package GUI;

import GUI.Components.Create;
import GUI.Components.Gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIMain extends Application {

    Gui gui = new Gui();
    Create create = new Create();
    private Stage createWindow = new Stage();
    private Scene createWindowScene = new Scene(create);


    public static void main(String[] args) {
        launch("Gui.java");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        createWindow.initModality(Modality.APPLICATION_MODAL);
        gui.getButton().setOnAction(event -> {

            createWindow.setScene(createWindowScene);
            createWindow.setTitle("Create a new Lesson");
            createWindow.show();
        });
        create.getButton1().setOnAction(event -> createWindow.close());


        primaryStage.setScene(new Scene(gui));
        primaryStage.setTitle("School Planner");
        primaryStage.show();
    }
}
