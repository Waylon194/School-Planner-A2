import Data.Class;
import Data.Group;
import Data.Student;
import Data.Teacher;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        //Delete the code below, it is only a check.
        String text = "Sucessfully cloned :D";
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(100);
        }
        Student kees = new Student("Kees" , "de" , "Bruin", 19, 0,0,108);
        ArrayList<Student> students = new ArrayList<>();
        students.add(kees);
        Group A2 = new Group(students, "A2", new Teacher("Maurice", "", "Snoeren", 45, 0,0,100));
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(A2);

        Class classe = new Class(groups, "12Tiav");

        System.out.println(classe.toString());

    }
}