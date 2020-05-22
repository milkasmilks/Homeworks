package Task2;

public class WeightStudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getWeight() == s2.getWeight()) {
            return 0;
        } else if (s1.getWeight() > s2.getWeight()) {
            return 1;
        } else {
            return -1;
        }
    }

}
