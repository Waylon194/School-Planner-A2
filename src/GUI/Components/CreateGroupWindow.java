package GUI.Components;

import Data.Database;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateGroupWindow extends VBox {

    private VBox vBox;
    private ArrayList<String> groups;

    public CreateGroupWindow(Database database){
        vBox = new VBox();
        for(int i = 0; i< database.getAmountOfGroups(); i++){
            CheckBox checkBox = new CheckBox(database.getGroups().get(i).toString());
            vBox.getChildren().add(checkBox);
        }
        vBox.setSpacing(10);
        getChildren().add(vBox);
    }
}
