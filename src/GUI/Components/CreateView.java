package GUI.Components;

import Data.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CreateView extends GridPane {




    GridPane gridPane = new GridPane();

    public CreateView(Database database){


        for(int amountLessons = 0; amountLessons< database.amountOfLessons(); amountLessons++){
            Label label = new Label(database.returnLessons().get(amountLessons).getSubject().toString() + database.returnLessons().get(amountLessons).getClassroom().toString());
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
