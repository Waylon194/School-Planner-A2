package Simulation;

import Simulation.Room;

public class Toilet extends Room {

    private int amountOfToilets;

    public Toilet(int seats, int number, String location, int amountOfToilets) {
        super(seats, number, location);
        this.amountOfToilets = amountOfToilets;
    }
}