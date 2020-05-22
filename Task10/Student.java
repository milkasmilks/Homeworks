package Task10;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String  name;
    private String  birthDate;
    private int     group;

    public Student(String name, String birthDate, int group) {
        this.name = name;
        this.birthDate = birthDate;
        this.group = group;
    }

    public String getName() {
        return name;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public int getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return
                group == student.group &&
                name.equals(student.name) &&
                birthDate.equals(student.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", group=" + group +
                '}';
    }
}
