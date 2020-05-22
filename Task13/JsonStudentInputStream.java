package Task13;

import Task9.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class JsonStudentInputStream extends InputStream {
    private BufferedReader bufferedReader;
    private JSONParser parser;

    public JsonStudentInputStream(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        parser = new JSONParser();
    }

    public Student readStudent() throws IOException {
        try {
            JSONObject jsonStudent = (JSONObject) parser.parse(bufferedReader);
            return new Student((String) jsonStudent.get("name"), (String) jsonStudent.get("birthDate"), (int) jsonStudent.get("group"));
        } catch (IOException | ParseException e) {
            throw new IOException("Cannot read student");
        }
    }

    public Collection<Student> readStudents() throws IOException {
        Collection<Student> collection = new ArrayList<>();

        try {
            JSONArray students = (JSONArray) parser.parse(bufferedReader);
            for (Object object: students) {
                JSONObject jsonStudent = (JSONObject) object;
                Student student = new Student((String) jsonStudent.get("name"), (String) jsonStudent.get("birthDate"), (int) jsonStudent.get("group"));
                collection.add(student);
            }
        } catch (IOException | ParseException e) {
            throw new IOException("Cannot read student");
        }
        return collection;
    }

    @Override
    public int read() throws IOException {
        return bufferedReader.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        super.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        super.reset();
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();
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
