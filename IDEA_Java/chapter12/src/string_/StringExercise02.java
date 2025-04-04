package string_;

public class StringExercise02 {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);//false
        System.out.println(s2 == s4);//true
        System.out.println(s2.equals(s3));//true
        System.out.println(s1 == s2);//false
    }
}
