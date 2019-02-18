package GUI;

import Data.*;
import GUI.Components.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.joda.time.Hours;
import org.joda.time.Interval;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUIMain extends Application {


    Agenda agenda = new Agenda();

    private Gui gui = new Gui();

    private CreateLesson createLesson = new CreateLesson(agenda);
    private CreateView createView = new CreateView(agenda, this);
    private CreateGroupWindow createGroupWindow = new CreateGroupWindow(agenda);
    private CreateTeacherWindow createTeacherWindow = new CreateTeacherWindow(agenda);

    private Stage createLessonWindow = new Stage();
    private Stage createGroupWindow2 = new Stage();
    private Stage createViewWindow = new Stage();
    private Stage createTeacherWindowStage = new Stage();

    private Scene viewScene = new Scene(createView);
    private Scene windowScene = new Scene(createLesson);
    private Scene mainWindow = new Scene(gui);
    private Scene groupWindow = new Scene(createGroupWindow);
    private Scene teacherWindow = new Scene(createTeacherWindow);
    private FileController fileController = new FileController();
    private boolean condition = true;


    FileChooser fileChooser = new FileChooser();


    public static void main(String[] args) {
        launch("Gui.java");
    }


    public void updateScene() {
        createViewWindow.close();
        this.createView = new CreateView(agenda, this);
        this.viewScene = new Scene(createView);
        createViewWindow.setScene(viewScene);
    }

    public void update() {
        drawSchedule();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(mainWindow);
        primaryStage.setTitle("School Planner");
        buttonhandler();
        update();
        primaryStage.show();
    }

    public void buttonhandler()  {
        createLessonWindow.initModality(Modality.APPLICATION_MODAL);
        createGroupWindow2.initModality(Modality.APPLICATION_MODAL);
        createViewWindow.initModality(Modality.APPLICATION_MODAL);

        gui.getBtnAddLesson().setOnAction(event -> {

            createLessonWindow.setScene(windowScene);
            createLessonWindow.setTitle("CreateLesson a new Lesson");
            createLessonWindow.show();
            update();
        });

        //closes add lesson window
        createLesson.getButtonCancelLesson().setOnAction(event -> createLessonWindow.close());

        //saves lesson to a object and closes window WIP!
        createLesson.getButtonSaveLesson().setOnAction(event -> {

            boolean teachers = false;
            boolean classroom = false;
            boolean groups = false;
            boolean subject = false;
            boolean beginTime = false;
            boolean endTime = false;

            if (getSelectedTeachers().size()>0){
                teachers = true;
            } else{
                System.out.println("Choose Teacher!");
            }


            if (!(createLesson.getClassroomComboBox().getSelectionModel().isEmpty())){
                classroom = true;
            }else {
                System.out.println("Choose classroom!");
            }

            if(getSelectedGroups().size()>0){
                groups = true;
            }else {
                System.out.println("Select groups!");
            }

            if (!(createLesson.getSubjectComboBox().getSelectionModel().isEmpty())){
                subject = true;
            }else{
                System.out.println("Choose subject!");
            }

            if(!(createLesson.getComboStartTime().getSelectionModel().isEmpty())){
                beginTime = true;
            }else{
                System.out.println("Choose begin time!");
            }
            if(!(createLesson.getComboEndTime().getSelectionModel().isEmpty())){
                endTime = true;
            }else{
                System.out.println("Choose end time!");
            }

            if(createLesson.getChosenStartTime()!=null
                    &&createLesson.getChosenEndTime()!=null
                    && (createLesson.getChosenEndTime().isAfter(createLesson.getChosenStartTime())
                    ||createLesson.getChosenEndTime().isEqual(createLesson.getChosenStartTime()))) {
                Interval interval = new Interval(createLesson.getChosenStartTime(), createLesson.getChosenEndTime());

                getSelectedTeachers().forEach((key, value) -> {

                    if (!(value.isAvailable(interval))) {
                        this.condition = false;
                        System.out.println("Teacher " + value + " is not available at this time");
                        update();
                        updateScene();
                        createLessonWindow.close();
                    } else {
                        this.condition = true;
                    }
                });


                if (!(createLesson.getChosenClasroom().isAvailable(interval))) {
                    this.condition = false;
                    System.out.println(createLesson.getChosenClasroom() + "is not available at " + interval);
                } else {
                    this.condition = true;
                }


                getSelectedGroups().forEach(group -> {
                    if (!(group.isAvailable(interval))) {
                        this.condition = false;
                        System.out.println(group + " is already planned at " + interval);
                    } else {
                        this.condition = true;
                    }
                });


                if (teachers && classroom && groups && subject && beginTime && endTime && this.condition) {

                    //TODO: fix the addLesson->deleteLesson -> addLesson (not possible) BUG!

                    agenda.returnLessons().add(new Lesson(getSelectedTeachers(), createLesson.getChosenClasroom(), getSelectedGroups(), createLesson.getChosenSubject(), interval));
                    updateScene();
                    update();
                    createLessonWindow.close();

                    createLesson.getChosenClasroom().makeUnavailable(interval);
                    for (Group selectedGroup : getSelectedGroups()) {
                        selectedGroup.makeUnavailable(interval);
                    }

                    getSelectedTeachers().forEach((key, value) -> {
                        agenda.getTeachers().get(key).makeUnavailable(interval);
                    });
                }
            }




        });

        //opens window to add groups WIP!
        createLesson.getButtonGroup().setOnAction(event -> {
            createGroupWindow2.setScene(groupWindow);
            createGroupWindow2.setTitle("Select groups:");
            createGroupWindow2.show();
            update();
        });

        //will open windows explorer to save object to file.
        gui.getBtnSaveSchedule().setOnAction(event -> {
            fileController.saveFile(createViewWindow, agenda);
            update();

        });

        //will open windows explorer to open a file with object.
        gui.getBtnOpenSchedule().setOnAction(event -> {
            agenda = (fileController.openFile(createViewWindow));
            update();
        });

        // will let you select a lesson to view/change, will load in all information.
        gui.getBtnViewLesson().setOnAction(event -> {
            createViewWindow.setScene(viewScene);
            createViewWindow.setTitle("Change/View");
            createViewWindow.show();
            update();
        });

        createGroupWindow.getSaveGroupsButton().setOnAction(event -> {

            createGroupWindow2.close();
            update();

        });

        createLesson.getButtonTeachers().setOnAction(event -> {

            createTeacherWindowStage.setScene(teacherWindow);
            createTeacherWindowStage.setTitle("Select Teachers:");
            createTeacherWindowStage.show();
        });

        createTeacherWindow.getSaveTeachersButton().setOnAction(event -> {
            createTeacherWindowStage.close();
           update();
        });


    }

    public ArrayList<Group> getSelectedGroups() {
        ArrayList<Group> selected = new ArrayList<>();
        int i = 0;

        for (CheckBox checkBox : createGroupWindow.getCheckBoxes()) {
            if (checkBox.isSelected()) {
                selected.add(agenda.getGroups().get(i));
            }
            i++;

        }
        return selected;
    }

    public HashMap<String, Teacher> getSelectedTeachers() {
      HashMap<String,Teacher> selected = new HashMap<>();
        int i = 0;
        String number= "";

        for (CheckBox checkBox : createTeacherWindow.getCheckBoxes()) {
            if (checkBox.isSelected()) {
               number = checkBox.toString().substring(checkBox.toString().length()-4,checkBox.toString().length()-1);
               selected.put(number, agenda.getTeachers().get(number));
            }
            i++;
        }
        return selected;
    }

    public void drawSchedule() {
        gui.clear();
        List<Lesson> lessons = agenda.getLessons();
        lessons.forEach(lesson -> {

            Hours hours = Hours.hoursBetween(lesson.getInterval().getStart(), lesson.getInterval().getEnd());
            int duration = Integer.parseInt(hours.toString().substring(2, 3));

            int start = lesson.getInterval().getStart().getHourOfDay();
            System.out.println(start);
            switch (start) {

                case 9:
                    gui.drawLessonBlock(1, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 10:
                    gui.drawLessonBlock(2, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 11:
                    gui.drawLessonBlock(3, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 12:
                    gui.drawLessonBlock(4, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 13:
                    gui.drawLessonBlock(5, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 14:
                    gui.drawLessonBlock(6, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 15:
                    gui.drawLessonBlock(7, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 16:
                    gui.drawLessonBlock(8, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
                case 17:
                    gui.drawLessonBlock(9, lesson.getClassroom().getNumber(), duration,lesson);
                    break;
            }
        });
    }

    public void setCondition(Boolean condition){
        this.condition = condition;
    }
}
