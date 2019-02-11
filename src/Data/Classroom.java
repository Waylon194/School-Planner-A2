package Data;

public class Classroom extends Room {
    private boolean smartBoard;
    private boolean whiteBoard;

    public Classroom (int number, int amountOfSeats, String location, boolean smartBoard, boolean whiteBoard) {
        super(number, amountOfSeats, location);
        this.smartBoard = smartBoard;
        this.whiteBoard = whiteBoard;
    }

    public boolean hasSmartBoard() {
        return smartBoard;
    }

    public boolean hasWhiteBoard() {
        return whiteBoard;
    }


}