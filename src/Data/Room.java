package Data;

import java.io.Serializable;

public class Room implements Serializable {
    private int number;
    private int capacity;
    private String location;

    public Room(int number, int amountOfSeats, String location) {
        this.number = number;
        this.capacity = amountOfSeats;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public boolean empty(){
        if (true){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmpty(){
        if (this.capacity == 0) {
            return true;
        }
        else{
            return false;
        }
    }

    public String getAbbreviation(){
       return ((this.location.substring(0,2)).toUpperCase() + this.number);
    }

    @Override
    public String toString () {
        return (this.location + " "+ this.capacity+ " Capacity: "+ this.capacity);
    }
}