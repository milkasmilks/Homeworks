package Task6;

import java.util.*;

public class Map<K,V> {
    private Set<MyEntry> entrySet;

    public Map () {
        entrySet = new HashSet<>();
    }

    public Map (Map map) {
        this.entrySet = map.entrySet;
    }

    public void clear() {
        entrySet.clear();
    }

    public Object clone() {
        Map<K,V> map = new Map<>();
        map.entrySet = this.entrySet;
        return map;
    }

    public boolean containsKey(Object key) {
        if (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                if (myEntry.key == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        if (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                if (myEntry.value == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<MyEntry> entrySet() {
        return entrySet;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map<?, ?> map = (Map<?, ?>) o;
        return Objects.equals(entrySet, map.entrySet);
    }

    public V get(Object key) {
        if (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                if (myEntry.key == key) {
                    return myEntry.value;
                }
            }
        }
        return null;
    }

    public int hashCode() {
        return Objects.hash(entrySet);
    }

    public boolean isEmpty() {
        return entrySet.size() <= 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = null;
        for (MyEntry myEntry: entrySet) {
            keySet.add(myEntry.getKey());
        }
        return keySet;
    }

    public V put(K key, V value) {
        if (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                if (myEntry.key == key) {
                    V oldValue = myEntry.value;
                    myEntry.setValue(value);
                    return oldValue;
                }
            }
        }
        MyEntry newEntry = new MyEntry(key,value);
        entrySet.add(newEntry);
        return null;
    }

    public V remove (Object key) {
        if  (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                if (myEntry.key == key) {
                    V oldValue = myEntry.value;
                    entrySet.remove(myEntry);
                    return oldValue;
                }
            }
        }
        return null;
    }

    public int size() {
        return entrySet.size();
    }

    public String toString() {
        String string = "Map{ ";
        if (entrySet != null) {
            for (MyEntry myEntry : entrySet) {
                string = string + myEntry.key + "-" + myEntry.value + "; ";
            }
        }
        string += "}";
        return string;
    }

    public Collection<V> values() {
        Collection<V> values = new HashSet<>();
        for (MyEntry myEntry: entrySet) {
            values.add(myEntry.value);
        }
        return values;
    }

    private class MyEntry implements java.util.Map.Entry {
        private K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(Object value) {
            V oldValue = this.value;
            this.value = (V) value;
            return oldValue;
        }
    }
}
