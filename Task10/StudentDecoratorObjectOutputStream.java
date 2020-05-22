package Task10;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Objects;

public class StudentDecoratorObjectOutputStream extends OutputStream {
    private ObjectOutputStream objectOutputStream;

    public StudentDecoratorObjectOutputStream(OutputStream outputStream) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
    }

    public void writeStudent(Student student) throws IOException {
        try {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            throw new IOException("Cannot write student");
        }
    }


    @Override
    public void write(int b) throws IOException {
        objectOutputStream.write(b);
    }

    public void writeBoolean(boolean val) throws IOException {
        objectOutputStream.writeBoolean(val);
    }

    public void writeByte(int val) throws IOException {
        objectOutputStream.writeByte(val);
    }

    public void writeShort(int val) throws IOException {
        objectOutputStream.writeShort(val);
    }

    public void writeChar(int val) throws IOException {
        objectOutputStream.writeChar(val);
    }

    public void writeInt(int val) throws IOException {
        objectOutputStream.writeInt(val);
    }

    public void writeLong(long val) throws IOException {
        objectOutputStream.writeLong(val);
    }

    public void writeFloat(float val) throws IOException {
        objectOutputStream.writeFloat(val);
    }

    public void writeDouble(double val) throws IOException {
        objectOutputStream.writeDouble(val);
    }

    public void writeBytes(String str) throws IOException {
        objectOutputStream.writeBytes(str);
    }

    public void writeChars(String str) throws IOException {
        objectOutputStream.writeChars(str);
    }

    public void writeUTF(String str) throws IOException {
        objectOutputStream.writeUTF(str);
    }

    public void useProtocolVersion(int version) throws IOException {
        objectOutputStream.useProtocolVersion(version);
    }

    public void writeObject(Object obj) throws IOException {
        objectOutputStream.writeObject(obj);
    }

    public void writeUnshared(Object obj) throws IOException {
        objectOutputStream.writeUnshared(obj);
    }

    public void defaultWriteObject() throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public ObjectOutputStream.PutField putFields() throws IOException {
        return objectOutputStream.putFields();
    }

    public void writeFields() throws IOException {
        objectOutputStream.writeFields();
    }

    public void reset() throws IOException {
        objectOutputStream.reset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDecoratorObjectOutputStream that = (StudentDecoratorObjectOutputStream) o;
        return Objects.equals(objectOutputStream, that.objectOutputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectOutputStream);
    }

    @Override
    public String toString() {
        return "StudentDecoratorObjectOutputStream{" +
                "objectOutputStream=" + objectOutputStream +
                '}';
    }
}
