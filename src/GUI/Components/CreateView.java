package GUI.Components;

import Data.*;
import Data.Class;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CreateView extends GridPane {




    GridPane gridPane = new GridPane();

    public CreateView(DataBank dataBank){


        for(int amountLessons = 0; amountLessons< dataBank.returnAgenda().amountOfLessons(); amountLessons++){
            Label label = new Label(dataBank.returnLessons().get(0).getSubject().toString() + dataBank.returnLessons().get(amountLessons).getClassroom().toString());
            Button button = new Button("Change");
            Button button1 = new Button("View");

            button.setOnAction(event -> {
                
            });

            gridPane.addRow(amountLessons);
            gridPane.add(label, 0, amountLessons);
            gridPane.add(button, 1, amountLessons);
            gridPane.add(button1, 2, amountLessons);
        }

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        getChildren().add(gridPane);

    }


}
