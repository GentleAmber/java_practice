package inner_class;

public class AnonInnerClassApplication01 {
    public static void f1(Example ex) {
        ex.show();
    }

    public static void main(String[] args) {
        f1(new Example() {
            @Override
            public void show() {
                System.out.println("show implemented.");
            }
        });
    }
}

interface Example {
    void show();
}
