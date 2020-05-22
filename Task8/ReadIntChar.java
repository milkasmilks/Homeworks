package Task8;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadIntChar {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\pc\\Desktop\\new.txt")) {
            int a = 0;
            int b = 0;
            char ch;
            for (int i = 3; i >= 0; i--) {
                a = fileInputStream.read() << i * 8 | a;
            }

            for (int i = 1; i >= 0; i--) {
                b = fileInputStream.read() << i * 8 | b;
            }

            ch = (char) b;
            System.out.println(a);
            System.out.println(ch);
        } catch (IOException ex) {
            System.err.println("Error");
        }
    }
}
