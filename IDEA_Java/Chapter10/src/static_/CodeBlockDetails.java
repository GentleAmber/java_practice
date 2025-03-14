package static_;

public class CodeBlockDetails {
    public static void main(String[] args) {
        new A();//1) getN1(), 2) A-01, 3) getN2(), 4) A-99, 5) Constructor
    }
}

class A {
    private int n2 = getN2();
    private static int n1 = getN1();


    {
        System.out.println("A - code block 99 is called");
    }

    static {
        System.out.println("A - static code block 01");
    }

    public static int getN1() {
        System.out.println("static getN1 is called");
        return 100;
    }

    public int getN2() {
        System.out.println("getN2 is called");
        return 200;
    }

    public A() {
        System.out.println("Constructor without parameters is called");
    }
}
