package date_calendar;

import java.util.Calendar;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DATE) + " " + (c.get(Calendar.MONTH) + 1)
                + " " + c.get(Calendar.YEAR) + "\t" + c.get(Calendar.HOUR) + ":" +
                c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
        //There's also HOUR_OF_DAY for 24hr time format
    }


}
