package wrapper;

public class WrapperClass {
    public static void main(String[] args) {
        Object obj = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj.getClass());
    }
}
