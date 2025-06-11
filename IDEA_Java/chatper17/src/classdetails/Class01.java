package classdetails;

// Demonstrates common methods in class Class

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {

        // Every single class only has one Class for it
        Class<?> cls1 = Class.forName("reflection.Cat");
        Class<?> cls2 = Class.forName("reflection.Cat");
        System.out.println("The hashcodes of cls1 and cls2 are equal: "
                + (cls1.hashCode() == cls2.hashCode()));


    }
}
