package printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        String line = "Hello, john";
        out.println(line);
        out.write(line.getBytes());

        System.setOut(new PrintStream("e:\\mytemp\\hello.txt"));
        System.out.println(line);

    }
}
