package Data;

import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable, Availability {
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

    public void addStudent(Student s) {
        students.add(s);
    }

    @Override
    public String toString() {
        return ("\n Group name: " + groupName + "\n Students: " + students + "\n Mentor: " + mentor).replace('[', ' ').replace(']', ' ');
    }

    @Override
    public boolean isAvailable(Interval at) {
        for (Interval interval : unavailable) {
            if (at.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void makeUnavailable(Interval interval) {
        this.unavailable.add(interval);
    }

    public int getGroupSize() {
        return this.students.size();
    }

    @Override
    public void makeAvailable(int i) {
        this.unavailable.remove(i);
    }
}