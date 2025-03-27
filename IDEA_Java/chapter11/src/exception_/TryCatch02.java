package exception_;

public class TryCatch02 {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//NullPointerException

            int num1 = 10, num2 = 0;
            int res = num1 / num2;//ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Person {
    String name;

    public String getName() {
        return name;
    }
}