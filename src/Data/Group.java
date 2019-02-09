package Data;

import java.util.ArrayList;

public class Group {
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
}