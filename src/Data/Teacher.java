package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable{
    private String teacherNumber;
    private Subject subject;
    private ArrayList<Interval> unavailable;

    public Teacher (String firstName, String additive, String lastName, int age, int xLocation, int yLocation, String teacherNumber, Subject subject) {
        super(firstName, additive, lastName, age, xLocation, yLocation);
        this.unavailable = new ArrayList<>();
        this.teacherNumber = teacherNumber;
        this.subject = subject;
    }

    public String getTeacherNumber () {
        return teacherNumber;
    }

    @Override
    public String toString () {
        return (getFirstName() + " " + getAdditive() + " " + getLastName() +
                ", TeacherNumber: " + teacherNumber);
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