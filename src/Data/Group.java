package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private ArrayList<Student> students;
    private String groupName;
    private Teacher mentor;
    private ArrayList<Interval> unavailable;

    public Group(ArrayList<Student> students, String groupName, Teacher mentor) {
        this.students = students;
        this.groupName = groupName;
        this.mentor = mentor;
        this.unavailable = new ArrayList<>();
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


    public boolean isAvailable(Interval at) {
        for(Interval interval: unavailable) {
            if (at.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }


    public void makeUnavailable(Interval interval) {
        this.unavailable.add(interval);
    }
}