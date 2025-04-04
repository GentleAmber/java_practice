package wrapper;

public class WrapperDetails {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        Integer m = 1;//Should step into this sentence to find out how instance in created.
        Integer n = 1;
        System.out.println(m == n);//true
        System.out.println("m's class is: " + m.getClass());

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false

        Integer m1 = 129;
        int m2 = 129;
        System.out.println(m1 == m2);
    }
}
