package Task21;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class ModifiableCollectionTest {
    private Task21.ModifiableCollection<Integer> modifiableCollection;

    @Before
    public void init() {
        modifiableCollection = new ModifiableCollection<>();
        modifiableCollection.add(1);
        modifiableCollection.add(2);
    }

    @Test
    public void addOneNewElement() {
        modifiableCollection.add(3);
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("123", stringBuilder.toString());
    }

    @Test
    public void addTwoDifferentNewElements() {
        modifiableCollection.add(3);
        modifiableCollection.add(4);
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("1234", stringBuilder.toString());
    }

    @Test
    public void addTwoEqualsNewElements() {
        modifiableCollection.add(3);
        modifiableCollection.add(3);
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("1233", stringBuilder.toString());
    }

    @Test
    public void iteratorWithoutAdding() {
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("12", stringBuilder.toString());
    }

    @Test
    public void iteratorWithAdding() {
        modifiableCollection.add(3);
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("123", stringBuilder.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void iteratorWithRemovingWithoutNext() {
        Iterator<Integer> iterator = modifiableCollection.iterator();
        iterator.remove();
    }

    @Test
    public void iteratorWithRemovingWithNext() {
        Iterator<Integer> iterator = modifiableCollection.iterator();
        iterator.next();
        iterator.remove();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("2", stringBuilder.toString());
    }

    @Test
    public void equalsIdenticalCollection() {
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(1);
        collection.add(2);
        boolean flag = modifiableCollection.equals(collection);
        Assert.assertTrue(flag);
    }

    @Test
    public void equalsIdenticalCollectionButDifferentOrder() {
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(2);
        collection.add(1);
        boolean flag = modifiableCollection.equals(collection);
        Assert.assertFalse(flag);
    }

    @Test
    public void equalsDifferentCollection() {
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(3);
        boolean flag = modifiableCollection.equals(collection);
        Assert.assertFalse(flag);
    }

    @Test
    public void sizeWithoutAdding() {
        int size = modifiableCollection.size();
        Assert.assertEquals(2, size);
    }

    @Test
    public void sizeWithAdding() {
        modifiableCollection.add(3);
        int size = modifiableCollection.size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void sizeWithRemoving() {
        Iterator<Integer> iterator = modifiableCollection.iterator();
        iterator.next();
        iterator.remove();
        int size = modifiableCollection.size();
        Assert.assertEquals(1, size);
    }

}
