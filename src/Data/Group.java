package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private ArrayList<Student> students;
    private String groupName;
    private Teacher mentor;

    public Group(ArrayList<Student> students, String groupName, Teacher mentor) {
        this.students = students;
        this.groupName = groupName;
        this.mentor = mentor;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addStudent(Student s){
        students.add(s);
    }

    @Override
    public String toString () {
        return  ("\n Group name: " + groupName +
                "\n Students: " + students +
                "\n Mentor: " + mentor).replace('[',' ').replace(']',' ');
    }
}