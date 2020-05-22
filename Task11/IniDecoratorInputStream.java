package Task11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

public class IniDecoratorInputStream extends InputStream {
    private BufferedReader bufferedReader;

    public IniDecoratorInputStream(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public Map.Entry<String, String> readIniLine() throws IOException {
        try {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] stringLine = line.split("=", 2);
                AbstractMap.SimpleEntry<String, String> entry = new AbstractMap.SimpleEntry<>(stringLine[0], stringLine[1]);
                return entry;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IOException("Cannot read INI file");
        }
    }

    public Map<String, String> readIni() throws IOException {
        Map<String, String> map = new TreeMap<>();
        Map.Entry<String, String> entry;
        while ((entry = readIniLine()) != null) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
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
