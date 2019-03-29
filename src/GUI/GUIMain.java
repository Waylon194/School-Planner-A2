package GUI;

import Data.*;
import GUI.Components.*;
import Simulation.Simulation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.joda.time.Hours;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

public class GUIMain extends Application {
    Agenda agenda = new Agenda();
    private Gui gui = new Gui(agenda);
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
    private Stage errorStage = new Stage();
    private Button btnSubmit;
    private FileController fileController = new FileController();
    private Teacher selectedTeacher;
    private Classroom selectedClassroom;
    private Subject selectedSubject;
    private boolean teachHasLessons = false;
    private boolean classHasLessons = false;
    private boolean subjectUsed = false;


    FileChooser fileChooser = new FileChooser();

    public GUIMain() throws Exception {
    }


    public static void main(String[] args) {
        launch("GUIMain.java");
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
        primaryStage.setWidth(855);
        primaryStage.setHeight(700);
        primaryStage.setScene(mainWindow);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("School Planner");
        buttonhandler();
        update();
        primaryStage.show();
    }

    public void buttonhandler()  {

        gui.getTab1().setOnSelectionChanged(e -> {
            if (gui.getTab1().isSelected()){
                try {
                    sim.startSim(primaryStage);
                    gui.getTab1().setContent(sim.getCanvas());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        createLessonWindow.initModality(Modality.APPLICATION_MODAL);
        createGroupWindow2.initModality(Modality.APPLICATION_MODAL);
        createViewWindow.initModality(Modality.APPLICATION_MODAL);

        gui.getBtnAddLesson().setOnAction(event -> {
            createLessonWindow.setScene(windowScene);
            createLessonWindow.setTitle("Create Lesson");
            createLessonWindow.show();
            update();
        });

        //closes add lesson window
        createLesson.getButtonCancelLesson().setOnAction(event -> createLessonWindow.close());
        //saves lesson to a object and closes window WIP!
        createLesson.getButtonSaveLesson().setOnAction(event -> {

            try{
                boolean oneOfMillionConditions = true;
                ArrayList<Teacher> teachers = getSelectedTeachers(this.agenda);
                System.out.println(teachers);
                Interval lessonInterval = new Interval(createLesson.getChosenStartTime(),createLesson.getChosenEndTime());
                ArrayList<Group> groups = getSelectedGroups();
                Classroom classroom = createLesson.getChosenClasroom();
                int popularity = createLesson.getPopularity();
                Subject subject = createLesson.getChosenSubject();

                for (Teacher teacher: teachers) {
                    if (!teacher.isAvailable(lessonInterval)) {
                        createErrorStage(new Label(teacher + "is not available at this time"));
                        errorStage.show();
                        oneOfMillionConditions = false;
                    }
                }
                for(Group group: groups) {
                    if (!group.isAvailable(lessonInterval)) {
                        createErrorStage(new Label(group + "is not available at this time"));
                        errorStage.show();
                        oneOfMillionConditions = false;
                    }
                }
                if (!classroom.isAvailable(lessonInterval)){
                    oneOfMillionConditions = false;
                    createErrorStage(new Label(classroom + "is not available at this time"));
                }

                if(oneOfMillionConditions){

                teachers.forEach(teacher -> {
                    teacher.makeUnavailable(lessonInterval);
                });

                groups.forEach(group -> {
                    group.makeUnavailable(lessonInterval);
                });

                classroom.makeUnavailable(lessonInterval);

                Lesson lesson = new Lesson(teachers,classroom,groups,subject,lessonInterval,popularity);
                agenda.addLesson(lesson);
                createLessonWindow.close();
                update();
                updateScene();
                }
            }
            catch (Exception exception){
                createErrorStage(new Label("Begin time can not be after end time"));
                errorStage.show();
                exception.printStackTrace();
            }
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
            System.out.println(agenda.getLessons().size());
        });

//        gui.getBtnAddLesson().setOnAction(event -> {
//            createLessonWindow.setScene(windowScene);
//            createLessonWindow.setTitle("Create Lesson");
//            createLessonWindow.show();
//            update();
//        });

        gui.getBtnChangeLesson().setOnAction(e -> {
            createViewWindow.setScene(viewScene);
            createViewWindow.setTitle("Change/View");
            createViewWindow.show();
            update();
        });


        gui.getBtnAddTeacher().setOnAction(e -> {
            ArrayList<Label> labelArrayList = new ArrayList<>();
            ArrayList<TextField> txtFieldArray = new ArrayList<>();

            GridPane gridPane = new GridPane();
            Button btnSubmit = new Button("Submit");

            Label lblFirstName = new Label("First name:");
            labelArrayList.add(lblFirstName);
            Label lblAdditive = new Label("Additive:");
            labelArrayList.add(lblAdditive);
            Label lblLastName = new Label("Last name:");
            labelArrayList.add(lblLastName);
            Label lblAge = new Label("Age:");
            labelArrayList.add(lblAge);
            Label lblTeachNumber = new Label("Teacher number:");
            labelArrayList.add(lblTeachNumber);

            TextField txtFirstName = new TextField();
            txtFieldArray.add(txtFirstName);
            TextField txtAdditive = new TextField();
            txtFieldArray.add(txtAdditive);
            TextField txtLastName = new TextField();
            txtFieldArray.add(txtLastName);
            TextField txtAge = new TextField();
            txtFieldArray.add(txtAge);
            TextField txtTeachNumber = new TextField();
            txtFieldArray.add(txtTeachNumber);

            for(int i = 0; i < labelArrayList.size(); i++) {
                gridPane.add(labelArrayList.get(i), 1, i);
                gridPane.add(txtFieldArray.get(i), 2, i);
            }

            gridPane.setPadding(new Insets(20, 20, 20, 20));
            gridPane.setVgap(20);
            gridPane.setHgap(20);
            gridPane.add(btnSubmit, 3, labelArrayList.size() + 1);

            Scene scene = new Scene(gridPane);

            btnSubmit.setOnAction(event -> {
                if(!txtFirstName.getText().isEmpty()
                        && !txtLastName.getText().isEmpty()
                        && !txtAge.getText().isEmpty()
                        && !txtTeachNumber.getText().isEmpty()) {
                    try{
                        Teacher newTeacher = new Teacher(txtFirstName.getText(), txtAdditive.getText(), txtLastName.getText(), Integer.parseInt(txtAge.getText()),
                                0, 0, txtTeachNumber.getText());
                        createViewWindow.close();

                        agenda.addTeacher(newTeacher);
                        createTeacherWindow.update();
                    }
                    catch (Exception exception){
                        createErrorStage(new Label("Age has to be a numeric value"));
                        this.errorStage.show();
                    }
                }
                else {
                    createErrorStage(new Label("Enter all needed values"));
                    this.errorStage.show();
                }
            });
            createViewWindow.setScene(scene);
            createViewWindow.show();
        });

        gui.getBtnChangeTeacher().setOnAction(e -> {
            ArrayList<Label> labelArrayList = new ArrayList<>();
            ArrayList<TextField> txtFieldArray = new ArrayList<>();

            ChoiceBox choiceBox = new ChoiceBox();
            for(Teacher teacher : agenda.getTeachers()) {
                choiceBox.getItems().add(teacher);
            }
            choiceBox.setValue(choiceBox.getItems().get(0));

            GridPane gridPane = new GridPane();
            Button btnSubmit = new Button("Change");
            Button btnRemoval = new Button("Remove");

            Label lblFirstName = new Label("First name:");
            labelArrayList.add(lblFirstName);
            Label lblAdditive = new Label("Additive:");
            labelArrayList.add(lblAdditive);
            Label lblLastName = new Label("Last name:");
            labelArrayList.add(lblLastName);
            Label lblAge = new Label("Age:");
            labelArrayList.add(lblAge);
            Label lblTeachNumber = new Label("Teacher number:");
            labelArrayList.add(lblTeachNumber);

            TextField txtFirstName = new TextField();
            txtFieldArray.add(txtFirstName);
            TextField txtAdditive = new TextField();
            txtFieldArray.add(txtAdditive);
            TextField txtLastName = new TextField();
            txtFieldArray.add(txtLastName);
            TextField txtAge = new TextField();
            txtFieldArray.add(txtAge);
            TextField txtTeachNumber = new TextField();
            txtFieldArray.add(txtTeachNumber);

            choiceBox.getSelectionModel().selectedItemProperty().addListener((value, oldValue, newValue) -> {
                selectedTeacher = (Teacher) newValue;
                txtFirstName.setText(selectedTeacher.getFirstName());
                txtAdditive.setText(selectedTeacher.getAdditive());
                txtLastName.setText(selectedTeacher.getLastName());
                txtAge.setText("" + selectedTeacher.getAge());
                txtTeachNumber.setText(selectedTeacher.getTeacherNumber());
            });

            btnSubmit.setOnAction(event -> {
                ArrayList<Interval> intervals = agenda.getIntervals();

                for(Interval interval : intervals) {
                    if(!selectedTeacher.isAvailable(interval)) {
                        teachHasLessons = true;
                        System.out.println("This teacher has lessons");
                        break;
                    }
                }

                if(teachHasLessons) {
                    teachHasLessons = false;
                    createErrorStage(new Label("This teacher has lessons planned"));
                    errorStage.show();
                } else {
                    Teacher newTeacher = new Teacher(txtFirstName.getText(), txtAdditive.getText(), txtLastName.getText(), Integer.parseInt(txtAge.getText()),
                            0, 0, txtTeachNumber.getText());
                    agenda.addTeacher(newTeacher);
                    agenda.getTeachers().remove(selectedTeacher);
                }
                    createViewWindow.close();
                    createTeacherWindow.update();
                });

            btnRemoval.setOnAction(event -> {
                ArrayList<Interval> intervals = agenda.getIntervals();

                for(Interval interval : intervals) {
                    if(!selectedTeacher.isAvailable(interval)) {
                        teachHasLessons = true;
                        System.out.println("This teacher has lessons");
                        break;
                    }
                }

                if(teachHasLessons) {
                    teachHasLessons = false;
                    createErrorStage(new Label("This teacher has lessons planned"));
                    errorStage.show();
                } else {
                    agenda.getTeachers().remove(selectedTeacher);
                }

                createViewWindow.close();
                createTeacherWindow.update();
            });

            for(int i = 0; i < labelArrayList.size(); i++) {
                gridPane.add(labelArrayList.get(i), 1, i);
                gridPane.add(txtFieldArray.get(i), 2, i);
            }

            gridPane.setPadding(new Insets(20, 20, 20, 20));
            gridPane.setVgap(20);
            gridPane.setHgap(20);
            gridPane.add(btnSubmit, 4, labelArrayList.size() + 1);
            gridPane.add(btnRemoval, 3, labelArrayList.size() + 1);
            gridPane.add(choiceBox, 3, 0);

            Scene scene = new Scene(gridPane);

            createViewWindow.setScene(scene);
            createViewWindow.show();
        });

        gui.getBtnAddClassroom().setOnAction(event -> {
            ArrayList<Label> labelArrayList = new ArrayList<>();
            ArrayList<TextField> txtArrayList = new ArrayList<>();

            Label lblSeats = new Label("Amount of seats:");
            labelArrayList.add(lblSeats);
            Label lblLocation = new Label("Location:");
            labelArrayList.add(lblLocation);
            
            TextField txtSeat = new TextField();
            txtArrayList.add(txtSeat);
            TextField txtLocation = new TextField();
            txtArrayList.add(txtLocation);

            Button btnSubmit = new Button("Submit");

            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(20, 20, 20, 20));
            gridpane.setHgap(20);
            gridpane.setVgap(20);

            for(int i = 0; i < labelArrayList.size(); i++) {
                gridpane.add(labelArrayList.get(i), 1, i);
                gridpane.add(txtArrayList.get(i), 2, i);
            }
            gridpane.add(btnSubmit, 3, labelArrayList.size() + 1);

            btnSubmit.setOnAction(e -> {
                if(!(txtSeat.getText().isEmpty()) && !(txtLocation.getText().isEmpty())){
                    try{
                        Integer.parseInt(txtSeat.getText());
                        System.out.println(agenda.getClassrooms().size());
                        Classroom newClassroom = new Classroom(agenda.getClassrooms().size() +1, Integer.parseInt(txtSeat.getText()), txtLocation.getText(), true, true);
                        agenda.addClassroom(newClassroom);
                        gui.addClassroomGrid();
                        createLesson.update();
                        createViewWindow.close();
                    }
                    catch (Exception exception){
                        createErrorStage(new Label("Capacity has to be a numeric value"));
                        this.errorStage.show();
                    }
                }
                else {
                    createErrorStage(new Label("Enter classroom and/or capacity"));
                    this.errorStage.show();
                }
            });

            Scene scene = new Scene(gridpane);
            createViewWindow.setScene(scene);
            createViewWindow.show();
            update();
        });

        gui.getBtnChangeClassroom().setOnAction(event -> {
            ArrayList<Label> labelArrayList = new ArrayList<>();

            ChoiceBox choiceBox = new ChoiceBox();
            for(Classroom classroom : agenda.getClassrooms()) {
                choiceBox.getItems().add(classroom);
            }
            choiceBox.setValue(choiceBox.getItems().get(0));

            Label lblSeats = new Label("Amount of seats:");
            labelArrayList.add(lblSeats);
            Label lblLocation = new Label("Location:");
            labelArrayList.add(lblLocation);

            Label lblLocationDisplay = new Label("");

            TextField txtSeat = new TextField();

            choiceBox.getSelectionModel().selectedItemProperty().addListener((value, oldValue, newValue) -> {
                selectedClassroom = (Classroom) newValue;
                lblLocationDisplay.setText(selectedClassroom.getLocation());
                txtSeat.setText("" + selectedClassroom.getCapacity());
            });

            Button btnChange = new Button("Change");

            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(20, 20, 20, 20));
            gridpane.setHgap(20);
            gridpane.setVgap(20);

            for(int i = 0; i < labelArrayList.size(); i++) {
                gridpane.add(labelArrayList.get(i), 1, i);
            }
            gridpane.add(txtSeat, 2, 0);
            gridpane.add(lblLocationDisplay, 2, 1);
            gridpane.add(btnChange, 3, labelArrayList.size() + 1);
            gridpane.add(choiceBox, 2, labelArrayList.size() + 1);

            btnChange.setOnAction(e -> {
                ArrayList<Interval> intervals = agenda.getIntervals();
                for(Interval interval : intervals) {
                    if(!selectedClassroom.isAvailable(interval)) {
                        classHasLessons = true;
                        break;
                    }
                }

                if(classHasLessons) {
                    classHasLessons = false;
                    createErrorStage(new Label("This classroom has lessons planned."));
                    errorStage.show();
                } else {
                    if(!(txtSeat.getText().isEmpty())){
                        try{
                            int counter = 0;
                            Integer.parseInt(txtSeat.getText());
                            System.out.println(agenda.getClassrooms().size());
                            Classroom newClassroom = new Classroom(agenda.getClassrooms().size() +1, Integer.parseInt(txtSeat.getText()), lblLocation.getText(), true, true);
                            agenda.getClassrooms().remove(selectedClassroom);
                            agenda.getClassrooms().add(counter, newClassroom);
                            gui.addClassroomGrid();
                            createLesson.update();
                            createViewWindow.close();
                        }
                        catch (Exception exception){
                            createErrorStage(new Label("Capacity has to be a numeric value"));
                            this.errorStage.show();
                        }
                    }
                    else {
                        createErrorStage(new Label("Enter classroom and/or capacity"));
                        this.errorStage.show();
                    }
                }
            });

            Scene scene = new Scene(gridpane);
            createViewWindow.setScene(scene);
            createViewWindow.show();
        });

        gui.getBtnAddSubject().setOnAction(event -> {

            Label subjectLable = new Label("Subject: ");
            TextField subjectTextField = new TextField();
            Button btnSubmit = new Button("Submit");

            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(20, 20, 20, 20));
            gridpane.setHgap(20);
            gridpane.setVgap(20);

            gridpane.add(subjectLable,1,0);
            gridpane.add(subjectTextField,2,0);
            gridpane.add(btnSubmit, 3, 0);

            btnSubmit.setOnAction(e -> {

                if(!(subjectTextField.getText().isEmpty())) {
                    Subject newSubject = new Subject(subjectTextField.getText());
                    agenda.addSubject(newSubject);
                    createLesson.update();
                    createViewWindow.close();
                }
                else{
                    Label errorLabel = new Label("You can not create an empty subject");
                    createErrorStage(errorLabel);
                    this.errorStage.show();
                }
            });

            Scene scene = new Scene(gridpane);
            createViewWindow.setScene(scene);
            createViewWindow.show();
            update();
        });

        gui.getBtnChangeSubject().setOnAction(e -> {
            Label lblSubject = new Label("Subject: ");
            TextField txtSubject = new TextField();
            Button btnChange = new Button("Change");
            Button btnRemove = new Button("Remove");
            ChoiceBox choiceBox = new ChoiceBox();

            for(Subject subject : agenda.getSubjects()) {
                choiceBox.getItems().add(subject);
            }
            choiceBox.setValue(choiceBox.getItems().get(0));

            choiceBox.getSelectionModel().selectedItemProperty().addListener((value, oldValue, newValue) -> {
                selectedSubject = (Subject) newValue;
                txtSubject.setText(selectedSubject.toString());
            });

            btnRemove.setOnAction(event -> {
                agenda.getSubjects().remove(selectedSubject);
                createLesson.update();
                createViewWindow.close();
            });

            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(20, 20, 20, 20));
            gridpane.setHgap(20);
            gridpane.setVgap(20);

            gridpane.add(lblSubject, 1, 0);
            gridpane.add(txtSubject, 2, 0);
            gridpane.add(choiceBox, 3, 0);
            gridpane.add(btnChange, 3, 1);
            gridpane.add(btnRemove, 1, 1);

            Scene scene = new Scene(gridpane);
            createViewWindow.setScene(scene);
            createViewWindow.show();
            update();
        });

        createLesson.getButtonGroup().setOnAction(event -> {
            createGroupWindow2.setScene(groupWindow);
            createGroupWindow2.setTitle("Select group(s):");
            createGroupWindow2.show();
            update();
        });

        createGroupWindow.getSaveGroupsButton().setOnAction(event -> {
            createGroupWindow2.close();
            update();
            System.out.println(getSelectedGroups());
        });

        createLesson.getButtonTeachers().setOnAction(event -> {
            createTeacherWindowStage.setScene(teacherWindow);
            createTeacherWindowStage.setTitle("Select Teacher(s):");
            createTeacherWindowStage.show();
            update();
        });

        createTeacherWindow.getSaveTeachersButton().setOnAction(event -> {
            createTeacherWindowStage.close();
            update();
            System.out.println(getSelectedTeachers(this.agenda));
            for(Classroom classroom: agenda.getClassrooms()){
                System.out.println(classroom.getNumber());
            }
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

    public ArrayList<Teacher> getSelectedTeachers(Agenda agenda) {
        ArrayList<Teacher> selected = new ArrayList<>();
        int i = 0;
        for (CheckBox checkBox : createTeacherWindow.getCheckBoxes()) {
            if (checkBox.isSelected()) {
                selected.add(agenda.getTeachers().get(i));
                System.out.println(i);  //TODO WHYYYYYYYYYYYYYYYYYYYY IT BEGINS AT 7
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



    public void createErrorStage(Label label) {
        this.btnSubmit = new Button("OK");
        GridPane gridpane = new GridPane();
        gridpane.add(label, 2, 1);
        gridpane.add(this.btnSubmit, 3, 3);
        gridpane.setPadding(new Insets(20, 20, 20, 20));
        gridpane.setVgap(20);
        gridpane.setHgap(20);
        Scene temp = new Scene(gridpane);
        this.errorStage.setScene(temp);

        this.btnSubmit.setOnAction(e -> {
            this.errorStage.close();
        });
    }
}