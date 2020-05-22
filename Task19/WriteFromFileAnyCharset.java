package Task19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteFromFileAnyCharset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write path: ");
        Path path = Paths.get(sc.nextLine()).normalize().toAbsolutePath();
        System.out.println("Write charset: ");
        String charset = sc.nextLine();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path.toString()), charset);
            int n = -1;
            while((n = inputStreamReader.read()) != -1) {
                System.out.print((char)n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}