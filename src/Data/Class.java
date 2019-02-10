package Data;

import java.util.ArrayList;

public class Class {
   private ArrayList<Group> group;
   private String classCode;

   public Class (ArrayList<Group> group, String classCode) {
      this.group = group;
      this.classCode = classCode;
   }

   public ArrayList<Group> getGroup () {
      return this.group;
   }

   public String getClassCode () {
      return classCode;
   }

   @Override
   public String toString () {
      return "Class: " + getClassCode() + "\n" +
              " Contains groups: " + group;
   }
}