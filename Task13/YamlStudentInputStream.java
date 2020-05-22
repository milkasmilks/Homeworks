package Task13;

import org.ho.yaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class YamlStudentInputStream extends InputStream{
    private InputStream inputStream;

    public YamlStudentInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Student readStudent() throws IOException {
        try {
            return (Student) Yaml.load(inputStream);
        } catch (ClassCastException e) {
            throw new IOException("Cannot read student");
        }
    }

    public Collection<Student> readStudents() throws IOException {
        try {
            return (Collection<Student>) Yaml.load(inputStream);
        } catch (ClassCastException e) {
            throw new IOException("Cannot read students");
        }
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
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
