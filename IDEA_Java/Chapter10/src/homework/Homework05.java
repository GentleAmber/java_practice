package homework;

public class Homework05 {
    public static void main(String[] args) {
        new A("Jane OuterA").innerClass();
    }
}

class A {

    private String name;

    public A(String name) {
        this.name = name;
    }

    public void innerClass() {
        class B{
            private String name;
            public void show() {
                System.out.println(name);
                System.out.println(A.this.name);
            }

            public B(String name) {
                this.name = name;
            }
        }
        new B("Jack InnerB").show();
    }

}