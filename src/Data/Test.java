package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Test {


    public static void main(String[] args) {
        final DateTime NINE = new DateTime(2019, 1, 1, 9, 0, 0);
        final DateTime TEN = new DateTime(2019, 1, 1, 10, 0, 0);
        final DateTime ELEVEN = new DateTime(2019, 1, 1, 11, 0, 0);
        final DateTime TWELVE = new DateTime(2019, 1, 1, 12, 0, 0);
        final DateTime ONE = new DateTime(2019, 1, 1, 13, 0, 0);
        final DateTime TWO = new DateTime(2019, 1, 1, 14, 0, 0);
        final DateTime THREE = new DateTime(2019, 1, 1, 15, 0, 0);
        final DateTime FOUR = new DateTime(2019, 1, 1, 16, 0, 0);
        final DateTime FIVE = new DateTime(2019, 1, 1, 17, 0, 0);


        final Interval FIRST_LESSON = new Interval(NINE, TEN);
        final Interval SECOND_LESSON = new Interval(TEN, ELEVEN);
        final Interval THIRD_LESSON = new Interval(ELEVEN, TWELVE);
        final Interval FOURTH_LESSON = new Interval(TWELVE, ONE);
        final Interval FIFTH_LESSON = new Interval(ONE, TWO);
        final Interval SIXTH_LESSON = new Interval(TWO, THREE);
        final Interval SEVENTH_LESSON = new Interval(THREE, FOUR);
        final Interval EIGHT_LESSON = new Interval(FOUR, FIVE);

        Interval ug = new Interval(NINE,ELEVEN);
        Interval ugg = new Interval(TEN,ELEVEN);
        System.out.println(ugg.overlaps(ug));

    }
}
