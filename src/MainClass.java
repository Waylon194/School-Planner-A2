import Data.*;
import Data.Class;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {


        BigInteger bi = new BigInteger("31415926535");



        long hor = 0x80000000;
        long ver = 0x40000000;
        long diag = 0x20000000;
        System.out.println(ver);

        System.out.println(BigInteger.valueOf(hor).flipBit(3));





    }
}