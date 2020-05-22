package Task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FirstLastArrayIterator<T> implements Iterator<T> {
    private T[]     array;
    private int     cursor;
    private int     count;

    private boolean flag = false;


    public FirstLastArrayIterator(T[] array) {
        this.array = array;
        cursor = 0;
        count = array.length - 1;
    }


    public boolean hasNext() {
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }


    public T next() {
        T element;
        try {
            element = array[cursor];
            if (count != 0) {
                if (flag == false) {
                    cursor += count;
                } else {
                    cursor -= count;
                }
                count--;
                flag = !flag;
            } else {
                cursor = array.length;
            }

        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public static void main(String[] args) {
        String[] array = new String[] {"a", "b", "c", "d", "e", "f"};
        FirstLastArrayIterator<String> flai = new FirstLastArrayIterator<String>(array);
        System.out.println(flai.hasNext());
        System.out.println(flai.next());
        System.out.println(flai.hasNext());
        System.out.println(flai.next());
        System.out.println(flai.next());
        System.out.println(flai.hasNext());
        System.out.println(flai.next());
        System.out.println(flai.next());
        System.out.println(flai.next());
        System.out.println(flai.hasNext());
        System.out.println(flai.next());
    }
}
