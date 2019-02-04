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

    public Room(int seats, int number, String location) {
        this.seats = seats;
        this.number = number;
        this.location = location;
    }

    public int getSeats() {
        return seats;
    }

    public int getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}