package Data;

import org.joda.time.Interval;
import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable, Availability{
    private String teacherNumber;
    private Subject subject;
    private ArrayList<Interval> unavailable;

    public Teacher (String firstName, String additive, String lastName, int age, int xLocation, int yLocation, String teacherNumber) {
        super(firstName, additive, lastName, age, xLocation, yLocation);
        this.unavailable = new ArrayList<>();
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherNumber () {
        return teacherNumber;
    }

    @Override
    public String toString () {
        return (getFirstName() + " " + getAdditive() + " " + getLastName() +
                ", TeacherNumber: " + teacherNumber);
    }

    @Override
    public boolean isAvailable(Interval at) {
        for(Interval interval: unavailable) {
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

    @Override
    public void makeAvailable(int i) {
        this.unavailable.remove(i);

    }


}