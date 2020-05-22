package Task13;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;

public class JsonStudentOutputStream extends OutputStream{
    private BufferedWriter bufferedWriter;

    public JsonStudentOutputStream(OutputStream outputStream) {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void writeStudent(Student student) throws IOException {
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("name", student.getName());
        jsonStudent.put("birthDate", student.getBirthDate());
        jsonStudent.put("group", student.getGroup());
        bufferedWriter.write(jsonStudent.toJSONString());
    }

    public void writeStudents(Collection<Student> collection) throws IOException {
        JSONArray students = new JSONArray();
        for (Student student: collection) {
            JSONObject jsonStudent = new JSONObject();
            jsonStudent.put("name", student.getName());
            jsonStudent.put("birthDate", student.getBirthDate());
            jsonStudent.put("group", student.getGroup());
            students.add(jsonStudent);
        }
        bufferedWriter.write(students.toJSONString());
    }

    @Override
    public void write(int b) throws IOException {
        bufferedWriter.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        super.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
