package Task7;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class StringLengthCounting {
    public static void main(String[] args) {
        Collection<String> strings = new HashSet<>(Arrays.asList("Anna", "Leonardo", "Alexandra", "Sandro"));

        Integer sum = strings.stream()
                .mapToInt(string -> string.length())
                .filter(l -> l > 5)
                .sum();

        System.out.println(sum);
    }
}
