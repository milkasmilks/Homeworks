package Task21;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class EndlessArrayTest {
    private EndlessArray<Integer> endlessArray;

    @Before
    public void init() {
        endlessArray = new EndlessArray<>();
        endlessArray.add(1);
        endlessArray.add(2);
    }

    @Test
    public void addOneElement() {
        endlessArray.add(3);
        Iterator<Integer> iterator = endlessArray.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("123", stringBuilder.toString());
    }

    @Test
    public void addTwoElements() {
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
    public void removeThatExists() {
        endlessArray.remove(0);
        Iterator<Integer> iterator = endlessArray.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("2", stringBuilder.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeThatDoesNotExist() {
        endlessArray.remove(3);
    }

    @Test
    public void containsWhenContains() {
        boolean flag = endlessArray.contains(2);
        Assert.assertTrue(flag);
    }

    @Test
    public void containsWhenDoesNotContain() {
        boolean flag = endlessArray.contains(6);
        Assert.assertFalse(flag);
    }

    @Test
    public void getSizeWithoutAdding() {
        int size = endlessArray.getSize();
        Assert.assertEquals(2, size);
    }

    @Test
    public void getSizeWithAdding() {
        endlessArray.add(5);
        int size = endlessArray.getSize();
        Assert.assertEquals(3, size);
    }

    @Test
    public void getSizeWithRemoving() {
        endlessArray.remove(0);
        int size = endlessArray.getSize();
        Assert.assertEquals(1, size);
    }

    @Test
    public void getObjectThatContains() {
        int result = endlessArray.getObject(0);
        Assert.assertEquals(1, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getObjectThatDoesNotContain() {
        int result = endlessArray.getObject(3);
    }
}
