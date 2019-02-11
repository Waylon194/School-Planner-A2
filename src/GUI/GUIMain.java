package GUI;

import GUI.Components.CreateGroupWindow;
import GUI.Components.CreateLesson;
import GUI.Components.Gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIMain extends Application {

    private Gui gui = new Gui();
    private CreateLesson createLesson = new CreateLesson();
    private CreateGroupWindow createGroupWindow = new CreateGroupWindow();
    private Stage createLessonWindow = new Stage();
    private Stage createGroupWindow2 = new Stage();
    private Scene createWindowScene = new Scene(createLesson);
    private Scene mainWindow = new Scene(gui);
    private Scene groupWindow = new Scene(createGroupWindow);

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
        createLessonWindow.initModality(Modality.APPLICATION_MODAL);
        createGroupWindow2.initModality(Modality.APPLICATION_MODAL);

        gui.getButton().setOnAction(event -> {

            createLessonWindow.setScene(createWindowScene);
            createLessonWindow.setTitle("CreateLesson a new Lesson");
            createLessonWindow.show();
        });
        //closes add lesson window
        createLesson.getButtonCancelLesson().setOnAction(event -> createLessonWindow.close());
        //saves lesson to a object and closes window WIP!
        createLesson.getButtonSaveLesson().setOnAction(event -> {

            createLessonWindow.close();
        });
        //opens window to add groups WIP!
        createLesson.getButtonGroup().setOnAction(event -> {
            createGroupWindow2.setScene(groupWindow);
            createGroupWindow2.setTitle("Select groups:");
            createGroupWindow2.show();

        });
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
