package GUI;

import GUI.Components.CreateLesson;
import GUI.Components.Gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIMain extends Application {

    private Gui gui = new Gui();
    private CreateLesson createLesson = new CreateLesson();
    private Stage createWindow = new Stage();
    private Scene createWindowScene = new Scene(createLesson);
    private Scene mainWindow = new Scene(gui);

    public static void main(String[] args) {
        launch("Gui.java");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(mainWindow);
        primaryStage.setTitle("School Planner");
        buttonhandler();
        primaryStage.show();
    }

    public void buttonhandler() {
        createWindow.initModality(Modality.APPLICATION_MODAL);
        gui.getButton().setOnAction(event -> {

            createWindow.setScene(createWindowScene);
            createWindow.setTitle("CreateLesson a new Lesson");
            createWindow.show();
        });
        //closes add lesson window
        createLesson.getButton1().setOnAction(event -> createWindow.close());
        //saves lesson to a object and closes window WIP!
        createLesson.getButton0().setOnAction(event -> createWindow.close());
        //opens window to add groups WIP!
        createLesson.getButton().setOnAction(event -> System.out.println("GROUP WIP"));
        //will open windows explorer to save object to file.
        gui.getButton2().setOnAction(event -> {

        });
        //will open windows explorer to open a file with object.
        gui.getButton2().setOnAction(event -> {

        });
        // will let you select a lesson to view/change, will load in all information.
        gui.getButton0().setOnAction(event -> {

        });
    }
}
