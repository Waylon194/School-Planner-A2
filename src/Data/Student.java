package Data;

public class Student extends Person {
    private int studentNumber;

    public Student(int age, String firstName, String additive, String lastName, int xLocation, int yLocation, int studentNumber) {
        super(age, firstName, additive, lastName, xLocation, yLocation);
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
}