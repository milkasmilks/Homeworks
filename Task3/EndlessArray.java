package Task1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class EndlessArray<T> implements Iterable<T>{

    /**
     * an array in which all current values are stored
     */
    private T[] array;

    /**
     * size of current array
     */
    private int     size;

    /**
     * commands that can be used
     */
    public final String[] COMMANDS = {"add", "contains", "equals", "hashCode", "help", "getCapacity", "getObject", "getSize", "remove"};


    @Override
    public Iterator<T> iterator() {
        return new EndlessArrayIterator();
    }

    private class EndlessArrayIterator<T> implements Iterator<T> {
        private int cursor;

        public EndlessArrayIterator() {
            cursor = 0;
        }

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
                element = (T) array[cursor];
                cursor++;
            } catch (IndexOutOfBoundsException ex) {
                throw new NoSuchElementException();
            }
            return element;
        }
    }

    public EndlessArray() {
        size = 0;
        array = (T[]) new Object[size];
    }

    public EndlessArray(T obj) {
        size = 1;
        array = (T[]) new Object[size];
        array[0] = obj;
    }
    public EndlessArray(EndlessArray array) {
        this.size = array.size;
        this.array = Arrays.copyOf(this.array, size);
    }

    /**
     * Add to EndlessArray your number
     * @param obj the number to add in EndlessArray
     */
    public void add(T obj) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (size + 1) * 2);
        }
        array[size] = obj;
        size++;
    }

    /**
     * Add to EndlessArray your array;
     * @param objects the array to add in EndlessArray
     */
    public void add (T[] objects) {
        while (size + objects.length >= array.length) {
            array = Arrays.copyOf(array, (size + 1) * 2);
        }
        for (int i = 0; i < objects.length; i++) {
            array[size] = objects[i];
            size++;
        }
    }


    /**
     * removes the element with the given index
     * @param index index of element that you need to remove
     */
    public void remove(int index) {
        if (index <= array.length - 1) {
            size--;
            for (int i = index; i < size; i++) {
                array[i] = array[i+1];
            }
        }
    }

    /**
     * Checks if a given number is in the EndlessArray
     * @param obj the object to check
     * @return index of number or -1 if there is no such number
     */
    public boolean contains(T obj) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == obj) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * get capacity of EndlessArray
     * @return get capacity of EndlessArray
     */
    public int getCapacity() {
        return array.length;
    }

    /**
     * return size of EndlessArray
     * @return return size of EndlessArray
     */
    public int getSize() {
        return size;
    }

    /**
     * return the number at the given index
     * @param index index of number
     * @return the number at the given index
     */
    public T getObject(int index) {
        T obj = (T) array[index];
        return obj;
    }

    /**
     * Check if two EndlessArrays equals each other
     * @param obj another EndlessArray to be tested for equality
     * @return true if they equals each other
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EndlessArray other = (EndlessArray) obj;
        if (this.size!= other.size) return false;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != other.array[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a hash code value for the object.
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    /**
     *
     */
    public void help() {
        System.out.println("Commands that can be ran: " + Arrays.toString(COMMANDS));
    }




    public static void main(String[] args) {
        EndlessArray<Integer> ea = new EndlessArray<>();
        ea.add(5);
        ea.add(6);
        System.out.println(ea.getSize());
        System.out.println(ea.getObject(0));
        System.out.println(ea.contains(5));
        Iterator<Integer> it = ea.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
    }


}
