package Data;

public class Student extends Person {
    private int studentNumber;

    public Student(String firstName, String additive, String lastName, int age, int xLocation, int yLocation, int studentNumber) {
        super(firstName, additive, lastName, age, xLocation, yLocation);
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString () {
        return "Student: " + getFirstName() +" "+ getAdditive() +" "+ getLastName() +
                ", StudentNumber: " + studentNumber;
    }
}