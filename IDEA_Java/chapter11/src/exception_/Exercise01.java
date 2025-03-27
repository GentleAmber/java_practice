package exception_;

public class Exercise01 {
    public static double cal(int n1, int n2) {

        return (double)n1 / n2;//division between float or double won't throw exception when
        //n2=0. This follows the IEEE 754 international standard. So an exception should be
        //created manually.
    }

    public static void main(String[] args) {
        // Receives parameters from the command line and calculate n1/n2.
        // Throws the following three exceptions: 1) ArrayIndexOutOfBounds, 2) Wrong number format,
        // and 3) divided by zero.

        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("Wrong number of parameters.");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            if (n2 == 0) {
                throw new ArithmeticException("Divided by zero");
            }
            System.out.println(cal(n1, n2));

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }
}
