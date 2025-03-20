package inner_class;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        System.out.println("In main, outer01 hashcode = " + outer01);
        outer01.m1();
    }
}

class Outer01 {
    public int n1 = 100;
    public void m1() {
        class Inner01 {
            int n1 = 200;
            public void m2() {
                System.out.println("Inner01 n1 = " + n1);//Finds the nearest n1
                System.out.println("Outer01 n1 = " + Outer01.this.n1);
                System.out.println("Outer01 hashcode = " + Outer01.this);
            }
        }
        Inner01 inner01 = new Inner01();
        inner01.m2();
    }
}