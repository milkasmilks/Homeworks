package Task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class EndlessArrayTest {
    private EndlessArray<Integer> endlessArray;

    @Before
    public void init() {
        endlessArray.add(1);
        endlessArray.add(2);
    }

    @Test
    public void add() {
        endlessArray.add(3);
        endlessArray.add(4);
        Iterator<Integer> iterator = endlessArray.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("1234", stringBuilder.toString());
    }

    @Test
    public void remove() {
        endlessArray.remove(0);
        Iterator<Integer> iterator = endlessArray.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("2", stringBuilder.toString());
    }

    @Test
    public void contains() {
        boolean flag = endlessArray.contains(2);
        Assert.assertTrue(flag);
    }

    @Test
    public void getSize() {
        int size = endlessArray.getSize();
        Assert.assertEquals(2, size);
    }
}
