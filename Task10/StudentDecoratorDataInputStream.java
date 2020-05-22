package Task10;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class StudentDecoratorDataInputStream extends InputStream {
    private DataInputStream dataInputStream;

    public StudentDecoratorDataInputStream(InputStream inputStream) {
        this.dataInputStream = new DataInputStream(inputStream);
    }

    public Student readStudent() throws IOException{
        try {
            String name = dataInputStream.readUTF();
            String birthDate = dataInputStream.readUTF();
            int group = dataInputStream.readInt();
            Student student = new Student(name, birthDate, group);
            return student;
        } catch (IOException e) {
            throw new IOException("Cannot read student");
        }
    }


    @Override
    public int read() throws IOException {
        return dataInputStream.read();
    }

    public static String readUTF(DataInput dataInput) throws IOException {
        return DataInputStream.readUTF(dataInput);
    }

    public String readUTF() throws IOException {
        return dataInputStream.readUTF();
    }

    public int readInt() throws IOException {
        return dataInputStream.readInt();
    }

    public String readLine() throws IOException {
        return dataInputStream.readLine();
    }

    public long readLong() throws IOException {
        return dataInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return dataInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return dataInputStream.readDouble();
    }

    public void readFully(byte[] b) throws IOException {
        dataInputStream.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        dataInputStream.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return dataInputStream.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return dataInputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return dataInputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return dataInputStream.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return dataInputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return dataInputStream.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return dataInputStream.readChar();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDecoratorDataInputStream that = (StudentDecoratorDataInputStream) o;
        return Objects.equals(dataInputStream, that.dataInputStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataInputStream);
    }

    @Override
    public String toString() {
        return "StudentDecoratorDataInputStream{" +
                "dataInputStream=" + dataInputStream +
                '}';
    }
}
