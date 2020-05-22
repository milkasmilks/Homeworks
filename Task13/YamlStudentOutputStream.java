package Task13;

import org.ho.yaml.Yaml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public class YamlStudentOutputStream extends OutputStream{
    private OutputStream outputStream;

    public YamlStudentOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeStudent(Student student) throws IOException {
        Yaml.dump(student, outputStream);
    }

    public void writeStudents(Collection<Student> collection) throws IOException {
        Yaml.dump(collection, outputStream);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
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
