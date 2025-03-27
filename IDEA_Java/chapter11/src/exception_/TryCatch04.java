package exception_;

public class TryCatch04 {
    public static int method(){
        int i = 1;
        try{
            i++;//i=2
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
            return ++i;//i=3, temp=i. It won't execute immediately, but will wait for finally {}
            //to be finished. And then it returns temp, which is 3.
        } finally {//finally has to be executed anyway
            ++i;//i=4.
            System.out.println("i=" + i);//"i=4"
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }

}
