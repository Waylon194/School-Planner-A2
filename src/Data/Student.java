package Data;

import Data.Person;

public class Student extends Person {
    private int studentNumber;

    /**
     * @param firstName first name of the student
     * @param additive middle part of the student name
     * @param lastName last name of the student
     * @param age age of the student in int
     * @param studentNumber student number in int
     */

    public Student (String firstName, String additive, String lastName, int age, int studentNumber) {
        super(firstName, additive, lastName, age);
        this.studentNumber = studentNumber;
    }

    /**
     * this method asks for the student Number
     * @return studentNumber
     */

    public int getStudentNumber () {
        return studentNumber;
    }

    /**
     * this changes the students number
     * @param studentNumber = studentNumber
     */

    public void setStudentNumber (int studentNumber) {
        this.studentNumber = studentNumber;
    }
}