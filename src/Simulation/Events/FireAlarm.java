package Simulation.Events;

import Simulation.Room;

import java.util.ArrayList;

public class FireAlarm {
    public static void main(String[] args) {
        //Loop through all the rooms and execute the methode empty;
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room r: rooms) {
            r.empty();
        }
    }
}