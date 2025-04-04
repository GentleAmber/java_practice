package string_;

public class StringCommonMethods {
    public static void main(String[] args) {
        String format = "My name is %s. I'm %d years old. I scored %.2f in SAT and my " +
                "gender is %c.";
        String name = "Jack Cooper";
        int age = 18;
        double score = 180.523;
        char gender = 'F';

        String info = String.format(format,name,age,score,gender);
        System.out.println(info);

        String[] infoSplit = info.split("\\.");
        for (int i = 0; i < infoSplit.length; i++) {
            System.out.println(infoSplit[i]);
        }
    }
}
