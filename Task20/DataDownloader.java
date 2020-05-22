package Task20;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;

public class DataDownloader extends Thread {
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean isDownloading;
    private Double size;
    private Path path;

    public DataDownloader(URI uri, Path path) {
        try {
            inputStream = uri.toURL().openConnection().getInputStream();
            size = (double)uri.toURL().openConnection().getContentLength();
            isDownloading = false;
            outputStream = new FileOutputStream(new File(path.toString()));
            this.path = path;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            System.out.println("Starting downloading");
            isDownloading = true;
            int read = 1;
            while ((read = inputStream.read()) != -1) {
                outputStream.write(read);
            }
            System.out.println("Downloading completed");
            isDownloading = false;
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double showProgress() {
        Double result;
        if (size != 0) {
            File file = new File(path.toString());
            result = (file.length() * 100) / size;
        } else {
            result = 0.0;
        }
        return result;
    }

    public boolean isDownloading() {
        return isDownloading;
    }

    public void stopDownloading() {
        isDownloading = false;
    }
}

