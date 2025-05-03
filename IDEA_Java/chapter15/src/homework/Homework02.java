package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        /*
        使用BufferedReader读取一个文本文件，给每行加上分号，输出到屏幕
         */
        BufferedReader br = new BufferedReader(new FileReader("src\\practice.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line + ";");
        }

        br.close();
    }
}
