package Data;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private String firstName;
    private String additive;
    private String lastName;
    private int xLocation;
    private int yLocation;

    public Person(String firstName, String additive, String lastName, int age, int xLocation, int yLocation) {
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

    public void move(int moveToX, int moveToY) {
        int xDifference = moveToX - this.xLocation;
        int yDifference = moveToY - this.yLocation;
        //First move up or down
        for (int xCounter = 0; xCounter < xDifference; xCounter++) {
            if (xDifference <= 0) {
                this.xLocation--;
            } else {
                this.xLocation++;
            }
        }
        //Then move left or right
        for (int yCounter = 0; yCounter < yDifference; yCounter++) {
            if (yDifference <= 0) {
                this.yLocation--;
            } else {
                this.yLocation++;
            }
        }
    }
}