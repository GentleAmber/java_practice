package extends01;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();//What will be printed?
    }
}
class A{
//    String name;
    A() {
        System.out.println("a");
    }
    A (String name){
        System.out.println("a name");
    }
}
class B extends A{
    B(){
        this("abc");
        System.out.println("b");
    }
    B(String name){
        System.out.println("b name");
    }
}