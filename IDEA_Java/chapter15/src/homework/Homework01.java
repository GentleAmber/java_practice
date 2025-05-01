package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        /*
        1. 判断E盘下是否有文件夹mytemp，如果没有就创建
        2. 在E:\mytemp下创建hello.txt
        3. 如果hello.txt已存在就提示，且不再重复创建
         */
        String dir = "e:\\mytemp";
        File file = new File(dir);
        if (!file.exists()) {
            System.out.println("Created e:\\mytemp.");
            file.mkdir();
        }

        String txtName = "hello.txt";
        File txtFile = new File(dir, txtName);
        if (txtFile.exists()) {
            System.out.println("hello.txt already exists.");
        } else {
            txtFile.createNewFile();
        }

    }
}
