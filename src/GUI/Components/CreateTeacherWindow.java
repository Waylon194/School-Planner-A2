package GUI.Components;

import Data.Database;
import Data.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateTeacherWindow extends VBox {
    private ArrayList<Group> selectedTeachers;

    private VBox vBox;
    private ArrayList<String> groups;
    private Button saveTeachers;
    private ArrayList<CheckBox> checkBoxes;

    public CreateTeacherWindow(Database database){
        vBox = new VBox();
        saveTeachers = new Button("Save Teachers");
        checkBoxes = new ArrayList<>();
        this.selectedTeachers = new ArrayList<>();

        for(int i = 0; i< database.getAmountOfGroups(); i++){
            CheckBox checkBox = new CheckBox(database.getGroups().get(i).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);
            System.out.println("Kappa");
        }
        vBox.getChildren().add(saveTeachers);
        vBox.setSpacing(10);
        getChildren().add(vBox);



    }

    public ArrayList<Group> getSelectedGroups(){
        return this.selectedTeachers;
    }

    public Button getSaveTeachersButton(){
        return this.saveTeachers;
    }
    public ArrayList<CheckBox> getCheckBoxes(){
        return this.checkBoxes;
    }



}
