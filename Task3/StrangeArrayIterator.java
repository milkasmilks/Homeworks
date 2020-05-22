package Task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StrangeArrayIterator implements Iterator<String> {
    private String[] array;
    private int      cursor;

    public StrangeArrayIterator(String[] array) {
        this.array = array;
        this.cursor = 0;
    }

    public boolean hasNext() {
        boolean flag = false;
        int cnt = 0;
        for (int i = cursor + 1; i < array.length && cnt < 2; i++) {
            if (array[i] != null) {
                cnt++;
            }
        }
        if (cnt == 2) {
            flag = true;
        }
        return flag;
    }

    public String next() {
        String element;
        int cnt = 0;
        try {
            element = array[cursor];
            for (int i = cursor + 1; i < array.length && cnt < 2; i++) {
                if (array[i] != null) {
                    cnt++;
                }
                if (i == array.length - 1 && array[i] == null) {
                    cursor = array.length;
                } else {
                    cursor = i;
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public static void main(String[] args) {
        String[] array = new String[]{"a", null, "b", "c", "d", null, null};
        StrangeArrayIterator sai = new StrangeArrayIterator(array);
        System.out.println(sai.hasNext());
        System.out.println(sai.next());
        System.out.println(sai.next());
        System.out.println(sai.hasNext());
        System.out.println(sai.next());
    }
}
