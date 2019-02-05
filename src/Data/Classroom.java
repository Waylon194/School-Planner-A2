package Data;

import java.io.Serializable;

public class Classroom implements Serializable {
    private boolean smartBoard;

    public boolean isSmartBoard() {
        return smartBoard;
    }

    public void setSmartBoard(boolean smartBoard) {
        this.smartBoard = smartBoard;
    }
}