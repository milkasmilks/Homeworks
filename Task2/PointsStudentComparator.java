package Task2;

public class PointsStudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getPoints() == s2.getPoints()) {
            return 0;
        } else if (s1.getPoints() > s2.getPoints()) {
            return 1;
        } else {
            return -1;
        }
    }
}