package homework;

public class Homework01_ReverseString {
    public static void main(String[] args) {
        String name = "Sudan";
        String name2 = "millions";
        System.out.println(reverse(name, 0, 4));
        System.out.println(reverse(name2, 0, 7));
        System.out.println(reverse(name2, 1,6));
        System.out.println(reverse(name2, 2,4));
    }

    public static String reverse(String str, int start, int end) {
        //Reverse certain part of a String.
        //e.g. only reverse the four letters in the middle: "abcdef" ====> "aedcbf"

        //Verify the legality of end and start
        if (end - start < 0) {
            throw new IllegalStartOrEndException("The end index should be greater than the start index.");
        }

        //Start cooking
        try {
            StringBuilder sb = new StringBuilder(str);
            int reverseCharNum = end - start + 1;
            for (int i = start, j = 0; i <= start + reverseCharNum / 2 - 1; i++, j++) {
                char temp = sb.charAt(end - j);//Store the char near the end in temp
                sb.setCharAt(end - j, sb.charAt(i));//Set the char near the end to char near the start
                sb.setCharAt(i, temp);//Finish the reverse
            }
            return sb.toString();
        } catch (NullPointerException e) {
            System.out.println("Illegal String. Null pointer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Illegal start or end. Index out of bound.");
        }

        return "ERROR";//If failed, return "ERROR"
    }
}

class IllegalStartOrEndException extends RuntimeException {
    public IllegalStartOrEndException(String message) {
        super(message);
    }
}