package Data;

public class Room {
    private int number;
    private int amountOfSeats;
    private String location;

    public Room(int number, int amountOfSeats, String location) {
        this.number = number;
        this.amountOfSeats = amountOfSeats;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
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
        if (true) {
            return true;
        }
        else{
            return false;
        }
    }
}