package collection.set;

import java.util.Objects;

public class HashSetExercise02 {
    public static void main(String[] args) {
        DetailedEmployee jack1 = new DetailedEmployee("Jack", 31000, 1997, 12, 9);
        DetailedEmployee jack2 = new DetailedEmployee("Jack", 31000, 1997, 12, 9);
        System.out.println(jack1.hashCode() == jack2.hashCode());
        System.out.println(jack1.equals(jack2));
    }
}

class DetailedEmployee {
    private String name;
    private double sal;
    private MyDate birthday;

    class MyDate {
        int year;
        int month;
        int day;
        //This is an in-class exercise so I'll not verify the date.

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyDate)) return false;
            MyDate myDate = (MyDate) o;
            return year == myDate.year &&
                    month == myDate.month &&
                    day == myDate.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }
    }

    public DetailedEmployee(String name, double sal, int year, int month, int day) {
        this.name = name;
        this.sal = sal;
        this.birthday = new MyDate(year, month, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailedEmployee)) return false;
        DetailedEmployee that = (DetailedEmployee) o;
        return Double.compare(that.sal, sal) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday);
    }
}