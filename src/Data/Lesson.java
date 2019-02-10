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
              "\n teachers: " + teachers +
              "\n Classroom: " + classroom +
              "\n Class: " + studentClass;
   }
}
