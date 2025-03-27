package exception_;

public class TryCatch01 {
    public static void main(String[] args) {
        int n1 = 10, n2 = 0;
        try {
            int res = n1 / n2;
        } finally {
            System.out.println("Finally is run.");
        }
        System.out.println("Programme continues running...");
    }
}
