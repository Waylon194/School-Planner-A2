package GUI.Components;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateGroupWindow extends VBox {

    private VBox vBox;
    private ArrayList<String> groups;

    public CreateGroupWindow(){
        vBox = new VBox();
        groups = new ArrayList<String>();
        groups.add("Group1");
        groups.add("Group2");
        groups.add("Group3");
        groups.add("Group4");
        groups.add("Group5");
        groups.add("Group6");
        groups.add("Group7");
        groups.add("Group8");
        groups.add("Group9");
        groups.add("Group10");

        for(int i = 0; i<groups.size(); i++){
            CheckBox checkBox = new CheckBox(groups.get(i));
            vBox.getChildren().add(checkBox);
        }
        vBox.setSpacing(10);
        getChildren().add(vBox);
    }
}
