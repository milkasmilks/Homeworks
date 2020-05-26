package Task21;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ModifiableCollection<T> {
    private T[] array;
    private int size;

    public ModifiableCollection(){
        size = 0;
        array = (T[]) new Object[size];

    }

    public ModifiableCollection(ModifiableCollection<?extends T> collection) {
        this.array = collection.array;
        this.size = collection.size;
    }

    public void add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (size + 1) * 2);
        }
        array[size] = element;
        size++;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            private boolean flag = false;

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
                    flag = true;
                } catch (IndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }
                return element;
            }

            public void remove() {
                if (flag) {
                    for (int i = cursor - 1; i < size - 1; i++) {
                        array[i] = array[i + 1];
                    }
                    size--;
                    cursor--;
                } else {
                    throw new IllegalStateException();
                }
            }
        };
    }

    public boolean equals(ModifiableCollection<T> collection) {
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
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(1);
        collection.add(2);
        ModifiableCollection<Integer> collection1 = new ModifiableCollection<>();
        collection1.add(1);
        collection1.add(2);
        System.out.println(collection.equals(collection1));
    }
}
