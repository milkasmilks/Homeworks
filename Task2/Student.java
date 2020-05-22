package Task2;

public class Student {
    private String name;
    private int weight;
    private int points;

    public Student(String name, int weight, int points) {
        this.name = name;
        this.weight = weight;
        this.points = points;
    }

    public int getWeight() { return weight; }
    public int getPoints() { return points; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", points=" + points +
                '}';
    }
}
