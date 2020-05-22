package Task7;

public class Student {
    private String name;
    private Integer points;

    public Student(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
