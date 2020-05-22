package Task7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelsStringCounting {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<String>(Arrays.asList("Anna", "Leonardo", "Alexandra", "Sandro"));

        long count = mySet.stream()
                .filter (s -> countVowels(s) > 3)
                .count();

        System.out.println(count);
    }


    public static boolean test(char t) {
        return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u'
                || t == 'A' || t == 'E' || t == 'I' || t == 'O'
                || t == 'U';
    }

    public static int countVowels(String string) {
        int count = 0;
        char[] chars = string.toCharArray();
        for (char myChar: chars) {
            if (test(myChar)) {
                count++;
            }
        }
        return count;
    }
}
