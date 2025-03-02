package polymorphism;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());//30
        System.out.println(a.sum1());//30 -> sum1() in B made to comments -> 20
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10;
        //When there is a getI() in subclass B, it goes back to B's getI()
        //and returns 20. So a.sum() = 20 + 10 = 30
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

    public int getI() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}