package Task10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class StudentDecoratorDataOutputStream extends OutputStream{
    private DataOutputStream dataOutputStream;

    public StudentDecoratorDataOutputStream(OutputStream outputStream) {
        dataOutputStream = new DataOutputStream(outputStream);
    }

    public void writeStudent(Student student) throws IOException {
        try {
            dataOutputStream.writeUTF(student.getName());
            dataOutputStream.writeUTF(student.getBirthDate());
            dataOutputStream.writeInt(student.getGroup());
        } catch (IOException e) {
            throw new IOException("Cannot write student");
        }
    }


    @Override
    public void write(int b) throws IOException {
        dataOutputStream.write(b);
    }

    public void writeInt(int v) throws IOException {
        dataOutputStream.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        dataOutputStream.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        dataOutputStream.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        dataOutputStream.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        dataOutputStream.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        dataOutputStream.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        dataOutputStream.writeUTF(str);
    }

    public void writeBoolean(boolean v) throws IOException {
        dataOutputStream.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        dataOutputStream.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        dataOutputStream.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        dataOutputStream.writeChar(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDecoratorDataOutputStream that = (StudentDecoratorDataOutputStream) o;
        return Objects.equals(dataOutputStream, that.dataOutputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataOutputStream);
    }

    @Override
    public String toString() {
        return "StudentDecoratorDataOutputStream{" +
                "dataOutputStream=" + dataOutputStream +
                '}';
    }
}
