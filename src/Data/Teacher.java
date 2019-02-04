package Data;

import Data.Person;
import java.util.ArrayList;

public class Teacher extends Person { //We moeten even kijken wat we gaan gebruiken om de vakken aan te duiden van een docent.
    private int teacherNumber;
    //We have to decide on what we use to display the subject of a teacher.
    private ArrayList<Enum> subjects;

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public ArrayList<Enum> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Enum> subjects) {
        this.subjects = subjects;
    }
}