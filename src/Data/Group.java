package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable, Available {
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

    @Override
    public boolean isAvailable(DateTime at) {
        for(Interval interval: unavailable) {
            if (interval.contains(at)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void makeUnavailable(DateTime from, DateTime at) {
        this.unavailable.add(new Interval(from,at));
    }
}