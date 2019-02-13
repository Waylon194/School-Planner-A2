package GUI.Components;

import Data.*;
import Data.Class;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CreateView extends GridPane {

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Class> classes = new ArrayList<>();

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> students1 = new ArrayList<>();
    ArrayList<Student> students2 = new ArrayList<>();
    ArrayList<Student> students3 = new ArrayList<>();

    ArrayList<Group> groups = new ArrayList<>();
    ArrayList<Group> groups1 = new ArrayList<>();
    ArrayList<Group> groups2 = new ArrayList<>();
    ArrayList<Group> groups3 = new ArrayList<>();

    ArrayList<Lesson> lessons = new ArrayList<>();

    Classroom classroom = new Classroom(112, 30, "LA", true, true);
    Classroom classroom1 = new Classroom(113, 32, "LA", true, true);
    Classroom classroom2 = new Classroom(114, 25, "LA", true, true);
    Classroom classroom3 = new Classroom(115, 28, "LA", true, true);

    Teacher teacher = new Teacher("Johan", "", "Talboom", 32, 0, 0, 420, Subject.PRORAMMING);

    Lesson math = new Lesson(teachers, classroom, classes, Subject.MATH, LocalDateTime.now());
    Lesson graphics2d = new Lesson(teachers, classroom1, classes, Subject.GRAPHICS2D, LocalDateTime.now());
    Lesson graphics3d = new Lesson(teachers, classroom2, classes, Subject.GRAPHICS3D, LocalDateTime.now());
    Lesson programming = new Lesson(teachers, classroom3, classes, Subject.PRORAMMING, LocalDateTime.now());

    Student kees = new Student("Kees" , "de" , "Bruin", 19, 0,0,108);
    Student sjakie = new Student("Sjakie" , "" , "Pompel", 18, 0,0,109);
    Student ronald = new Student("Ronald" , "" , "Tompel", 20, 0,0,110);
    Student corrie = new Student("Corrie" , "" , "Lompel", 17, 0,0,111);

    Group a2 = new Group(students, "A2", new Teacher("Maurice", "", "Snoeren", 45, 0,0,100, Subject.PRORAMMING));
    Group a3 = new Group(students, "A3", new Teacher("Johan", "", "Snoeren", 45, 0,0,101, Subject.GRAPHICS3D));
    Group a4 = new Group(students, "A4", new Teacher("Etienne", "", "Snoeren", 45, 0,0,102, Subject.MATH));
    Group a5 = new Group(students, "A5", new Teacher("Paul", "", "Snoeren", 45, 0,0,103, Subject.WORKSHOP));

    Class class1 = new Class(groups, "555");
    Class class2 = new Class(groups1, "556");
    Class class3 = new Class(groups2, "557");
    Class class4 = new Class(groups3, "558");

    Agenda agenda = new Agenda(lessons);

    GridPane gridPane = new GridPane();

    public CreateView(){
        students.add(kees);
        students1.add(sjakie);
        students2.add(ronald);
        students3.add(corrie);

        groups.add(a2);
        groups1.add(a3);
        groups2.add(a4);
        groups3.add(a5);

        lessons.add(math);
        lessons.add(graphics2d);
        lessons.add(graphics3d);
        lessons.add(programming);

        classes.add(class1);
        classes.add(class2);
        classes.add(class3);
        classes.add(class4);

        teachers.add(teacher);

        for(int amountLessons = 0; amountLessons< agenda.amountOfLessons(); amountLessons++){
            Label label = new Label("Subject: " + lessons.get(amountLessons).getSubject() + "\nClassroom: " + lessons.get(amountLessons).getClassroom().getLocation() + lessons.get(amountLessons).getClassroom().getNumber() + "\nTeacher(s): " + lessons.get(amountLessons).getTeachers() + "\nTime: " + lessons.get(amountLessons).getTime());
            Button buttonChange = new Button("Change");

            buttonChange.setOnAction(event -> {
                
            });

            gridPane.addRow(amountLessons);
            gridPane.add(label, 0, amountLessons);
            gridPane.add(buttonChange, 1, amountLessons);
        }

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        getChildren().add(gridPane);

    }

    public Agenda returnAgenda(){
        return this.agenda;
    }
    public void setAgenda(Agenda agenda){
        this.agenda = agenda;
    }
}
