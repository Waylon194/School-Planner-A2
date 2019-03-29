package GUI.Components;

import Data.*;
import GUI.GUIMain;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

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
                ArrayList<Teacher> teachersToMakeAvailable = agenda.getLessons().get(amountLessons).getTeachers();
                ArrayList<Group> groupsToMakeAvailable = agenda.getLessons().get(amountLessons).getGroups();

                button.setOnAction(event -> {
                    System.out.println(agenda.amountOfLessons());
                    teachersToMakeAvailable.forEach(teacher -> {
                        teacher.makeAvailable(i);
                    });
                    groupsToMakeAvailable.forEach(group -> {
                        group.makeAvailable(i);
                    });
                    agenda.getLessons().get(i).getClassroom().makeAvailable(i);
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