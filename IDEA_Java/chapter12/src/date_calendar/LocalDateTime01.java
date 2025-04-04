package date_calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTime01 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

//        ldt.getMonth();
//        ldt.getDayOfMonth();
//        ldt.getHour();//...

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy  hh:mm:ss a");
        System.out.println(dtf.format(ldt));

    }
}
