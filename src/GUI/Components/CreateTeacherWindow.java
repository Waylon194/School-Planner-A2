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
    private ArrayList<String> groups;
    private Button saveTeachers;
    private ArrayList<CheckBox> checkBoxes;

    public CreateTeacherWindow(Agenda agenda){
        vBox = new VBox();
        saveTeachers = new Button("Save Teachers");
        checkBoxes = new ArrayList<>();
        this.selectedTeachers = new ArrayList<>();



        agenda.getTeachers().forEach((s, teacher) -> {
            CheckBox checkBox = new CheckBox(agenda.getTeachers().get(s).getTeacherNumber() +" "+ agenda.getTeachers().get(s).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);


                });

        /*for(int i = 0; i< agenda.getTeachers().size(); i++){

            CheckBox checkBox = new CheckBox(agenda.getTeachers().get());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);
        }*/
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
