package exception_;

public class Exception01 {
    public static void main(String[] args) {
        int n1 = 10, n2 = 0;
        try {
            int res = n1 / n2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Programme continues running...");
    }
}
