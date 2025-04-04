package date_calendar;

import java.util.Date;
import java.time.Instant;

public class Instant01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        Date date = Date.from(now);
        System.out.println(date);
    }
}
