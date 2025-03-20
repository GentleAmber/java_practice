package enumeration_;

public class EnumExercise01 {
    public static void main(String[] args) {
        Week[] weekValues = Week.values();
        for (Week day : weekValues) {
            System.out.println(day);
        }
    }

}

enum Week {
    MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

