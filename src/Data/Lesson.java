package Data;

import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Lesson implements Serializable {
    private ArrayList<Teacher> teachers;
    private Classroom classroom;
    private ArrayList<Group> studentClass;
    private Subject subject;
    private Interval interval;
    private double popularity;

    public Lesson(ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Group> studentClass, Subject subject, Interval interval, int popularity) {
        this.teachers = teachers;
        this.classroom = classroom;
        this.studentClass = studentClass;
        this.subject = subject;
        this.interval = interval;
        this.popularity = popularity;
    }

    public Interval getInterval() {
        return this.interval;
    }

    public double getPopularity() {
        return popularity;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }


    public Classroom getClassroom() {
        return classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return ("\n Subject: " + this.subject + "\n Teachers: " + teachers + "\n Classroom: " + classroom + studentClass + "\n Time: " + returnLessonTimeAsString() + "\n Popularity: " + getPopularity());
    }

    public String returnBeginTimeAsString() {
        int hour = this.interval.toInterval().getStart().getHourOfDay();
        int intMinute = this.interval.toInterval().getStart().getMinuteOfHour();
        String minute = "";
        if (intMinute < 10) {
            minute += "0" + intMinute;
        } else {
            minute = String.valueOf(intMinute);
        }
        return hour + ":" + minute;
    }

    public String returnEndTimeAsString() {
        int hour = this.interval.toInterval().getEnd().getHourOfDay();
        int intMinute = this.interval.toInterval().getEnd().getMinuteOfHour();
        String minute = "";
        if (intMinute < 10) {
            minute += "0" + intMinute;
        } else {
            minute = String.valueOf(intMinute);
        }
        return hour + ":" + minute;
    }

    public String returnLessonTimeAsString() {
        return returnBeginTimeAsString() + "-" + returnEndTimeAsString();
    }

    public ArrayList<Group> getGroups() {
        return this.studentClass;
    }

    public String getGroupsAsString() {
        String groups = "";
        for (Group group : getGroups()) {
            groups += group.getGroupName();

        }
        return groups;
    }
}