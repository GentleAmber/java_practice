package date_calendar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01{
    public static void main (String[] args) throws ParseException {
        Date date = new Date();//Get the system's time by default
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String s = "1999年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println(parse);
    }
}
