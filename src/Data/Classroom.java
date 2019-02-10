package Data;

public class Classroom {
    private boolean smartBoard;
    private boolean whiteBoard;

    public Classroom(boolean smartBoard, boolean whiteBoard) {
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