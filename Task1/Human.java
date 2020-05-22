package Task1;

public class Human implements Comparable <Human> {
    private Integer age;

    @Override
    public int compareTo(Human o) {
        if (age == o.age) {
            return 0;
        } else if (age > o.age) {
            return 1;
        } else {
            return -1;
        }
    }
}
