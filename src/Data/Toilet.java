package Data;

import java.io.Serializable;

public class Toilet implements Serializable {
    private int amountOfToilets;

    public Toilet(int amountOfToilets) {
        this.amountOfToilets = amountOfToilets;
    }
}