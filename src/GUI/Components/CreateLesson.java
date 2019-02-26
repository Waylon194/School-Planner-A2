package GUI.Components;

import Data.Classroom;
import Data.Agenda;
import Data.Subject;
import Data.Teacher;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.joda.time.DateTime;

import java.awt.*;
import java.util.Map;

public class CreateLesson extends GridPane {
    private Agenda agenda;
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
    private final RowConstraints subjectRow;
    private final RowConstraints popularityRow;
    private final Label label;
    private final Label label0;
    private final Label label1;
    private final Label label2;
    private final Label label3;
    private final Label lblSubject;
    private final Button buttonGroup;
    private final Button buttonSaveLesson;
    private final Button buttonCancelLesson;
    private final Button buttonTeachers;
    private final ComboBox comboStartTime;
    private final ComboBox comboEndTime;
    private final ComboBox classroomComboBox;
    private final ComboBox teacherComboBox;
    private final Label lblPopularity;
    private final ComboBox subjectComboBox;
    private final ComboBox popularityComboBox;

    public Button getButtonGroup() {
        return buttonGroup;
    }

    public Button getButtonSaveLesson() {
        return buttonSaveLesson;
    }

    public Button getButtonCancelLesson() {
        return buttonCancelLesson;
    }

    public ComboBox getComboStartTime() {
        return comboStartTime;
    }

    public ComboBox getComboEndTime() {
        return comboEndTime;
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

    public Button getButtonTeachers(){
        return this.buttonTeachers;
    }

    public CreateLesson(Agenda agenda) {
        this.agenda = agenda;
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
        subjectRow = new RowConstraints();
        popularityRow = new RowConstraints();

        label = new Label("Classroom:");
        label0 = new Label("Teacher(s):");
        label1 = new Label("Group(s):");
        label2 = new Label("Starting Time:");
        label3 = new Label("Ending Time:");
        lblSubject = new Label("Subject:");
        lblPopularity = new Label("Popularity:");

        buttonGroup = new Button("Select Group(s)");
        buttonSaveLesson = new Button("Save lesson");
        buttonCancelLesson = new Button("Cancel");
        buttonTeachers = new Button("Select Teacher(s)");

        comboStartTime = new ComboBox();
        comboEndTime = new ComboBox();
        classroomComboBox = new ComboBox();
        teacherComboBox = new ComboBox();
        subjectComboBox = new ComboBox();
        //Popularity box
        popularityComboBox = new ComboBox();

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

        //Subject field
        subjectRow.setMinHeight(10.0);
        subjectRow.setPrefHeight(30.0);
        subjectRow.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        //Popularity field
        popularityRow.setMinHeight(10.0);
        popularityRow.setPrefHeight(30.0);
        popularityRow.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);

        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label0, 1);

        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label1, 2);

        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label2, 3);

        GridPane.setHalignment(label3, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label3, 4);

        GridPane.setHalignment(lblSubject, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(lblSubject, 5);

        GridPane.setHalignment(lblPopularity, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(lblPopularity, 6);

        GridPane.setColumnIndex(buttonGroup, 1);
        GridPane.setHalignment(buttonGroup, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonGroup, 2);
        buttonGroup.setMnemonicParsing(false);

        GridPane.setColumnIndex(buttonTeachers, 1);
        GridPane.setHalignment(buttonTeachers, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonTeachers, 1);
        buttonTeachers.setMnemonicParsing(false);

        GridPane.setHalignment(buttonSaveLesson, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonSaveLesson, 7);
        buttonSaveLesson.setMnemonicParsing(false);
        buttonSaveLesson.setPrefHeight(25.0);
        buttonSaveLesson.setPrefWidth(76.0);

        GridPane.setColumnIndex(buttonCancelLesson, 1);
        GridPane.setHalignment(buttonCancelLesson, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonCancelLesson, 7);
        buttonCancelLesson.setMnemonicParsing(false);
        buttonCancelLesson.setPrefHeight(24.0);
        buttonCancelLesson.setPrefWidth(101.0);

        GridPane.setColumnIndex(comboStartTime, 1);
        GridPane.setRowIndex(comboStartTime, 3);
        comboStartTime.setPrefHeight(25.0);
        comboStartTime.setPrefWidth(514.0);

        for (DateTime time : agenda.getTimes()){
            int hour = time.getHourOfDay();
            int intMinute = time.getMinuteOfHour();
            String minute = "";
            if (intMinute < 10){
                minute += "0" + intMinute;
            }
            else {
                minute = String.valueOf(intMinute);
            }
            //TODO: Change display time
            comboStartTime.getItems().add(time);
        }

        GridPane.setColumnIndex(comboEndTime, 1);
        GridPane.setRowIndex(comboEndTime, 4);
        comboEndTime.setPrefHeight(25.0);
        comboEndTime.setPrefWidth(514.0);

        for (DateTime time : agenda.getTimes()) {
            int hour = time.getHourOfDay();
            int intMinute = time.getMinuteOfHour();
            String minute = "";
            if (intMinute<10){
                minute += "0" + intMinute;
            }else{
                minute = String.valueOf(intMinute);
            }

            comboEndTime.getItems().add(time);
        }
        GridPane.setColumnIndex(classroomComboBox, 1);
        classroomComboBox.setPrefHeight(25.0);
        classroomComboBox.setPrefWidth(514.0);

        for(Classroom classroom: agenda.getClassrooms()){
            classroomComboBox.getItems().add(classroom);
        }

        GridPane.setColumnIndex(teacherComboBox, 1);
        GridPane.setRowIndex(teacherComboBox, 4);
        teacherComboBox.setPrefHeight(25.0);
        teacherComboBox.setPrefWidth(552.0);

        for(Map.Entry<String,Teacher> teacher: agenda.getTeachers().entrySet()){
            teacherComboBox.getItems().add(teacher);
        }

        GridPane.setColumnIndex(subjectComboBox, 1);
        GridPane.setRowIndex(subjectComboBox, 5);
        subjectComboBox.setPrefHeight(25.0);
        subjectComboBox.setPrefWidth(705.0);

        for (Subject subject: agenda.getSubjects()){
            subjectComboBox.getItems().add(subject);
        }

        GridPane.setColumnIndex(popularityComboBox, 1);
        GridPane.setRowIndex(popularityComboBox, 6);
        popularityComboBox.setPrefHeight(25.0);
        popularityComboBox.setPrefWidth(705.0);

        popularityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1,
                rowConstraints2, rowConstraints3, rowConstraints4, rowConstraints5, subjectRow, popularityRow);
        gridPane.getChildren().addAll(label, label0, label1, label2, label3, lblSubject ,lblPopularity, buttonGroup, buttonSaveLesson,
                buttonCancelLesson, comboStartTime, comboEndTime, classroomComboBox, subjectComboBox, buttonTeachers,
                popularityComboBox);
        getChildren().add(gridPane);
    }

    public Classroom getChosenClasroom(){
        return (Classroom) classroomComboBox.getSelectionModel().getSelectedItem();
    }

    public Teacher getChosenTeacher(){
        return (Teacher) teacherComboBox.getSelectionModel().getSelectedItem();
    }

    public Subject getChosenSubject(){
        return (Subject) subjectComboBox.getSelectionModel().getSelectedItem();
    }

    public DateTime getChosenStartTime(){
        if(!(comboStartTime.getSelectionModel().isEmpty())) {
            return (DateTime) comboStartTime.getSelectionModel().getSelectedItem();
        }
        else {
            return null;
        }
    }

    public DateTime getChosenEndTime(){
        if(!(comboEndTime.getSelectionModel().isEmpty())) {
            return (DateTime) comboEndTime.getSelectionModel().getSelectedItem();
        }
        else {
            return null;
        }
    }

    public void update() {
        classroomComboBox.getItems().clear();
        for(Classroom classroom : agenda.getClassrooms()) {
            classroomComboBox.getItems().add(classroom);
        }
    }
}