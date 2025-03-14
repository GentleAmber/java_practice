package static_;

public class MainParameters {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("The " + (i + 1) + "th parameter is: " + args[i]);
        }
    }
}
