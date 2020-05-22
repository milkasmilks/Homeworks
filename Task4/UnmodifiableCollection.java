package Task4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnmodifiableCollection<T> {
    private T[] array;
    private int size;

    public UnmodifiableCollection(){
        size = 0;
        array = (T[]) new Object[size];

    }

    public UnmodifiableCollection(T obj) {
        size = 1;
        array = (T[]) new Object[size];
        array[0] = obj;
    }

    public UnmodifiableCollection(UnmodifiableCollection<?extends T> collection) {
        this.array = collection.array;
        this.size = collection.size;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            public boolean hasNext() {
                if (size > cursor) {
                    return true;
                } else {
                    return false;
                }
            }


            public T next() {
                T element;
                try {
                    element = array[cursor];
                    cursor++;
                } catch (IndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }
                return element;
            }

        };
    }

    public boolean equals(Collection<T> collection) {
        if (size != collection.size()) {
            return false;
        } else {
            Iterator<T> iterator1 = iterator();
            Iterator<T> iterator2 = collection.iterator();
            while (iterator1.hasNext()) {
                if (iterator1.next() != iterator2.next()) {
                    return false;
                }
            }
        } return true;
    }


    public int size() {
        return size;
    }

    public static void main(String[] args) {
        UnmodifiableCollection<Integer> collection = new UnmodifiableCollection<>(1);
        Iterator<Integer> it = collection.iterator();
        System.out.println(collection.size);
        System.out.println(it.hasNext());
        System.out.println(it.next());
    }
}
