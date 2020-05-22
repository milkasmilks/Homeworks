package Task1;

public class Student implements Comparable<Student> {
    private String name;
    private Integer points;

    public int compareTo(Student st) {
        if (points == st.points) {
            return 0;
        } else if (points > st.points) {
            return 1;
        } else {
            return -1;
        }
    }
}
