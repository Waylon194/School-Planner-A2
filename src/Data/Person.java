package Data;

public class Person {
    private int age;
    private String firstName;
    private String additive;
    private String lastName;
    private int xLocation;
    private int yLocation;

    public Person ( String firstName, String additive, String lastName, int age, int xLocation, int yLocation) {
        this.age = age;
        this.firstName = firstName;
        this.additive = additive;
        this.lastName = lastName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAdditive() {
        return additive;
    }

    public String getLastName() {
        return lastName;
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void move(int x, int y){
        xLocation = x;
        yLocation = y;
    }
}