package GUI.Components;

import Data.Agenda;
import Data.Teacher;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateTeacherWindow extends VBox {
    private ArrayList<Teacher> selectedTeachers;
    private VBox vBox;
    private Button saveTeachers;
    private ArrayList<CheckBox> checkBoxes;
    private Agenda agenda;

    public CreateTeacherWindow(Agenda agenda) {
        vBox = new VBox();
        saveTeachers = new Button("Save Teacher(s)");
        checkBoxes = new ArrayList<>();
        this.selectedTeachers = new ArrayList<>();
        this.agenda = agenda;
        getChildren().add(vBox);
        update();
    }


    public void update() {
        vBox.getChildren().clear();
        checkBoxes.clear();
        for (Teacher teacher : agenda.getTeachers()) {
            System.out.println(teacher);
            CheckBox checkBox = new CheckBox(" " + teacher.toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);
        }
        vBox.getChildren().add(saveTeachers);
        vBox.setSpacing(10);
    }

    public Button getSaveTeachersButton() {
        return this.saveTeachers;
    }

    public ArrayList<CheckBox> getCheckBoxes() {
        return this.checkBoxes;
    }
}