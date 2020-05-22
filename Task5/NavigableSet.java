package Task5;

import java.util.*;

public class NavigableSet<T extends Comparable<T>> extends AbstractSet implements SortedSet {

    /**
     * an ArrayList in which all elements are stored
     */
    private ArrayList<T>  data;

    /**
     * a comparator to compare elements
     */
    private Comparator<T> comparator;

    /**
     * class constructor
     */
    public NavigableSet () {
        ArrayList<T> arrayList = new ArrayList<>();
        data = arrayList;
        comparator = null;
    }

    /**
     * Class constructor specifying the comparator to compare elements
     * @param comparator the comparator to compare elements
     */
    public NavigableSet (Comparator<T> comparator) {
        ArrayList<T> arrayList = new ArrayList<>();
        data = arrayList;
        this.comparator = comparator;
    }

    /**
     * Class constructor specifying the comparator to compare elements and Collection of elements which will be stored in ArrayList
     * @param collection Collection of elements which will be stored in ArrayList
     * @param comparator the comparator to compare elements
     */
    public NavigableSet (Collection<T> collection, Comparator<T> comparator) {
        ArrayList<T> arrayList = new ArrayList<>(collection);
        this.comparator = comparator;
        arrayList.sort(comparator);
        data = arrayList;
    }


    /**
     * orderly adds the specified element to this set if it is not already present
     * @param obj element to be added to this set
     */
    public void add(T obj) {
        boolean flag = true;
        for (int i = 0; i < data.size() && flag ; i++) {
            if (data.get(i) == obj) {
                flag = false;
            }
        }
        if (flag) {
            data.add(obj);
            data.sort(comparator);
        }
    }

    /**
     * returns the greatest element in this set strictly less than the given element, or null if there is no such element
     * @param obj the value to match
     * @return the greatest element less than e, or null if there is no such element
     */
    public T lower(T obj) {
        T element = null;
        T tempElement;
        Iterator<T> iterator = iterator();
        Comparator<T> comparator = comparator();
        while (iterator.hasNext()) {
            tempElement = iterator.next();
            if (comparator.compare(obj, tempElement) > 0) {
                element = tempElement;
            }
        }
        return element;
    }

    /**
     * returns the greatest element in this set less than or equal to the given element, or null if there is no such element
     * @param obj the value to match
     * @return the greatest element less than or equal to e, or null if there is no such element
     */
    public T floor(T obj) {
        T element = null;
        T tempElement;
        Iterator<T> iterator = iterator();
        Comparator<T> comparator = comparator();
        while (iterator.hasNext()) {
            tempElement = iterator.next();
            if (comparator.compare(obj, tempElement) >= 0) {
                element = tempElement;
            }
        }
        return element;
    }

    /**
     * returns the least element in this set greater than or equal to the given element, or null if there is no such element
     * @param obj the value to match
     * @return the least element greater than or equal to e, or null if there is no such element
     */
    public T ceiling(T obj) {
        T element = null;
        T tempElement;
        Iterator<T> iterator = iterator();
        Comparator<T> comparator = comparator();
        while (iterator.hasNext() && element == null) {
            tempElement = iterator.next();
            if (comparator.compare(tempElement, obj) >= 0) {
                element = tempElement;
            }
        }
        return element;
    }

    /**
     * returns the least element in this set strictly greater than the given element, or null if there is no such element
     * @param obj the value to match
     * @return the least element greater than e, or null if there is no such element
     */
    public T higher(T obj) {
        T element = null;
        T tempElement;
        Iterator<T> iterator = iterator();
        Comparator<T> comparator = comparator();
        while (iterator.hasNext() && element == null) {
            tempElement = iterator.next();
            if (comparator.compare(tempElement, obj) > 0) {
                element = tempElement;
            }
        }
        return element;
    }

    /**
     * retrieves and removes the first (lowest) element, or returns null if this set is empty
     * @return the first element, or null if this set is empty
     */
    public T pollFirst() {
        T element = data.get(0);
        data.remove(0);
        return element;
    }

    /**
     * retrieves and removes the last (highest) element, or returns null if this set is empty
     * @return the last element, or null if this set is empty
     */
    public T pollLast() {
        T element = data.get(size()-1);
        data.remove(size()-1);
        return element;
    }

    /**
     * returns an iterator over the elements in this set, in ascending order
     * @return an iterator over the elements in this set, in ascending order
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            public boolean hasNext() {
                return data.size() > cursor;
            }

            public T next() {
                T element;
                try {
                    element = data.get(cursor);
                    cursor++;
                } catch (IndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }
                return element;
            }
        };
    }

    /**
     * returns a reverse order view of the elements contained in this set
     * @return a reverse order view of this set
     */
    public NavigableSet<T> descendingSet() {
        Comparator<T> reverseComp = new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o2.compareTo(o1);
            }
        };
        ArrayList<T> reverseData = data;
        reverseData.sort(reverseComp);
        Collection<T> collection = reverseData;
        return new NavigableSet<>(collection, reverseComp);
    }

    /**
     * returns an iterator over the elements in this set, in descending order
     * @return an iterator over the elements in this set, in descending order
     */
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            private int cursor = data.size() - 1;

            public boolean hasNext() {
                return data.size() > cursor;
            }

            public T next() {
                T element;
                try {
                    element = data.get(cursor);
                    cursor--;
                } catch (IndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }
                return element;
            }
        };
    }

    /**
     * returns a view of the portion of this set whose elements range from fromElement to toElement
     * @param fromElement low endpoint of the returned set
     * @param fromInclusive true if the low endpoint is to be included in the returned view
     * @param toElement high endpoint of the returned set
     * @param toInclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    public NavigableSet subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        int fstIndex = data.indexOf(fromElement);
        int sndIndex = data.indexOf(toElement);
        ArrayList<T> subData;
        if (fromInclusive && toInclusive) {
            subData = new ArrayList<>(data.subList(fstIndex, sndIndex + 1));
        } else if (fromInclusive && !toInclusive) {
            subData = new ArrayList<>(data.subList(fstIndex, sndIndex));
        } else if (!fromInclusive && toInclusive) {
            subData = new ArrayList<>(data.subList(fstIndex + 1, sndIndex + 1));
        } else {
            subData = new ArrayList<>(data.subList(fstIndex + 1, sndIndex));
        }
        Collection<T> newData = subData;
        return new NavigableSet(newData, comparator) ;
    }

    /**
     * returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     * @param toElement high endpoint of the returned set
     * @param inclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     */
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        int index = data.indexOf(toElement);
        ArrayList<T> headData = new ArrayList<>(data.subList(0, index)) ;
        if (inclusive) {
            headData.add(index, toElement);
        }
        Collection<T> newData = headData;
        return new NavigableSet<>(newData, comparator);
    }

    /**
     * returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement
     * @param fromElement low endpoint of the returned set
     * @param inclusive true if the low endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        int index = data.indexOf(fromElement);
        ArrayList<T> tailData;
        if (inclusive) {
            tailData = new ArrayList<>(data.subList(index, data.size()));
        } else {
            tailData = new ArrayList<>(data.subList(index + 1, data.size()));
        }
        Collection<T> newData = tailData;
        return new NavigableSet<>(newData, comparator) ;
    }

    /**
     * returns the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements
     * @return the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements
     */
    public Comparator<T> comparator() {
        return new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    /**
     * returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     * @param fromElement low endpoint (inclusive) of the returned set
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    public SortedSet subSet(Object fromElement, Object toElement) {
        T toElementT = (T) toElement;
        T fromElementT = (T) fromElement;
        int fstIndex = data.indexOf(fromElement);
        int sndIndex = data.indexOf(toElement);
        ArrayList<T> subData = new ArrayList<>(data.subList(fstIndex, sndIndex));
        TreeSet<T> treeSet = new TreeSet<>(subData);
        SortedSet<T> sortedSet = treeSet;
        return sortedSet;
    }

    /**
     * returns a view of the portion of this set whose elements are strictly less than toElement
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly less than toElement
     */
    public SortedSet<T> headSet(Object toElement) {
        T toElementT = (T) toElement;
        int index = data.indexOf(toElement);
        ArrayList<T> headData = new ArrayList<>(data.subList(0, index));
        TreeSet<T> treeSet = new TreeSet<>(headData);
        SortedSet<T> sortedSet = treeSet;
        return sortedSet;
    }

    /**
     * returns a view of the portion of this set whose elements are greater than or equal to fromElement
     * @param fromElement low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    public SortedSet<T> tailSet(Object fromElement) {
        T fromElementT = (T) fromElement;
        int index = data.indexOf(fromElement);
        ArrayList<T> tailData = new ArrayList<>(data.subList(index, data.size() + 1));
        TreeSet<T> treeSet = new TreeSet<>(tailData);
        SortedSet<T> sortedSet = treeSet;
        return sortedSet;
    }

    /**
     * returns the first (lowest) element currently in this set
     * @return the first (lowest) element currently in this set
     */
    public T first() {
        T element = data.get(0);
        return element;
    }

    /**
     * returns the last (highest) element currently in this set
     * @return the last (highest) element currently in this set
     */
    public T last() {
        T element = data.get(data.size() - 1);
        return element;
    }

    /**
     * returns the number of elements in this set
     * @return the number of elements in this set
     */
    public int size() {
        return data.size();
    }

    /**
     * returns a string representation of this set
     * @return a string representation of this set
     */
    public String toString() {
        return "NavigableSet{" +
                "data=" + data.toString() +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(5);
        Collection collection = arrayList;
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        NavigableSet navigableSet = new NavigableSet(collection, comp);
        System.out.println(navigableSet.toString());
        navigableSet.add(3);
        System.out.println(navigableSet.toString());
        Iterator<Integer> iterator = navigableSet.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(navigableSet.ceiling(2));
        System.out.println(navigableSet.ceiling(7));
        System.out.println(navigableSet.floor(4));
        System.out.println(navigableSet.higher(5));
        System.out.println(navigableSet.lower(1));
        NavigableSet<Integer> headSet = navigableSet.headSet(5, true);
        System.out.println(headSet.toString());
        NavigableSet<Integer> tailSet = navigableSet.tailSet(5,true);
        System.out.println(tailSet.toString());
        NavigableSet<Integer> subSet = navigableSet.subSet(3,true,5,true);
        System.out.println(subSet.toString());
        NavigableSet<Integer> newNavSet = navigableSet.descendingSet();
        System.out.println(newNavSet.toString());
        System.out.println(navigableSet.pollFirst());
        System.out.println(navigableSet.pollLast());
        System.out.println(navigableSet.toString());


        NavigableSet<String> navigableSet2 = new NavigableSet<>();
        navigableSet2.add("b");
        navigableSet2.add("a");
        System.out.println(navigableSet2.toString());
        Iterator<String> iterator1 = navigableSet2.descendingIterator();
        System.out.println(iterator1.hasNext());
        System.out.println(iterator1.next());
    }
}
