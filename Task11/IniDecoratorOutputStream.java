package Task11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class IniDecoratorOutputStream extends OutputStream{
    private BufferedWriter bufferedWriter;

    public IniDecoratorOutputStream(OutputStream outputStream) {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void writeIniLine(Map.Entry<String,String> entry) throws IOException {
        bufferedWriter.write(entry.getKey());
        bufferedWriter.write('=');
        bufferedWriter.write(entry.getValue());
        bufferedWriter.write("\n");
    }

    public void writeIni(Map<String,String> map) throws IOException {
        for (Map.Entry<String,String> entry: map.entrySet()) {
            writeIniLine(entry);
        }
    }

    @Override
    public void write(int b) throws IOException {
        bufferedWriter.write(b);
    }

    public IniDecoratorOutputStream() {
        super();
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
