package Data;

import org.joda.time.Interval;

public interface Availability {

    void makeUnavailable(Interval interval);
    void makeAvailable(int i);
    boolean isAvailable(Interval at);
}
