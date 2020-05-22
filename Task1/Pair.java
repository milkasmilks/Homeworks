package Task1;

public class Pair<T1, T2> {
    private T1 object1;
    private T2 object2;

    public Pair(T1 object1, T2 object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T1 getValueFirst() {
        return object1;
    }

    public T2 getValueSecond() {
        return object2;
    }

    public Class getTypeFirst() {
        return this.object1.getClass();
    }

    public Class getTypeSecond() {
        return this.object2.getClass();
    }
}
