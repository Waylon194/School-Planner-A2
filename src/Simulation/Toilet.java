package Simulation;

import Simulation.Room;

public class Toilet extends Room {
    private int amountOfToilets;

    public Toilet(int seats, int number, String location) {
        super(seats, number, location);
    }
}