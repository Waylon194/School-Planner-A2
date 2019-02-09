package Data;

import java.util.ArrayList;

public class Lesson {

   private ArrayList<Teacher> teachers;
   private Classroom classroom;
   private ArrayList <Class> studentClass;
   private Subject subject;

   public Lesson (ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Class> studentClass, Subject subject) {
      this.teachers = teachers;
      this.classroom = classroom;
      this.studentClass = studentClass;
      this.subject = subject;
   }

   @Override
   public String toString () {
      return "Lesson: " + this.subject +
              "teachers: " + teachers +
              ", classroom: " + classroom +
              ", studentClass: " + studentClass;
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



}