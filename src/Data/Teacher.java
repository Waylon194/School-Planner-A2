package Data;

public class Teacher extends Person {
    private int teacherNumber;

    public Teacher (String firstName, String additive, String lastName, int age, int xLocation, int yLocation, int teacherNumber) {
        super(firstName, additive, lastName, age, xLocation, yLocation);
        this.teacherNumber = teacherNumber;
    }

    public int getTeacherNumber () {
        return teacherNumber;
    }

    public void setTeacherNumber (int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    @Override
    public String toString () {
        return  getFirstName() + " " + getAdditive() + " " + getLastName() +
                "\n TeacherNumber: " + teacherNumber;
    }
}
