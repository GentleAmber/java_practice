package string_;

public class StringBuffer02 {
    public static void main(String[] args) {
        String str = null;

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);

        StringBuffer sb1 = new StringBuffer(null);
        System.out.println(sb1);

    }
}
