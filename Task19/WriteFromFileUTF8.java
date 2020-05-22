package Task19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteFromFileUTF8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get(sc.nextLine()).normalize().toAbsolutePath();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8);
            int n = -1;
            while((n = inputStreamReader.read()) != -1) {
                System.out.print((char)n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
