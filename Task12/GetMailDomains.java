package Task12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMailDomains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the e-mail: ");
        String mail = sc.nextLine();
        List<String> list = getMailDomains(mail);
        for (String string: list) {
            System.out.println(string);
        }
    }

    public static List<String> getMailDomains(String mail) {
        List<String> list = new ArrayList<>();
        String mailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        if (Pattern.matches(mailRegex, mail)) {
            Matcher matcher = Pattern.compile("@(?!-)[A-Za-z0-9-]{1,63}(?<!-)").matcher(mail);
            if (matcher.find()) {
                list.add(matcher.group().substring(1));
            }
            matcher = Pattern.compile("[A-Za-z]{2,6}$").matcher(mail);
            if (matcher.find()) {
                list.add(matcher.group());
            }
        } else {
            list.add("This is not an  email");
        }
        return list;
    }
}
