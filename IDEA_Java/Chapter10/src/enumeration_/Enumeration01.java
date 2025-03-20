package enumeration_;

import java.util.EnumMap;

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.SPRING);
    }
}
enum Season2 {
    SPRING("Spring","warm"),SUMMER("Summer", "hot"),
    AUTUMN("Autumn", "cool"),WINTER("Winter", "freezing");

    private String name;
    private String desc;

//    public static final Season2 SPRING = new Season2("Spring", "warm");
//    public static final Season2 SUMMER = new Season2("Summer", "hot");
//    public static final Season2 AUTUMN = new Season2("Autumn", "cool");
//    public static final Season2 WINTER = new Season2("Winter", "freezing");
//Use enum to achieve:

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}