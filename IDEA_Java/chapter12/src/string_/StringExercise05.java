package string_;

public class StringExercise05 {
    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and");
        System.out.println(ex.ch);
        //results:
        //abcd and
        //hava
    }
}
class Test1 {
    String str = new String("abcd");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }
}