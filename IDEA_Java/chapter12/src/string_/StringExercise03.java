package string_;

public class StringExercise03 {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "abcdef";
        p2.name = "abcdef";

        System.out.println(p1.name.equals(p2.name));//T
        System.out.println(p1.name == p2.name);//T
        System.out.println(p1.name == "abcdef");//T

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);
    }
}

class Person {
    String name;
}