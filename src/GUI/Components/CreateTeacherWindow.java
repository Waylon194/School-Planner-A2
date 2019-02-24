package GUI.Components;

import Data.Agenda;
import Data.Teacher;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Map;

public class CreateTeacherWindow extends VBox {
    private ArrayList<Teacher> selectedTeachers;

    private VBox vBox;
    private ArrayList<String> groups;
    private Button saveTeachers;
    private ArrayList<CheckBox> checkBoxes;

    public CreateTeacherWindow(Agenda agenda){
        vBox = new VBox();
        saveTeachers = new Button("Save Teachers");
        checkBoxes = new ArrayList<>();
        this.selectedTeachers = new ArrayList<>();

        Map teacherMap = agenda.getTeachers();

        for(Object obj : teacherMap.keySet()) {
            CheckBox checkBox = new CheckBox(teacherMap.get(obj).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);
        }

        vBox.getChildren().add(saveTeachers);
        vBox.setSpacing(10);
        getChildren().add(vBox);
    }

    public Button getSaveTeachersButton(){
        return this.saveTeachers;
    }

    public ArrayList<CheckBox> getCheckBoxes(){
        return this.checkBoxes;
    }
}
