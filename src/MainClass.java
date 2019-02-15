import Data.*;
import Data.Class;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {











        Interval interval = new Interval(new DateTime(2013, 10, 25, 8, 0, 0, 0), new DateTime(2013, 10, 25, 9, 0, 0, 0));


        System.out.println(interval.toInterval().getStart().getHourOfDay());







    }
}