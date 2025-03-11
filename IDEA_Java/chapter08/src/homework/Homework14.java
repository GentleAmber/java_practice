package homework;

public class Homework14 {
    public static void main(String[] args) {
        C c = new C();
    }
}

class A{
    public A(){
        System.out.println("I am class A.");
    }
}

class B extends A{
    public B(){
        System.out.println("I am none-parameter constructor of B.");
    }
    public B(String name) {
        System.out.println(name + "I am constructor of B with parameters.");
    }
}
class C extends B{
    public C() {
        this("hello");
        System.out.println("I am none-parameter constructor of C");
    }
    public C(String name) {
        super("hahah");
        System.out.println("I am constructor of C with parameters.");
    }
}