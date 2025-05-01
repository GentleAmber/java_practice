package bufferstream;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {
        String srcFilePath = "E:\\JavaCode\\test.txt";
        String desFilePath = "E:\\JavaCode\\test2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(desFilePath));

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
//                br.close();
                System.out.println("Copy success!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
