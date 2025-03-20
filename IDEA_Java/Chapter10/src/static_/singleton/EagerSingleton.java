package static_.singleton;

public class EagerSingleton {
    public static void main(String[] args) {
//        GirlFriend myGf1 = GirlFriend.getInstance();
//        GirlFriend myGf2 = GirlFriend.getInstance();
//
//        System.out.println(myGf1 == myGf2);//True
//        System.out.println(myGf1.getName());
        System.out.println(GirlFriend.n1);
    }
}

class GirlFriend {
    private String name;
    public static int n1 = 100;

    private GirlFriend() {

    }

    private GirlFriend(String name) {
        this.name = name;
        System.out.println("Constructor is called.");
    }

    private static GirlFriend gf = new GirlFriend("Jiaxuan Du");

    public static GirlFriend getInstance() {
        return gf;
    }

    public String getName() {
        return name;
    }

}
