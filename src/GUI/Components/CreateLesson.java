package GUI.Components;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CreateLesson extends GridPane {

    private final GridPane gridPane;
    private final ColumnConstraints columnConstraints;
    private final ColumnConstraints columnConstraints0;
    private final RowConstraints rowConstraints;
    private final RowConstraints rowConstraints0;
    private final RowConstraints rowConstraints1;
    private final RowConstraints rowConstraints2;
    private final RowConstraints rowConstraints3;
    private final RowConstraints rowConstraints4;
    private final RowConstraints rowConstraints5;
    private final Label label;
    private final Label label0;
    private final Label label1;
    private final Label label2;
    private final Label label3;
    private final Button button;
    private final Button button0;
    private final Button button1;
    private final TextField textField;
    private final TextField textField0;
    private final ComboBox classroomComboBox;
    private final ComboBox teacherComboBox;
    private final Label label4;
    private final ComboBox subjectComboBox;

    public Button getButton() {
        return button;
    }

    public Button getButton0() {
        return button0;
    }

    public Button getButton1() {
        return button1;
    }

    public TextField getTextField() {
        return textField;
    }

    public TextField getTextField0() {
        return textField0;
    }

    public ComboBox getClassroomComboBox() {
        return classroomComboBox;
    }

    public ComboBox getTeacherComboBox() {
        return teacherComboBox;
    }

    public ComboBox getSubjectComboBox() {
        return subjectComboBox;
    }

    public CreateLesson() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        textField = new TextField();
        textField0 = new TextField();
        classroomComboBox = new ComboBox();
        teacherComboBox = new ComboBox();
        label4 = new Label();
        subjectComboBox = new ComboBox();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        gridPane.setLayoutX(-1.0);
        gridPane.setLayoutY(1.0);
        gridPane.setPrefHeight(400.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(295.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(130.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(470.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(470.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        label.setText("Classroom:");

        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label0, 1);
        label0.setText("Teacher(s):");

        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label1, 2);
        label1.setText("Group(s):");

        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label2, 3);
        label2.setText("Lessons Starting Time:");

        GridPane.setHalignment(label3, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label3, 4);
        label3.setText("Lessons Ending Time:");

        GridPane.setColumnIndex(button, 1);
        GridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button, 2);
        button.setMnemonicParsing(false);
        button.setText("Select Groups");

        GridPane.setHalignment(button0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button0, 6);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(76.0);
        button0.setText("Save");

        GridPane.setColumnIndex(button1, 1);
        GridPane.setHalignment(button1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button1, 6);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(24.0);
        button1.setPrefWidth(101.0);
        button1.setText("Cancel");

        GridPane.setColumnIndex(textField, 1);
        GridPane.setRowIndex(textField, 3);

        GridPane.setColumnIndex(textField0, 1);
        GridPane.setRowIndex(textField0, 4);

        GridPane.setColumnIndex(classroomComboBox, 1);
        classroomComboBox.setPrefHeight(25.0);
        classroomComboBox.setPrefWidth(514.0);

        GridPane.setColumnIndex(teacherComboBox, 1);
        GridPane.setRowIndex(teacherComboBox, 1);
        teacherComboBox.setPrefHeight(25.0);
        teacherComboBox.setPrefWidth(552.0);

        GridPane.setHalignment(label4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label4, 5);
        label4.setText("Subject:");

        GridPane.setColumnIndex(subjectComboBox, 1);
        GridPane.setRowIndex(subjectComboBox, 5);
        subjectComboBox.setPrefHeight(25.0);
        subjectComboBox.setPrefWidth(705.0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(textField);
        gridPane.getChildren().add(textField0);
        gridPane.getChildren().add(classroomComboBox);
        gridPane.getChildren().add(teacherComboBox);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(subjectComboBox);
        getChildren().add(gridPane);

    }

}
