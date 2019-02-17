package Data;

import org.joda.time.DateTime;

public interface Available {

    boolean isAvailable(DateTime at);
    void makeUnavailable(DateTime from, DateTime at);



}
