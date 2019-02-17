package GUI.Components;

import Data.Database;
import Data.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateGroupWindow extends VBox {
    private ArrayList<Group> selectedGroups;

    private VBox vBox;
    private ArrayList<String> groups;
    private Button saveGroups;
    private ArrayList<CheckBox> checkBoxes;

    public CreateGroupWindow(Database database){
        vBox = new VBox();
        saveGroups = new Button("Save groups");
         checkBoxes = new ArrayList<>();
        this.selectedGroups = new ArrayList<>();

        for(int i = 0; i< database.getAmountOfGroups(); i++){
            CheckBox checkBox = new CheckBox(database.getGroups().get(i).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);

        }
        vBox.getChildren().add(saveGroups);
        vBox.setSpacing(10);
        getChildren().add(vBox);



    }

    public ArrayList<Group> getSelectedGroups(){
        return this.selectedGroups;
    }

    public Button getSaveGroupsButton(){
        return this.saveGroups;
    }
    public ArrayList<CheckBox> getCheckBoxes(){
        return this.checkBoxes;
    }





}
