package Task7;

import java.util.Arrays;
import java.util.List;

public class LambdaComparator {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Anna", 50),
                new Student("Emma", 25),
                new Student("Vera", 30));

        students.sort((s1, s2) -> s1.getPoints() - s2.getPoints());

        for (Student student: students) {
            System.out.println(student.toString());
        }
    }
}
