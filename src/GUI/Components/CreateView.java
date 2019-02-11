package GUI.Components;

import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.ArrayList;

public class CreateView extends GridPane {
    ArrayList<String> lessons = new ArrayList();
    GridPane gridPane = new GridPane();

    public CreateView(){
        for(int amountLessons = 0; amountLessons< lessons.size(); amountLessons++){
            Label label = new Label(lessons.get(amountLessons));
            gridPane.addRow(amountLessons);
            //gridPane.add(lessons.getTime(), 1, amountLessons);
        }

    }
}
