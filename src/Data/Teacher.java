package Data;

public class Teacher extends Person {
    private int teacherNumber;
    private Subject subject;

    public Teacher (String firstName, String additive, String lastName, int age, int xLocation, int yLocation, int teacherNumber, Subject subject) {
        super(firstName, additive, lastName, age, xLocation, yLocation);
        this.teacherNumber = teacherNumber;
        this.subject = subject;
    }

    public int getTeacherNumber () {
        return teacherNumber;
    }

    @Override
    public String toString () {
        return  getFirstName() + " " + getAdditive() + " " + getLastName() +
                "\n TeacherNumber: " + teacherNumber;
    }
}