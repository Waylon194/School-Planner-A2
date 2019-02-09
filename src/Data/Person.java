package Data;

public class Person {
    private int age;
    private String firstName;
    private String additive;
    private String lastName;
    private int xLocation;
    private int yLocation;

    public Person(int age, String firstName, String additive, String lastName, int xLocation, int yLocation) {
        this.age = age;
        this.firstName = firstName;
        this.additive = additive;
        this.lastName = lastName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void move(int x, int y){
        xLocation = x;
        yLocation = y;
    }
}