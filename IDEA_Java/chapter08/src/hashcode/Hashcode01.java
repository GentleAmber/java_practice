package hashcode;

public class Hashcode01 {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = obj1;

        System.out.println("Obj1's hashcode: " + obj1.hashCode());
        System.out.println("Obj2's hashcode: " + obj2.hashCode());
        System.out.println("Obj3's hashcode: " + obj3.hashCode());
        System.out.println(obj1.toString());
        System.out.println("Hello".toString());

        Integer in = new Integer(6);
        System.out.println(in.toString());


    }
}
class A{

}
