package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Lesson implements Serializable {
   private ArrayList<Teacher> teachers;
   private Classroom classroom;
   private ArrayList <Class> studentClass;
   private Subject subject;
   private Interval interval;

   public Lesson (ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Class> studentClass, Subject subject, Interval interval) {
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
              "\n Time" + this.interval.toInterval());

   }
}