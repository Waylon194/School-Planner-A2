package Simulation;

import Data.Person;

import java.util.ArrayList;

public class Room {
    private int seats;
    private int number;
    private String location;

    public void empty(){
        //Move everyone (students and teachers) to a specific place.
        ArrayList<Person> persons = new ArrayList<>();
        for (Person p : persons) {
            p.move();
        }
    }
}