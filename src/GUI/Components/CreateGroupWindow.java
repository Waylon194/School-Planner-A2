package GUI.Components;

import Data.Agenda;
import Data.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class CreateGroupWindow extends VBox {
    private VBox vBox;
    private Button saveGroups;
    private ArrayList<CheckBox> checkBoxes;

    public CreateGroupWindow(Agenda agenda){
        vBox = new VBox();
        saveGroups = new Button("Save group(s)");
        checkBoxes = new ArrayList<>();
        for(int i = 0; i< agenda.getAmountOfGroups(); i++){
            CheckBox checkBox = new CheckBox(agenda.getGroups().get(i).toString());
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);
        }
        vBox.getChildren().add(saveGroups);
        vBox.setSpacing(10);
        getChildren().add(vBox);
    }


    public Button getSaveGroupsButton(){
        return this.saveGroups;
    }

    public ArrayList<CheckBox> getCheckBoxes(){
        return this.checkBoxes;
    }
}