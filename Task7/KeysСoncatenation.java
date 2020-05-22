package Task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KeysСoncatenation {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("one", "Anna");
        map.put("two", "Elene");
        map.put("three", "Emma");

        Set<Map.Entry<String, String>> set = map.entrySet();

        String keys = set.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(",", "{", "}"));

        System.out.println(keys);
    }
}
