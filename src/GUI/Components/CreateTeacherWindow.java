package GUI.Components;

import Data.Database;
import Data.Group;
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

    public CreateTeacherWindow(Database database){
        vBox = new VBox();
        saveTeachers = new Button("Save Teachers");
        checkBoxes = new ArrayList<>();
        this.selectedTeachers = new ArrayList<>();



        database.getTeachers().forEach((s, teacher) -> {
            CheckBox checkBox = new CheckBox(database.getTeachers().get(s).getTeacherNumber() +" "+database.getTeachers().get(s).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);


                });

        /*for(int i = 0; i< database.getTeachers().size(); i++){

            CheckBox checkBox = new CheckBox(database.getTeachers().get());
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
