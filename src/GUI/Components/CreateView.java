package GUI.Components;

import Data.Agenda;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.ArrayList;

public class CreateView extends GridPane {
    ArrayList<Data.Lesson> lessons = new ArrayList();
    Agenda agenda = new Agenda(lessons);
    GridPane gridPane = new GridPane();

    public CreateView(){
        for(int amountLessons = 0; amountLessons< lessons.size(); amountLessons++){
            Label label = new Label("" + lessons.get(amountLessons));
            gridPane.addRow(amountLessons);
            //gridPane.add(lessons 1, amountLessons);
        }

    }
}
