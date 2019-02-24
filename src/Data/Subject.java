package Data;

import java.io.Serializable;
import java.util.List;

public enum Subject implements Serializable {
   MATH,
   PROGRAMMING,
   WORKSHOP,
   HWI,
   GRAPHICS3D,
   GRAPHICS2D,
   NETWORKS,
   OPERATINGSYSTEMS
}

//New subject class DO NOT DELETE OR TOUCH!
//public class Subject {
//   private static List<String> subjects;
//   public static void main(String[] args) {
//      subjects.add("Math");
//      subjects.add("Programming");
//      subjects.add("GIT Workshop");
//      subjects.add("HWI");
//      subjects.add("Graphics 2D");
//   }
//
//   public List<String> getSubjects() {
//      return subjects;
//   }
//
//   public void addSubject(String subjectAsString){
//      subjects.add(subjectAsString);
//   }
//}