package enumeration_;

public class Enumeration0 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.WINTER);
    }
}

class Season {
    private String name;
    private String desc;

    public static final Season SPRING = new Season("Spring", "warm");
    public static final Season SUMMER = new Season("Summer", "hot");
    public static final Season AUTUMN = new Season("Autumn", "cool");
    public static final Season WINTER = new Season("Winter", "freezing");


    private Season(String name, String desc) {
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