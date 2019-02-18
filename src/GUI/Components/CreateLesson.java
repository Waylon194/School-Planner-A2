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
    private final RowConstraints rowConstraints6;
    private final Label label;
    private final Label label0;
    private final Label label1;
    private final Label label2;
    private final Label label3;
    private final Label label14;
    private final Button buttonGroup;
    private final Button buttonSaveLesson;
    private final Button buttonCancelLesson;
    private final Button buttonTeachers;
    private final ComboBox comboStartTime;
    private final ComboBox comboEndTime;
    private final ComboBox classroomComboBox;
    private final ComboBox teacherComboBox;
    private final Label label4;
    private final ComboBox subjectComboBox;


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
        rowConstraints6 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label14 = new Label();
        buttonGroup = new Button();
        buttonSaveLesson = new Button();
        buttonCancelLesson = new Button();
        buttonTeachers = new Button();
        comboStartTime = new ComboBox();
        comboEndTime = new ComboBox();
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

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

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

        GridPane.setHalignment(label4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label4, 6);
        label4.setText("Teachers:");

        GridPane.setColumnIndex(buttonGroup, 1);
        GridPane.setHalignment(buttonGroup, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonGroup, 2);
        buttonGroup.setMnemonicParsing(false);
        buttonGroup.setText("Select Groups");

        GridPane.setColumnIndex(buttonTeachers, 1);
        GridPane.setHalignment(buttonTeachers, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonTeachers, 1);
        buttonTeachers.setMnemonicParsing(false);
        buttonTeachers.setText("Select Teachers");

        GridPane.setHalignment(buttonSaveLesson, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonSaveLesson, 7);
        buttonSaveLesson.setMnemonicParsing(false);
        buttonSaveLesson.setPrefHeight(25.0);
        buttonSaveLesson.setPrefWidth(76.0);
        buttonSaveLesson.setText("Save");

        GridPane.setColumnIndex(buttonCancelLesson, 1);
        GridPane.setHalignment(buttonCancelLesson, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(buttonCancelLesson, 7);
        buttonCancelLesson.setMnemonicParsing(false);
        buttonCancelLesson.setPrefHeight(24.0);
        buttonCancelLesson.setPrefWidth(101.0);
        buttonCancelLesson.setText("Cancel");

        GridPane.setColumnIndex(comboStartTime, 1);
        GridPane.setRowIndex(comboStartTime, 3);
        comboStartTime.setPrefHeight(25.0);
        comboStartTime.setPrefWidth(514.0);
        for (DateTime time : agenda.getTimes()) {
            int hour = time.getHourOfDay();
            int intMinute = time.getMinuteOfHour();
            String minute = "";
            if (intMinute<10){
                minute+="0"+ String.valueOf(intMinute);
            }
            else {
                minute = String.valueOf(intMinute);
            }
            //todo: change displayed time
            comboStartTime.getItems().add(time);
            //comboStartTime.(hour+":"+minute);
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
                minute+="0"+ String.valueOf(intMinute);
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
        GridPane.setRowIndex(teacherComboBox, 1);
        teacherComboBox.setPrefHeight(25.0);
        teacherComboBox.setPrefWidth(552.0);

        for(Map.Entry<String,Teacher> teacher: agenda.getTeachers().entrySet()){
            teacherComboBox.getItems().add(teacher);
        }

        GridPane.setHalignment(label4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label4, 5);
        label4.setText("Subject:");


        GridPane.setColumnIndex(subjectComboBox, 1);
        GridPane.setRowIndex(subjectComboBox, 5);
        subjectComboBox.setPrefHeight(25.0);
        subjectComboBox.setPrefWidth(705.0);

        for (Subject subject: agenda.getSubjects()){
            subjectComboBox.getItems().add(subject);
        }

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
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(buttonGroup);
        gridPane.getChildren().add(buttonSaveLesson);
        gridPane.getChildren().add(buttonCancelLesson);
        gridPane.getChildren().add(comboStartTime);
        gridPane.getChildren().add(comboEndTime);
        gridPane.getChildren().add(classroomComboBox);
       // gridPane.getChildren().add(teacherComboBox);

        gridPane.getChildren().add(subjectComboBox);
        gridPane.getChildren().add(buttonTeachers);
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
        } else {
            return null;
        }
    }

    public DateTime getChosenEndTime(){
        if(!(comboEndTime.getSelectionModel().isEmpty())) {
            return (DateTime) comboEndTime.getSelectionModel().getSelectedItem();
        } else return null;
    }
}
