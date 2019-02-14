package GUI.Components;

import Data.DataBank;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateGroupWindow extends VBox {

    private VBox vBox;
    private ArrayList<String> groups;

    public CreateGroupWindow(DataBank dataBank){
        vBox = new VBox();
        for(int i = 0; i<dataBank.getAmountOfGroups(); i++){
            CheckBox checkBox = new CheckBox(dataBank.getGroups().get(i).toString());
            vBox.getChildren().add(checkBox);
        }
        vBox.setSpacing(10);
        getChildren().add(vBox);
    }
}
