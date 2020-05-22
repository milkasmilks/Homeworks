package Task10;

import java.io.*;
import java.util.Objects;

public class StudentDecoratorObjectInputStream extends InputStream{
    private ObjectInputStream objectInputStream;

    public StudentDecoratorObjectInputStream(InputStream inputStream) throws IOException {
        objectInputStream = new ObjectInputStream(inputStream);
    }

    public Student readStudent() throws IOException, ClassNotFoundException {
        try {
            return (Student) objectInputStream.readObject();
        } catch (IOException e) {
            throw new IOException("Cannot read student");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Cannot find class");
        }
    }

    @Override
    public int read() throws IOException {
        return objectInputStream.read();
    }

    public boolean readBoolean() throws IOException {
        return objectInputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return objectInputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return objectInputStream.readUnsignedByte();
    }

    public char readChar() throws IOException {
        return objectInputStream.readChar();
    }

    public short readShort() throws IOException {
        return objectInputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return objectInputStream.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return objectInputStream.readInt();
    }

    public long readLong() throws IOException {
        return objectInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return objectInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return objectInputStream.readDouble();
    }

    public void readFully(byte[] buf) throws IOException {
        objectInputStream.readFully(buf);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        objectInputStream.readFully(buf, off, len);
    }

    public int skipBytes(int len) throws IOException {
        return objectInputStream.skipBytes(len);
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return objectInputStream.readUnshared();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }

    public ObjectInputStream.GetField readFields() throws IOException, ClassNotFoundException {
        return objectInputStream.readFields();
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        objectInputStream.registerValidation(obj, prio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDecoratorObjectInputStream that = (StudentDecoratorObjectInputStream) o;
        return Objects.equals(objectInputStream, that.objectInputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectInputStream);
    }

    @Override
    public String toString() {
        return "StudentDecoratorObjectInputStream{" +
                "objectInputStream=" + objectInputStream +
                '}';
    }
}
