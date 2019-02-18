package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Lesson implements Serializable {
    private Teacher teacher;
    private HashMap<String,Teacher> teachers;
    private Classroom classroom;
    private ArrayList <Group> studentClass;
    private Subject subject;
    private Interval interval;

   public Lesson (HashMap<String,Teacher> teachers, Classroom classroom, ArrayList<Group> studentClass, Subject subject, Interval interval) {
      this.teachers = teachers;
      this.classroom = classroom;
      this.studentClass = studentClass;
      this.subject = subject;
      this.interval = interval;
   }

   public Interval getInterval(){
       return this.interval;
   }

   public HashMap<String,Teacher> getTeachers () {
      return teachers;
   }

    public String getTeachersAsString () {
        String teachers = "";

        for(Map.Entry<String,Teacher> teacher: this.teachers.entrySet()){

            teachers+= teacher.getValue().getLastName() +",";
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

    public String getGroupsAsString(){
       String groups = "";

        for (Group group : getGroups()) {
            groups+=group.getGroupName();

        }
       return groups;

    }
}