package GUI.Components;

import Data.Group;
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

    private final Tab tab;
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
    private final Tab tab0;
    private  Tab tab1;
    private final AnchorPane anchorPane0;
    private final VBox vBox;
    private final Button button;
    private final Button button0;
    private final Button button1;
    private final Button button2;


    public Button getButton() {
        return button;
    }

    public Button getButton0() {
        return button0;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Tab getTab(){
        return tab1;
    }


    Rectangle rectangle;

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
        for (Group group : lesson.getGroups()) {
           groups += group.getGroupName()+" ";

        }

        Label label = new Label("" + lesson.getTeachersAsString() + '\n' + lesson.getSubject()+'\n'+groups);
       // Label label1 = new Label("" + lesson.getTeachersAsString() + '\n' + lesson.getSubject()+'\n'+groups);

        for (int i = startTime; i <= startTime + duration; i++) {
            drawLesson(i, classRoom);
        }
        GridPane.setColumnIndex(label, classRoom);
        GridPane.setRowIndex(label, startTime);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        gridPane.getChildren().add(label);
      //  gridPane.getChildren().add(label1);
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
        tab = new Tab();
        tab1 = new Tab();
        anchorPane = new AnchorPane();
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
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        label11 = new Label();
        label12 = new Label();
        label13 = new Label();
        label14 = new Label();
        label15 = new Label();
        label16 = new Label();
        label17 = new Label();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        vBox = new VBox();
        button = new Button();
        button0 = new Button();
        button1 = new Button("Save Schedule");
        button2 = new Button("Open Schedule");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(840.0);
        setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Agenda");

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
        label.setText("LA201");

        GridPane.setColumnIndex(label0, 2);
        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label0, javafx.geometry.VPos.CENTER);
        label0.setText("LA302");

        GridPane.setColumnIndex(label1, 3);
        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label1, javafx.geometry.VPos.CENTER);
        label1.setText("LA115");

        GridPane.setColumnIndex(label2, 4);
        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label2, javafx.geometry.VPos.CENTER);
        label2.setText("LX401b");

        GridPane.setColumnIndex(label3, 5);
        GridPane.setHalignment(label3, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label3, javafx.geometry.VPos.CENTER);
        label3.setText("LD221");

        GridPane.setColumnIndex(label4, 6);
        GridPane.setHalignment(label4, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label4, javafx.geometry.VPos.CENTER);
        label4.setText("LD406");

        GridPane.setHalignment(label5, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label5, 1);
        GridPane.setValignment(label5, javafx.geometry.VPos.CENTER);
        label5.setText("09:00");

        GridPane.setHalignment(label6, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label6, 2);
        GridPane.setValignment(label6, javafx.geometry.VPos.CENTER);
        label6.setText("10:00");

        GridPane.setHalignment(label7, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label7, 3);
        GridPane.setValignment(label7, javafx.geometry.VPos.CENTER);
        label7.setText("11:00");

        GridPane.setHalignment(label8, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label8, 4);
        GridPane.setValignment(label8, javafx.geometry.VPos.CENTER);
        label8.setText("12:00");

        GridPane.setHalignment(label9, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label9, 5);
        GridPane.setValignment(label9, javafx.geometry.VPos.CENTER);
        label9.setText("13:00");

        GridPane.setHalignment(label10, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label10, 6);
        GridPane.setValignment(label10, javafx.geometry.VPos.CENTER);
        label10.setText("14:00");

        GridPane.setHalignment(label11, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label11, 7);
        GridPane.setValignment(label11, javafx.geometry.VPos.CENTER);
        label11.setText("15:00");

        GridPane.setHalignment(label12, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label12, 8);
        GridPane.setValignment(label12, javafx.geometry.VPos.CENTER);
        label12.setText("16:00");

        GridPane.setHalignment(label13, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label13, 9);
        GridPane.setValignment(label13, javafx.geometry.VPos.CENTER);
        label13.setText("17:00");

        label14.setLayoutX(347.0);
        label14.setLayoutY(13.0);

        GridPane.setColumnIndex(label15, 7);
        GridPane.setHalignment(label15, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label15, javafx.geometry.VPos.CENTER);
        label15.setText("LA226");

        GridPane.setColumnIndex(label16, 8);
        GridPane.setHalignment(label16, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label16, javafx.geometry.VPos.CENTER);
        label16.setText("LA236");
        tab.setContent(anchorPane);

        tab0.setText("View/Edit");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        vBox.setLayoutX(7.0);
        vBox.setPrefHeight(571.0);
        vBox.setPrefWidth(840.0);
        vBox.setSpacing(10.0);

        button.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setMnemonicParsing(false);
        button.setText("Add Lesson");
        VBox.setMargin(button, new Insets(10.0, 0.0, 0.0, 10.0));
        button.setPadding(new Insets(10.0));

        button0.setMnemonicParsing(false);
        button0.setText("View Lessons");
        VBox.setMargin(button0, new Insets(0.0, 0.0, 0.0, 10.0));
        button0.setPadding(new Insets(10.0));

        button1.setMnemonicParsing(false);
        VBox.setMargin(button1, new Insets(0.0, 0.0, 0.0, 10.0));
        button1.setPadding(new Insets(10.0));

        button2.setMnemonicParsing(false);
        VBox.setMargin(button2, new Insets(0.0, 0.0, 0.0, 10.0));
        button2.setPadding(new Insets(10.0));
        tab0.setContent(anchorPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getColumnConstraints().add(columnConstraints6);
        gridPane.getColumnConstraints().add(columnConstraints7);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getRowConstraints().add(rowConstraints6);
        gridPane.getRowConstraints().add(rowConstraints7);
        gridPane.getRowConstraints().add(rowConstraints8);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(label5);
        gridPane.getChildren().add(label6);
        gridPane.getChildren().add(label7);
        gridPane.getChildren().add(label8);
        gridPane.getChildren().add(label9);
        gridPane.getChildren().add(label10);
        gridPane.getChildren().add(label11);
        gridPane.getChildren().add(label12);
        gridPane.getChildren().add(label13);
        gridPane.getChildren().add(label14);
        gridPane.getChildren().add(label15);
        gridPane.getChildren().add(label16);
        gridPane.getChildren().add(label17);
        anchorPane.getChildren().add(gridPane);
        getTabs().add(tab);
        vBox.getChildren().add(button);
        vBox.getChildren().add(button0);
        vBox.getChildren().add(button1);
        vBox.getChildren().add(button2);
        anchorPane0.getChildren().add(vBox);
        getTabs().add(tab0);


        tab1.setText("Simulate");
        getTabs().add(tab1);


    }


}
