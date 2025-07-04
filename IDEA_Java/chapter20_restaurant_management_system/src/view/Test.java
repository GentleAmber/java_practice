package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        String addressPattern = "[0-9]+.+[,]\\s[a-zA-Z]{2}[0-9]{1,2}\\s[0-9]{1,2}[a-zA-Z]{2}";
//        String content = "39/2 New Paul's Road, London, ET3 2TY\n11 St Jame's Farm, Aberdeen, EJ0 14TX";
//
//        Pattern pattern = Pattern.compile(addressPattern);
//        Matcher matcher = pattern.matcher(content);
//
//        while (matcher.find())
//            System.out.println(matcher.group(0));

//        String spattern = "[0-9]+[.]?[0-9]+";
//        String content = "// example1 : 53453.234" +
//                "        // example2 : 163.com\n" +
//                "        // mail example3 : 234521";
//
//        Pattern pattern = Pattern.compile(spattern);
//        Matcher matcher = pattern.matcher(content);
//
//        while (matcher.find())
//            System.out.println(matcher.group(0));

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Float: " + Float.parseFloat(s));
    }
}
