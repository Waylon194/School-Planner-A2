package GUI;

import Data.Database;
import Data.Group;
import Data.Lesson;
import GUI.Components.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.joda.time.Interval;

import java.util.ArrayList;

public class GUIMain extends Application {


    Database database = new Database();

    private Gui gui = new Gui();

    private CreateLesson createLesson = new CreateLesson(database);
    private CreateView createView = new CreateView(database, this);
    private CreateGroupWindow createGroupWindow = new CreateGroupWindow(database);

    private Stage createLessonWindow = new Stage();
    private Stage createGroupWindow2 = new Stage();
    private Stage createViewWindow = new Stage();

    private Scene viewScene = new Scene(createView);
    private Scene windowScene = new Scene(createLesson);
    private Scene mainWindow = new Scene(gui);
    private Scene groupWindow = new Scene(createGroupWindow);
    private FileController fileController = new FileController();


    FileChooser fileChooser = new FileChooser();


    public static void main(String[] args) {
        launch("Gui.java");


    }


    public void updateScene(){



        createViewWindow.close();
        this.createView = new CreateView(database,this);
        this.viewScene = new Scene(createView);
        createViewWindow.setScene(viewScene);



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
        createViewWindow.initModality(Modality.APPLICATION_MODAL);

        gui.getButton().setOnAction(event -> {

            createLessonWindow.setScene(windowScene);
            createLessonWindow.setTitle("CreateLesson a new Lesson");
            createLessonWindow.show();
        });

        //closes add lesson window
        createLesson.getButtonCancelLesson().setOnAction(event -> createLessonWindow.close());

        //saves lesson to a object and closes window WIP!
        createLesson.getButtonSaveLesson().setOnAction(event -> {


           database.returnLessons().add(new Lesson(createLesson.getChosenTeacher(),createLesson.getChosenClasroom(),getSelectedGroups(),createLesson.getChosenSubject(),new Interval(createLesson.getChosenStartTime(),createLesson.getChosenEndTime())));
            updateScene();
            createLessonWindow.close();

        });

        //opens window to add groups WIP!
        createLesson.getButtonGroup().setOnAction(event -> {
            createGroupWindow2.setScene(groupWindow);
            createGroupWindow2.setTitle("Select groups:");
            createGroupWindow2.show();

        });

        //will open windows explorer to save object to file.
        gui.getButton1().setOnAction(event -> {
            fileController.saveFile(createViewWindow, database.returnAgenda());


        });

        //will open windows explorer to open a file with object.
        gui.getButton2().setOnAction(event -> {
            database.setAgenda(fileController.openFile(createViewWindow));
        });

        // will let you select a lesson to view/change, will load in all information.
        gui.getButton0().setOnAction(event -> {
            createViewWindow.setScene(viewScene);
            createViewWindow.setTitle("Change/View");
            createViewWindow.show();
        });

        createGroupWindow.getSaveGroupsButton().setOnAction(event -> {

            System.out.println(getSelectedGroups());
            createGroupWindow2.close();


    });
    }

    public ArrayList<Group> getSelectedGroups(){
        ArrayList<Group> selected = new ArrayList<>();
        int i = 0;

        for (CheckBox checkBox : createGroupWindow.getCheckBoxes()) {
            if(checkBox.isSelected()) {
                selected.add(database.getGroups().get(i));
            }
            i++;

    }
    return selected;


    }

}
