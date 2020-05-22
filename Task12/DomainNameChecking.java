package Task12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DomainNameChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the string to check: ");
        String name = sc.nextLine();
        System.out.println(isDomainName(name));
    }

    public static boolean isDomainName(String name) {
        return Pattern.matches("(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]", name);
    }
}
