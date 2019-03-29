package GUI.Components;

import Data.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Gui extends TabPane {
    private final Tab tabAgenda;
    private final AnchorPane tabAnchorPane;
    private final GridPane gridPane;
    private final ColumnConstraints columnConstraints;
    private final RowConstraints rowConstraints;
    private final Label label14;
    private final Label label17;
    private final Tab tabViewEdit;
    private final Tab tabSimulate;
    private final AnchorPane anchorPane0;
    private final VBox vBoxLeftRow;
    private final VBox vBoxMiddleRow;
    private final VBox vBoxRightRow;
    private final HBox hBoxButtons;
    private final Button btnAddLesson;
    private final Button btnViewLesson;
    private final Button btnSaveSchedule;
    private final Button btnOpenSchedule;
    private final Button btnAddTeacher;
    private final Button btnAddClassroom;
    private final Button btnAddGroup;
    private final Button btnAddSubject;
    private final Button btnChangeLessonTime;
    private final Button btnChangeLesson;
    private final Button btnChangeTeacher;
    private final Button btnChangeClassroom;
    private final Button btnChangeSubject;
    private Canvas simulator = new Canvas();

    public Canvas getSimulator() {
        return simulator;
    }


    Rectangle rectangle;
    private Agenda agenda;
    private List<Label> classroomLabelArray;
    private List<Label> timeLabelArray;
    private List<Node> children = new ArrayList<>();

    public Gui(Agenda agenda) {
        this.agenda = agenda;
        tabAgenda = new Tab("Agenda");
        tabViewEdit = new Tab("View/Edit");
        tabSimulate = new Tab("Simulate");

        this.classroomLabelArray = new ArrayList<>();
        this.timeLabelArray = new ArrayList<>();

        tabSimulate.setContent(simulator);

        tabAnchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        gridPane = new GridPane();

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();

        this.timeLabelArray.add(new Label("09:00"));
        this.timeLabelArray.add(new Label("10:00"));
        this.timeLabelArray.add(new Label("11:00"));
        this.timeLabelArray.add(new Label("12:00"));
        this.timeLabelArray.add(new Label("13:00"));
        this.timeLabelArray.add(new Label("14:00"));
        this.timeLabelArray.add(new Label("15:00"));
        this.timeLabelArray.add(new Label("16:00"));
        this.timeLabelArray.add(new Label("17:00"));

        //TODO: Find purpose?!
        label14 = new Label();
        //TODO: Find purpose?!
        label17 = new Label();

        vBoxLeftRow = new VBox();
        vBoxMiddleRow = new VBox();
        vBoxRightRow = new VBox();

        hBoxButtons = new HBox();

        btnAddLesson = new Button("Add Lesson");
        btnViewLesson = new Button("View Lesson(s)");
        btnSaveSchedule = new Button("Save Schedule");
        btnOpenSchedule = new Button("Open Schedule");
        btnAddTeacher = new Button("Add Teacher");
        btnAddClassroom = new Button("Add Classroom");
        btnAddGroup = new Button("Add Group");
        btnAddSubject = new Button("Add Subject");
        btnChangeLessonTime = new Button("Change Lesson Time");
        btnChangeLesson = new Button("Change Lesson");
        btnChangeClassroom = new Button("Change Classroom Capacity");
        btnChangeSubject = new Button("Change/Remove Subject");
        btnChangeTeacher = new Button("Change/Remove Teacher(s)");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(840.0);
        setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tabAnchorPane.setMinHeight(180);
        tabAnchorPane.setMinWidth(200);
        tabAnchorPane.setPrefHeight(180.0);
        tabAnchorPane.setPrefWidth(200.0);

        gridPane.setGridLinesVisible(true);
        gridPane.setPrefHeight(572.0);
        gridPane.setPrefWidth(900.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(40.0);
        columnConstraints.setMinWidth(40.0);
        columnConstraints.setPrefWidth(40.0);
        gridPane.getColumnConstraints().add(columnConstraints);

        rowConstraints.setMaxHeight(43.0);
        rowConstraints.setMinHeight(31.0);
        rowConstraints.setPrefHeight(31.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane.getRowConstraints().add(rowConstraints);

        for (Classroom classroom : agenda.getClassrooms()) {
            this.classroomLabelArray.add(new Label("     " + classroom.getLocation()));
        }

        for (int i = 0; i < agenda.getClassrooms().size(); i++) {
            RowConstraints row = new RowConstraints(75, 75, 75);
            gridPane.getRowConstraints().add(row);

            ColumnConstraints column = new ColumnConstraints(100, 100, 100);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i = 0; i < this.timeLabelArray.size() - 1; i++) {
            gridPane.add(this.timeLabelArray.get(i), 0, i + 1);
        }

        for (int i = 0; i < this.classroomLabelArray.size(); i++) {
            gridPane.add(this.classroomLabelArray.get(i), i + 1, 0);
        }

        label14.setLayoutX(347.0);
        label14.setLayoutY(13.0);

        tabAgenda.setContent(tabAnchorPane);

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        vBoxLeftRow.setLayoutX(7.0);
        vBoxLeftRow.setSpacing(10.0);

        btnAddLesson.setMnemonicParsing(false);
        VBox.setMargin(btnAddLesson, new Insets(0.0, 0.0, 0.0, 10.0));
        btnAddLesson.setPadding(new Insets(10.0));

        btnViewLesson.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        btnViewLesson.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btnViewLesson.setMnemonicParsing(false);
        VBox.setMargin(btnViewLesson, new Insets(10.0, 0.0, 0.0, 10.0));
        btnViewLesson.setPadding(new Insets(10.0));

        btnSaveSchedule.setMnemonicParsing(false);
        VBox.setMargin(btnSaveSchedule, new Insets(0.0, 0.0, 0.0, 10.0));
        btnSaveSchedule.setPadding(new Insets(10.0));

        btnOpenSchedule.setMnemonicParsing(false);
        VBox.setMargin(btnOpenSchedule, new Insets(0.0, 0.0, 0.0, 10.0));
        btnOpenSchedule.setPadding(new Insets(10.0));
        tabViewEdit.setContent(anchorPane0);

        btnAddTeacher.setMnemonicParsing(false);
        VBox.setMargin(btnAddTeacher, new Insets(10, 0, 0, 10));
        btnAddTeacher.setPadding(new Insets(10));

        btnAddClassroom.setMnemonicParsing(false);
        VBox.setMargin(btnAddClassroom, new Insets(0, 0, 0, 10));
        btnAddClassroom.setPadding(new Insets(10));

        btnAddGroup.setMnemonicParsing(false);
        VBox.setMargin(btnAddGroup, new Insets(0, 0, 0, 10));
        btnAddGroup.setPadding(new Insets(10));

        btnAddSubject.setMnemonicParsing(false);
        VBox.setMargin(btnAddSubject, new Insets(0, 0, 0, 10));
        btnAddSubject.setPadding(new Insets(10));

        btnChangeLessonTime.setMnemonicParsing(false);
        VBox.setMargin(btnChangeLessonTime, new Insets(0, 0, 0, 10));
        btnChangeLessonTime.setPadding(new Insets(10));

        btnAddTeacher.setMnemonicParsing(false);
        VBox.setMargin(btnAddTeacher, new Insets(10, 0, 0, 10));
        btnAddTeacher.setPadding(new Insets(10));

        btnChangeTeacher.setMnemonicParsing(false);
        VBox.setMargin(btnChangeTeacher, new Insets(10, 0, 0, 10));
        btnChangeTeacher.setPadding(new Insets(10));

        btnChangeLesson.setMnemonicParsing(false);
        VBox.setMargin(btnChangeLesson, new Insets(10, 0, 0, 10));
        btnChangeLesson.setPadding(new Insets(10));

        btnChangeClassroom.setMnemonicParsing(false);
        VBox.setMargin(btnChangeClassroom, new Insets(10, 0, 0, 10));
        btnChangeClassroom.setPadding(new Insets(10));

        btnChangeSubject.setMnemonicParsing(false);
        VBox.setMargin(btnChangeSubject, new Insets(10, 0, 0, 10));
        btnChangeSubject.setPadding(new Insets(10));

        vBoxLeftRow.getChildren().addAll(btnViewLesson, btnSaveSchedule, btnOpenSchedule);
        vBoxMiddleRow.getChildren().addAll(btnAddTeacher, btnAddLesson, btnAddClassroom, btnAddSubject);
        vBoxRightRow.getChildren().addAll(btnChangeTeacher, btnChangeLesson, btnChangeClassroom, btnChangeSubject);
        vBoxMiddleRow.setSpacing(10);

        hBoxButtons.getChildren().addAll(vBoxLeftRow, vBoxMiddleRow, vBoxRightRow);
        hBoxButtons.setSpacing(150);

        tabAnchorPane.getChildren().add(gridPane);
        anchorPane0.getChildren().add(hBoxButtons);

        getTabs().addAll(tabViewEdit, tabAgenda, tabSimulate);

        children.addAll(gridPane.getChildren());
    }

    public Tab getTabSimulate() {
        return tabSimulate;
    }

    public Button getBtnAddLesson() {
        return btnAddLesson;
    }

    public Button getBtnViewLesson() {
        return btnViewLesson;
    }

    public Button getBtnSaveSchedule() {
        return btnSaveSchedule;
    }

    public Button getBtnOpenSchedule() {
        return btnOpenSchedule;
    }

    public Button getBtnAddTeacher() {
        return btnAddTeacher;
    }

    public Button getBtnAddClassroom() {
        return btnAddClassroom;
    }

    public Button getBtnAddSubject() {
        return btnAddSubject;
    }

    public Button getBtnChangeLesson() {
        return btnChangeLesson;
    }

    public Button getBtnChangeTeacher() {
        return btnChangeTeacher;
    }

    public Button getBtnChangeClassroom() {
        return btnChangeClassroom;
    }

    public Button getBtnChangeSubject() {
        return btnChangeSubject;
    }


    public void drawLesson(int lesson, int classRoom) {
        rectangle = new Rectangle();
        rectangle.setSmooth(true);
        rectangle.setFill(Color.BEIGE);
        rectangle.setHeight(gridPane.getRowConstraints().get(classRoom - 1).getMaxHeight()+ 34);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(gridPane.getColumnConstraints().get(classRoom).getMaxWidth());
        GridPane.setColumnIndex(rectangle, classRoom);
        GridPane.setRowIndex(rectangle, lesson);
        gridPane.getChildren().add(rectangle);
    }

    public void drawLessonBlock(int startTime, int classRoom, int duration, Lesson lesson) {
        String groups = "";
        System.out.println("Classroom: " + classRoom);
        for (Group group : lesson.getGroups()) {
            groups += group.getGroupName() + " ";

        }
        String teachers = "";
        for (Teacher teacher : lesson.getTeachers()) {
            teachers += " " + teacher.getLastName();
        }
        Label label = new Label("" + lesson.getTeachers() + '\n' + lesson.getSubject() + '\n' + groups);

        for (int i = startTime; i <= startTime + duration; i++) {
            drawLesson(i, classRoom);
        }
        GridPane.setColumnIndex(label, classRoom);
        GridPane.setRowIndex(label, startTime);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        gridPane.getChildren().add(label);


    }

    public void addClassroomGrid() {
        int currentColumnms = gridPane.getColumnConstraints().size();
        gridPane.getColumnConstraints().add(currentColumnms, new ColumnConstraints(100));
        String clrName = "   " + agenda.getClassrooms().get(agenda.getClassrooms().size() - 1).getLocation();
        gridPane.add(new Label(clrName), currentColumnms, 0);
        gridPane.setPrefWidth(gridPane.getWidth());
        children.add(gridPane.getChildren().get(gridPane.getChildren().size() - 1));
    }

    public AnchorPane getanchorPane() {
        return this.anchorPane0;
    }

    public void clear() {
        gridPane.getChildren().retainAll(children);
    }
}