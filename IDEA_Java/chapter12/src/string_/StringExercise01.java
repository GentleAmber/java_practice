package string_;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
//        System.out.println(a == b.intern());
//        System.out.print("b == b.intern()");
//        System.out.println(b == b.intern());
//        System.out.println(b.equals(b.intern()));
        System.out.print("a's address: ");
        System.out.println(System.identityHashCode(a));  // Memory-based hashcode for a
        System.out.print("b's address: ");
        System.out.println(System.identityHashCode(b)); // Different memory-based hashcode for a1
        System.out.print("b.intern()'s address: ");
        System.out.println(System.identityHashCode(b.intern())); // Should match a



        String c = "welkjsdf";
        System.out.print("c's address: ");
        System.out.println(System.identityHashCode(c));

        System.out.print("c == c.intern()");
        System.out.println(c == c.intern());
        System.out.println(System.identityHashCode(c.intern())); // Should match c

    }
}
