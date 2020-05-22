package Task9;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class ByteBufferReaderWriter {
    public static void main(String[] args) {
        Student student1 = new Student("Igor", "01.01.2001", 901);
        Student student2 = new Student("Lena", "02.02.2002", 902);
        Collection<Student> collection = new ArrayList<>();
        collection.add(student1);
        collection.add(student2);
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        write(collection, "C:\\Users\\pc\\Desktop\\students.txt");
        Collection<Student> newCollection = read("C:\\Users\\pc\\Desktop\\students.txt");
        System.out.println(newCollection.size());
        for (Student student : newCollection) {
            System.out.println(student.toString());
        }
    }

    public static Collection<Student> read(String path) {
        try {
            Collection<Student> collection = new ArrayList<>();
            FileInputStream fis = new FileInputStream(path);
            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
            for (int i = 0; i < 4; i++) {
                buffer.put((byte) fis.read());
            }
            buffer.rewind();
            int collectionSize = buffer.getInt();
            buffer.clear();
            for (int i = 0; i < collectionSize; i++) {
                for (int j = 0; j < 4; j++) {
                    buffer.put((byte) fis.read());
                }
                buffer.rewind();
                int nameSize = buffer.getInt();
                buffer.clear();
                StringBuilder nameBuilder = new StringBuilder();
                for (int j = 0; j < nameSize; j++) {
                    buffer.put((byte) fis.read());
                    buffer.put((byte) fis.read());
                    buffer.rewind();
                    nameBuilder.append(buffer.getChar());
                    buffer.clear();
                }
                String studentName = nameBuilder.toString();

                for (int j = 0; j < 4; j++) {
                    buffer.put((byte) fis.read());
                }
                buffer.rewind();
                int dateSize = buffer.getInt();
                buffer.clear();
                StringBuilder dateBuilder = new StringBuilder();
                for (int j = 0; j < dateSize; j++) {
                    buffer.put((byte) fis.read());
                    buffer.put((byte) fis.read());
                    buffer.rewind();
                    dateBuilder.append(buffer.getChar());
                    buffer.clear();
                }
                String studentDate = dateBuilder.toString();
                for (int j = 0; j < 4; j++) {
                    buffer.put((byte) fis.read());
                }
                buffer.rewind();
                int group = buffer.getInt();
                buffer.clear();
                Student student = new Student(studentName, studentDate, group);
                collection.add(student);
            }
            return collection;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(Collection<Student> collection, String path) {
        try (OutputStream outputStream = new FileOutputStream(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
            buffer.putInt(collection.size());
            outputStream.write(buffer.array());
            outputStream.flush();
            for (Student student : collection) {
                ByteBuffer studentBuffer = ByteBuffer.allocate(Character.BYTES * student.getName().length() + Character.BYTES * student.getBirthDate().length() + 3 * Integer.BYTES);
                studentBuffer.putInt(student.getName().length());
                for (int i = 0; i < student.getName().length(); i++) {
                    studentBuffer.putChar(student.getName().charAt(i));
                }
                studentBuffer.putInt(student.getBirthDate().length());
                for (int i = 0; i < student.getBirthDate().length(); i++) {
                    studentBuffer.putChar(student.getBirthDate().charAt(i));
                }
                studentBuffer.putInt(student.getGroup());
                outputStream.write(studentBuffer.array());
                outputStream.flush();
                studentBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
