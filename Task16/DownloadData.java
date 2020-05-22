package Task16;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class DownloadData {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            URI uri = new URI(sc.nextLine().trim());
            String uriString = uri.toString();
            String extension = uriString.substring(uriString.lastIndexOf("."));
            File file = new File("C:\\Users\\pc\\Desktop\\new" + extension);
            HttpURLConnection http = (HttpURLConnection)uri.toURL().openConnection();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = in.read(buffer, 0, 1024)) >= 0) {
                bout.write(buffer, 0, read);
            }
            bout.close();
            in.close();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

    }
}
