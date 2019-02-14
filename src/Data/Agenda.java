package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable {
    private ArrayList<Lesson> lessons;

    public Agenda(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void printLessons() {
        for (Lesson l: lessons) {
            System.out.println(l);
        }
    }

    public int amountOfLessons(){
        return lessons.size();
    }


    

}