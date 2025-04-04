package homework;

public class ReverseString_Version2 {
    public static void main(String[] args) {
        String str1 = "sudan";
        try {
            String reversed = reverse(str1, 0, 4);
            System.out.println(reversed);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {
        //Verify the data. Write the correct situations and then put a ! in the front
        if (!(str != null && start >= 0 && end < str.length() && end > start)) {
            throw new RuntimeException("Illegal input!");
        }

        StringBuilder sb = new StringBuilder(str);
        int reverseCharNum = end - start + 1;
        for (int i = start, j = 0; i <= start + reverseCharNum / 2 - 1; i++, j++) {
            char temp = sb.charAt(end - j);//Store the char near the end in temp
            sb.setCharAt(end - j, sb.charAt(i));//Set the char near the end to char near the start
            sb.setCharAt(i, temp);//Finish the reverse
        }
        return sb.toString();
    }
}
