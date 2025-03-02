package equals;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);//true

        B bObj = a;//upcasting
        System.out.println(bObj == b);//true
        System.out.println(bObj.equals(b));//true. Check the source code

        int in1 = 10;
        double d1 = 10.0;
        System.out.println(in1 == d1);//true

        String hello1 = new String("Hello");
        String hello2 = new String("Hello");
        System.out.println(hello1 == hello2);//false. Not the same address
        System.out.println(hello1.equals(hello2));//true
    }
}
class B{}
class A extends B{}

