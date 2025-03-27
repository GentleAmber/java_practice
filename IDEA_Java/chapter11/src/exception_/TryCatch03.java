package exception_;

public class TryCatch03 {
    public static int method(){
        try{
            String names[] = new String[3];
            if (names[1].equals("tom")) {//NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "abcdef";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return 3;
        } finally {//finally has to be executed anyway, so method() only returns 4 whatsoever.
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
