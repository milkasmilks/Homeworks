package Task6;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> map = new Map<>();
        map.put(1, "Anna");
        map.put(2, "Emma");
        map.put(2, "Vera");
        System.out.println(map.toString());
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue("Anna"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        Collection<String> collection = map.values();
        System.out.println(collection.toString());
        map.remove(2);
        System.out.println(map.toString());
    }
}
