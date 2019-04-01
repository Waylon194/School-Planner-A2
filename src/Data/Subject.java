package Data;

import java.io.Serializable;

public class Subject implements Serializable {
    private String name;


    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}