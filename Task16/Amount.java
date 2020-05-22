package Task16;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amount {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            URI uri = new URI(sc.nextLine().trim());
            BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
            String line;
            long amount = 0;
            Pattern pattern = Pattern.compile("<div");
            while ((line = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    amount++;
                }
            }
            System.out.println(amount);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}
