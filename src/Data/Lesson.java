package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Lesson implements Serializable {
    private Teacher teacher;
    private ArrayList<Teacher> teachers;
    private Classroom classroom;
    private ArrayList <Group> studentClass;
    private Subject subject;
    private Interval interval;

   public Lesson (ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Group> studentClass, Subject subject, Interval interval) {
      this.teachers = teachers;
      this.classroom = classroom;
      this.studentClass = studentClass;
      this.subject = subject;
      this.interval = interval;
   }

   public Interval getInterval(){
       return this.interval;
   }

   public ArrayList<Teacher> getTeachers () {
      return teachers;
   }

    public String getTeachersAsString () {
        String teachers = "";
        for (Teacher teacher1 : this.teachers) {
            teachers+=teacher1.getLastName()+ ",";
        }

        return teachers;
    }



    public Classroom getClassroom () {
      return classroom;
   }

   public Subject getSubject () {
      return subject;
   }

   @Override
   public String toString () {
      return  ("\n Subject: " + this.subject +
              "\n Teachers: " + teachers +
              "\n Classroom: " + classroom + studentClass +
             // "\n Time" + getTime()).replace('[',' ').replace(']',' ');
              "\n Time: " + returnLessonTimeAsString());

   }

    public String returnBeginTimeAsString(){

        int hour = this.interval.toInterval().getStart().getHourOfDay();
        int intMinute = this.interval.toInterval().getStart().getMinuteOfHour();

        String minute = "";

        if (intMinute<10){
            minute+="0"+ String.valueOf(intMinute);
        }else{minute = String.valueOf(intMinute);}


        return hour+":"+minute;

    }

    public String returnEndTimeAsString(){

        int hour = this.interval.toInterval().getEnd().getHourOfDay();
        int intMinute = this.interval.toInterval().getEnd().getMinuteOfHour();

        String minute = "";

        if (intMinute<10){
            minute+="0"+ String.valueOf(intMinute);
        }else{minute = String.valueOf(intMinute);}


        return hour+":"+minute;
    }

    public String returnLessonTimeAsString(){
       return returnBeginTimeAsString()+"-"+returnEndTimeAsString();
    }



    public ArrayList<Group> getGroups(){
       return this.studentClass;
    }
}