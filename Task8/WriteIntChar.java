package Task8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteIntChar {
    public static void main(String[] args) {
        try(OutputStream fileOutputStream = new FileOutputStream("C:\\Users\\pc\\Desktop\\new.txt")) {
            int number = 588;
            char cr = 'к';
            for (int i = 3; i >= 0; i--) {
                fileOutputStream.write(number >> i * 8);
            }
            for (int i = 1; i >= 0; i--) {
                fileOutputStream.write(cr >> i * 8);
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
