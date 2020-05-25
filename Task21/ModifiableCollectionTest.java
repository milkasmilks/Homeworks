package Task4;

import org.junit.*;
import java.util.Iterator;

public class ModifiableCollectionTest {
    private ModifiableCollection<Integer> modifiableCollection;

    @Before
    public void init() {
        modifiableCollection = new ModifiableCollection<>();
        modifiableCollection.add(1);
        modifiableCollection.add(2);
    }

    @Test
    public void add() {
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
    public void iterator() {
        Iterator<Integer> iterator = modifiableCollection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        Assert.assertEquals("12", stringBuilder.toString());
    }

    @Test
    public void equals() {
        ModifiableCollection<Integer> collection = new ModifiableCollection<>();
        collection.add(1);
        collection.add(2);
        boolean flag = modifiableCollection.equals(collection);
        Assert.assertTrue(flag);
    }

    @Test
    public void size() {
        int size = modifiableCollection.size();
        Assert.assertEquals(2, size);
    }
}
