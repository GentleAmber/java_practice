package inner_class;

public class AnonymousInnerClass {
    String name;
    public void m1() {
        System.out.println("Outer class m1 is called.");
        Father father = new Father() {
            @Override
            public void teach() {
                System.out.println("inner class teach()");
            }
        };
        father.teach();

        IA tiger = new IA() {
            @Override
            public void fly() {
                System.out.println("Tiger learns to fly!");
            }
        };
        tiger.fly();
    }

    public static void main(String[] args) {
        AnonymousInnerClass an = new AnonymousInnerClass();

        new Father().teach();
        an.m1();
    }
}

class Father {
    public void teach() {
        System.out.println("Father teaches his son.");
    }
}

interface IA {
    void fly();
}