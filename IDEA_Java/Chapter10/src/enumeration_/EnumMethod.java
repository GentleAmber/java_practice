package enumeration_;

public class EnumMethod {
    //Use Season2 as an example to show different methods
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN.name());
        System.out.println(Season2.AUTUMN.toString());
        System.out.println(Season2.AUTUMN.hashCode());
        System.out.println(Season2.AUTUMN.ordinal());

        System.out.println("===============values==============");
        Season2[] values = Season2.values();
        for (Season2 season : values) {
            System.out.println(season);
        }
        System.out.println("===============valueOf==============");
        Season2 searchForAutumn = Season2.valueOf("AUTUMN");
        System.out.println(searchForAutumn);

        System.out.println("===============compareTo===============");
        System.out.println(Season2.AUTUMN.compareTo(Season2.SPRING));
    }
}
