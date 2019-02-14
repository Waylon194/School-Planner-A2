import Data.*;
import Data.Class;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {











        Interval interval = new Interval(new DateTime(2013, 10, 25, 8, 0, 0, 0), new DateTime(2013, 10, 25, 9, 0, 0, 0));


        Student kees = new Student("Kees" , "de" , "Bruin", 19, 0,0,108);
        ArrayList<Student> students = new ArrayList<>();
        students.add(kees);

        Group A2 = new Group(students, "A2", new Teacher("Maurice", "", "Snoeren", 45, 0,0,100, Subject.PRORAMMING));
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(A2);

        Data.Class classe = new Data.Class(groups, "12Tiav");

        ArrayList<Class> classes = new ArrayList<>();
        classes.add(classe);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Maurice", "", "Snoeren", 45, 0,0,100, Subject.PRORAMMING));


        Lesson les = new Lesson(teachers, new Classroom(8,8,"Cantene",false, false), classes, Subject.MATH, interval);







    }
}