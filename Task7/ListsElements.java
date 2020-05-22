package Task7;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListsElements {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,3,4,5,6,8);
        List<Integer> list2 = Arrays.asList(4,3,5,1);

        Integer max = list2.stream()
                .max((i1, i2) -> i1 - i2)
                .get();

        list1.stream()
                .filter(i -> i > max)
                .forEach(System.out::println);
    }
}
