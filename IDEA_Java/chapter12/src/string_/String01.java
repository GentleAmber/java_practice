package string_;

public class String01 {
    public static void main(String[] args) {
        String name = "jack";
        System.out.println(name.hashCode());
        name = "job";
        System.out.println(name.hashCode());

        //Two different ways to create a String have different mechanism
        String a = "abc";
        String b = "abc";
        System.out.println(a.equals(b));
        System.out.println(a == b);

        String c = new String("abc");
        System.out.println(a.equals(c));
        System.out.println(a == c);


    }
}
