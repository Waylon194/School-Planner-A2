package Data;

import java.util.ArrayList;

public class Lesson {

   private ArrayList<Teacher> teachers;
   private Classroom classroom;
   private ArrayList<Class> studentClass;

   public enum subject {

      MATH,
      PROGRAMMING,
      POC,
      WORKSHOP,
      GRAPhICS2D,
      GRAPHICS3D,
      OOM,
      HWI

   }

   public Lesson (ArrayList<Teacher> teachers, Classroom classroom, ArrayList<Class> studentClass) {

      this.teachers = teachers;
      this.classroom = classroom;
      this.studentClass = studentClass;

   }

   public ArrayList<Teacher> getTeacher () {
      return teachers;
   }

   public void setTeachers (ArrayList<Teacher> teacher) {
      this.teachers = teacher;
   }

   public Classroom getClassroom () {
      return classroom;
   }

   public void setClassroom (Classroom classroom) {
      this.classroom = classroom;
   }

   public ArrayList<Class> getStudentClass () {
      return studentClass;
   }

   public void setStudentClass (ArrayList<Class> studentClass) {
      this.studentClass = studentClass;
   }

   @Override
   public String toString() {
      return "Lesson{" +
              "teachers=" + teachers +
              ", classroom=" + classroom +
              ", studentClass=" + studentClass +
              '}';
   }
}