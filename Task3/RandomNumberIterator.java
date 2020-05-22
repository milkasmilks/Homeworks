package Task3;

import java.util.Iterator;
import java.util.Random;

public class RandomNumberIterator implements Iterator<Integer> {
    private int[] array;

    public RandomNumberIterator(int[] array) {
        this.array = array;
    }


    public boolean hasNext() {
        return true;
    }


    public Integer next() {
        Random random = new Random();
        int num = random.nextInt(array.length);
        return array[num];
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        RandomNumberIterator rui = new RandomNumberIterator(array);
        System.out.println(rui.hasNext());
        System.out.println(rui.next());
        System.out.println(rui.next());
        System.out.println(rui.next());
        System.out.println(rui.next());
        System.out.println(rui.next());
    }
}
