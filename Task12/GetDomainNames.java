package Task12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDomainNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        ArrayList<String> arrayList = getDomainNames(text);
        for (String string: arrayList) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> getDomainNames(String text) {
        ArrayList<String> arrayList = new ArrayList<>();
        String regex = "(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }
}
