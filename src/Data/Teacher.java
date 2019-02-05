package Data;

import Data.Person;

import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable {
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