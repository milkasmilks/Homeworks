package Task4;

import java.util.*;

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
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        System.out.println(collection.size);
        Iterator<Integer> it = collection.iterator();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
    }
}
