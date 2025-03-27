package customexception;

public class CustomException01 {
    public static void main(String[] args) {
        //If age is not between 18 - 120, throw an exception.
        int age = 130;

        if (age < 18 || age > 120) {
            throw new AgeException("Age should be 18-120.");
        } else {
            System.out.println("OK.");
        }

    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}