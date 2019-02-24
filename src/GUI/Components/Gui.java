package GUI.Components;

import Data.Lesson;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
    private final AnchorPane anchorPane;
    private final GridPane gridPane;
    private final ColumnConstraints columnConstraints;
    private final ColumnConstraints columnConstraints0;
    private final ColumnConstraints columnConstraints1;
    private final ColumnConstraints columnConstraints2;
    private final ColumnConstraints columnConstraints3;
    private final ColumnConstraints columnConstraints4;
    private final ColumnConstraints columnConstraints5;
    private final ColumnConstraints columnConstraints6;
    private final ColumnConstraints columnConstraints7;
    private final RowConstraints rowConstraints;
    private final RowConstraints rowConstraints0;
    private final RowConstraints rowConstraints1;
    private final RowConstraints rowConstraints2;
    private final RowConstraints rowConstraints3;
    private final RowConstraints rowConstraints4;
    private final RowConstraints rowConstraints5;
    private final RowConstraints rowConstraints6;
    private final RowConstraints rowConstraints7;
    private final RowConstraints rowConstraints8;
    private final Label label;
    private final Label label0;
    private final Label label1;
    private final Label label2;
    private final Label label3;
    private final Label label4;
    private final Label label5;
    private final Label label6;
    private final Label label7;
    private final Label label8;
    private final Label label9;
    private final Label label10;
    private final Label label11;
    private final Label label12;
    private final Label label13;
    private final Label label14;
    private final Label label15;
    private final Label label16;
    private final Label label17;
    private final Tab tabViewEdit;
    private final Tab tabSimulate;
    private final AnchorPane anchorPane0;
    private final VBox vBoxLeftRow;
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
    Rectangle rectangle;

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

    public void drawLesson(int lesson, int classRoom) {
        rectangle = new Rectangle();
        GridPane.setColumnIndex(rectangle, classRoom);
        GridPane.setRowIndex(rectangle, lesson);
        rectangle.setSmooth(true);
        rectangle.setFill(Color.BEIGE);
        rectangle.setHeight(gridPane.getRowConstraints().get(classRoom).getPrefHeight() - 12.5);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(gridPane.getColumnConstraints().get(classRoom).getPrefWidth());
        gridPane.getChildren().add(rectangle);
    }

    public void drawLessonBlock(int startTime, int classRoom, int duration, Lesson lesson) {
        String groups = "";
        for (int i = 0; i <= lesson.getGroups().size(); i++) {
            if (i != lesson.getGroups().size()){
                groups += lesson.getGroupsAsString() + ", ";
            }
            else {
                groups += lesson.getGroupsAsString();
            }
        }

        //TODO: Meerdere docenten kunnen drawen
        Label label = new Label("" + lesson.getTeachersAsString() + '\n' + lesson.getSubject() + '\n' + groups);

        for (int i = startTime; i <= startTime + duration; i++) {
            drawLesson(i, classRoom);
        }
        GridPane.setColumnIndex(label, classRoom);
        GridPane.setRowIndex(label, startTime);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        gridPane.getChildren().add(label);
    }

    public void clear() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(gridPane.getChildren().get(0));
        nodes.add(gridPane.getChildren().get(1));
        nodes.add(gridPane.getChildren().get(2));
        nodes.add(gridPane.getChildren().get(3));
        nodes.add(gridPane.getChildren().get(4));
        nodes.add(gridPane.getChildren().get(5));
        nodes.add(gridPane.getChildren().get(6));
        nodes.add(gridPane.getChildren().get(7));
        nodes.add(gridPane.getChildren().get(8));
        nodes.add(gridPane.getChildren().get(9));
        nodes.add(gridPane.getChildren().get(10));
        nodes.add(gridPane.getChildren().get(11));
        nodes.add(gridPane.getChildren().get(12));
        nodes.add(gridPane.getChildren().get(13));
        nodes.add(gridPane.getChildren().get(14));
        nodes.add(gridPane.getChildren().get(15));
        nodes.add(gridPane.getChildren().get(16));
        nodes.add(gridPane.getChildren().get(17));
        nodes.add(gridPane.getChildren().get(18));
        nodes.add(gridPane.getChildren().get(19));
        gridPane.getChildren().clear();
        gridPane.getChildren().addAll(nodes);
    }

    public Gui() {
        tabAgenda = new Tab("Agenda");
        tabViewEdit = new Tab("View/Edit");
        tabSimulate = new Tab("Simulate");

        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        gridPane = new GridPane();

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();

        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        rowConstraints8 = new RowConstraints();

        label = new Label("LA201");
        label0 = new Label("LA115");
        label1 = new Label("LA302");
        label2 = new Label("LA401b");
        label3 = new Label("LD221");
        label4 = new Label("LD406");
        label5 = new Label("09:00");
        label6 = new Label("10:00");
        label7 = new Label("11:00");
        label8 = new Label("12:00");
        label9 = new Label("13:00");
        label10 = new Label("14:00");
        label11 = new Label("15:00");
        label12 = new Label("16:00");
        label13 = new Label("17:00");
        //TODO: Find purpose?!
        label14 = new Label();
        label15 = new Label("LA226");
        label16 = new Label("LA236");
        //TODO: Find purpose?!
        label17 = new Label();

        vBoxLeftRow = new VBox();
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

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(840.0);
        setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        gridPane.setGridLinesVisible(true);
        gridPane.setPrefHeight(572.0);
        gridPane.setPrefWidth(900.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(40.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(40.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(100.0);
        columnConstraints0.setMinWidth(0.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(100.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(100.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(100.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(100.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(100.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(100.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(100.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(100.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(100.0);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(43.0);
        rowConstraints.setMinHeight(5.0);
        rowConstraints.setPrefHeight(31.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(75.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(75.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(75.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(75.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(75.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(75.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(75.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(75.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(75.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(75.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(75.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(75.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(75.0);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(75.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(75.0);
        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(75.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints8.setMaxHeight(75.0);
        rowConstraints8.setMinHeight(10.0);
        rowConstraints8.setPrefHeight(75.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 1);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label0, 2);
        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label0, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label1, 3);
        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label1, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label2, 4);
        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label2, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label3, 5);
        GridPane.setHalignment(label3, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label3, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label4, 6);
        GridPane.setHalignment(label4, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label4, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label5, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label5, 1);
        GridPane.setValignment(label5, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label6, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label6, 2);
        GridPane.setValignment(label6, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label7, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label7, 3);
        GridPane.setValignment(label7, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label8, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label8, 4);
        GridPane.setValignment(label8, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label9, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label9, 5);
        GridPane.setValignment(label9, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label10, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label10, 6);
        GridPane.setValignment(label10, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label11, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label11, 7);
        GridPane.setValignment(label11, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label12, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label12, 8);
        GridPane.setValignment(label12, javafx.geometry.VPos.CENTER);

        GridPane.setHalignment(label13, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label13, 9);
        GridPane.setValignment(label13, javafx.geometry.VPos.CENTER);

        label14.setLayoutX(347.0);
        label14.setLayoutY(13.0);

        GridPane.setColumnIndex(label15, 7);
        GridPane.setHalignment(label15, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label15, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(label16, 8);
        GridPane.setHalignment(label16, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label16, javafx.geometry.VPos.CENTER);
        tabAgenda.setContent(anchorPane);

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        vBoxLeftRow.setLayoutX(7.0);
        vBoxLeftRow.setSpacing(10.0);

        btnAddLesson.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        btnAddLesson.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btnAddLesson.setMnemonicParsing(false);
        VBox.setMargin(btnAddLesson, new Insets(10.0, 0.0, 0.0, 10.0));
        btnAddLesson.setPadding(new Insets(10.0));

        btnViewLesson.setMnemonicParsing(false);
        VBox.setMargin(btnViewLesson, new Insets(0.0, 0.0, 0.0, 10.0));
        btnViewLesson.setPadding(new Insets(10.0));

        btnSaveSchedule.setMnemonicParsing(false);
        VBox.setMargin(btnSaveSchedule, new Insets(0.0, 0.0, 0.0, 10.0));
        btnSaveSchedule.setPadding(new Insets(10.0));

        btnOpenSchedule.setMnemonicParsing(false);
        VBox.setMargin(btnOpenSchedule, new Insets(0.0, 0.0, 0.0, 10.0));
        btnOpenSchedule.setPadding(new Insets(10.0));
        tabViewEdit.setContent(anchorPane0);

        btnAddTeacher.setMnemonicParsing(false);
        VBox.setMargin(btnAddTeacher, new Insets(10,0,0,10));
        btnAddTeacher.setPadding(new Insets(10));

        btnAddClassroom.setMnemonicParsing(false);
        VBox.setMargin(btnAddClassroom, new Insets(0,0,0,10));
        btnAddClassroom.setPadding(new Insets(10));

        btnAddGroup.setMnemonicParsing(false);
        VBox.setMargin(btnAddGroup, new Insets(0,0,0,10));
        btnAddGroup.setPadding(new Insets(10));

        btnAddSubject.setMnemonicParsing(false);
        VBox.setMargin(btnAddSubject, new Insets(0,0,0,10));
        btnAddSubject.setPadding(new Insets(10));

        btnChangeLessonTime.setMnemonicParsing(false);
        VBox.setMargin(btnChangeLessonTime, new Insets(0,0,0,10));
        btnChangeLessonTime.setPadding(new Insets(10));

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0, columnConstraints1,
                columnConstraints2, columnConstraints3, columnConstraints4,
                columnConstraints5, columnConstraints6, columnConstraints7);

        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3,
                rowConstraints4, rowConstraints5, rowConstraints6, rowConstraints7, rowConstraints8);

        gridPane.getChildren().addAll(label, label0, label1, label2, label3, label4, label5, label6, label7, label8,
                label9, label10, label11, label12, label13, label14, label15, label16, label17);

        vBoxLeftRow.getChildren().addAll(btnAddLesson, btnViewLesson, btnSaveSchedule, btnOpenSchedule );
        vBoxRightRow.getChildren().addAll(btnAddTeacher, btnAddClassroom, btnAddGroup, btnAddSubject);
        vBoxRightRow.setSpacing(10);

        hBoxButtons.getChildren().addAll(vBoxLeftRow, vBoxRightRow);
        hBoxButtons.setSpacing(150);

        anchorPane.getChildren().add(gridPane);
        anchorPane0.getChildren().add(hBoxButtons);

        getTabs().addAll(tabViewEdit, tabAgenda, tabSimulate);
    }
}