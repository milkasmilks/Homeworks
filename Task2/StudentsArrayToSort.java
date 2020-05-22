package Task2;

public class StudentsArrayToSort {
    public static void sortByPoints(Student[] array) {
        PointsStudentComparator psc = new PointsStudentComparator();
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (psc.compare(array[j], array[j - 1]) == -1) {
                    Student temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Student s1 = new Student("s1",180, 10);
        Student s2 = new Student("s1", 175, 20);
        Student s3 = new Student("s3", 160, 15);
        Student[] array = new Student[] {s1, s2, s3};
        sortByPoints(array);
    }
}
