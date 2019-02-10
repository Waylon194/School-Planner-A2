package Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lesson {
   private ArrayList<Teacher> teachers;
   private Classroom classroom;
   private ArrayList <Class> studentClass;
   private Subject subject;
   private LocalDateTime time;

   public Lesson (ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Class> studentClass, Subject subject, LocalDateTime time) {
      this.teachers = teachers;
      this.classroom = classroom;
      this.studentClass = studentClass;
      this.subject = subject;
      this.time = time;
   }

   public LocalDateTime getTime () {
      return time;
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
      return this.subject +
              "\n Teachers: " + teachers +
              "\n Classroom: " + classroom +
              "\n Class: " + studentClass +
              "\n Time" + getTime();
   }
}