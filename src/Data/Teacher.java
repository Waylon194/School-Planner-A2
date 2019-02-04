package Data;

import Data.Person;

import java.util.ArrayList;

public class Teacher extends Person { //We moeten even kijken wat we gaan gebruiken om de vakken aan te duiden van een docent.
    private int teacherNumber;
    private ArrayList<Enum> subjects;

    /**
     * @param firstName first name of the student
     * @param additive middle part of the student name
     * @param lastName last name of the student
     * @param age age of the student in int
     * @param teacherNumber teacher number in int
     * @param subjects the courses of the teacher
     */


    public Teacher (String firstName, String additive, String lastName, int age, int teacherNumber, ArrayList<Enum> subjects) {
        super(firstName, additive, lastName, age);
        this.teacherNumber = teacherNumber;
        this.subjects = subjects;
    }

    /**
     * gets the number of the teacher
     * @return teacher number
     */

    public int getTeacherNumber () {
        return teacherNumber;
    }

    /**
     * changes the number of the teacher
     * @param teacherNumber = teacherNumber
     */

    public void setTeacherNumber (int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    /**
     * gets all the subjects of the teacher
     * @return subjects
     */

    public ArrayList<Enum> getSubjects () {
        return subjects;
    }

    /**
     * changes a subject of the teacher
     * @param subjects = subjects
     */

    public void setSubjects (ArrayList<Enum> subjects) {
        this.subjects = subjects;
    }


}