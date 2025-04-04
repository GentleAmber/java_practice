package wrapper;

public class WrapperToString {
    public static void main(String[] args) {
        Integer i = 100;
        //method 1
        String str1 = i + "";
        //method 2
        String str2 = i.toString();
        //method 3
        String str3 = String.valueOf(i);

        //String to Integer
        //method 1
        Integer integer1 = Integer.parseInt(str1);
        //method 2
        Integer integer2 = new Integer(str1);
    }
}
