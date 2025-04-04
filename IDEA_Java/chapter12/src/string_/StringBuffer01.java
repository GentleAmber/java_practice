package string_;

public class StringBuffer01 {
    public static void main(String[] args) {
        String str = "hello";
        StringBuffer s = new StringBuffer(str);

        s.append(100).append(true).append("ZhangSan");
        System.out.println("Post-append: " + s);

        s.delete(5,8);//[5,8)
        System.out.println("Post-delete: " + s);

        s.replace(5,9,", ");//[5,9)
        //P.S. String has a method that can search for a particular string and replace it
        System.out.println("Post-replace: " + s);

        s.insert(7, "LiSi, ");
        System.out.println("Post-insert: " + s);
    }
}
