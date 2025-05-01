package inputstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\hello.txt";
        int content = 0;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            while ((content = fileInputStream.read()) != -1) {
                System.out.println((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //必须关闭文件流，释放资源
            fileInputStream.close();
        }
    }
}
