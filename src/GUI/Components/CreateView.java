package GUI.Components;

import Data.*;
import GUI.GUIMain;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CreateView extends GridPane {
    GridPane gridPane = new GridPane();

    public CreateView(Agenda agenda, GUIMain guiMain) {
        if (agenda.amountOfLessons() > 0) {
            for (int amountLessons = 0; amountLessons < agenda.amountOfLessons(); amountLessons++) {
                String teachers = "";
                for(Teacher teacher: agenda.getLessons().get(amountLessons).getTeachers()){
                    teachers+=" "+teacher.getTeacherNumber();
                }
                Label label = new Label(agenda.getLessons().get(amountLessons).getSubject().toString()
                        + " " + agenda.getLessons().get(amountLessons).getClassroom().getLocation()
                        + " " + teachers
                        + " " + agenda.getLessons().get(amountLessons).getGroupsAsString()
                );

                Button button = new Button("Delete");
                final int i = amountLessons;
                button.setOnAction(event -> {
                    System.out.println(agenda.amountOfLessons());
                    agenda.deleteLesson(i);
                    System.out.println(agenda.amountOfLessons());
                    guiMain.updateScene();
                    guiMain.update();
                });

                gridPane.addRow(amountLessons);
                gridPane.add(label, 0, amountLessons);
                gridPane.add(button, 1, amountLessons);
            }
            gridPane.setVgap(10);
            gridPane.setHgap(10);
            getChildren().add(gridPane);
        }
        else{
            Label label = new Label("There are no lessons planned");
            gridPane.add(label,0,0);
            getChildren().add(gridPane);
        }
    }
}