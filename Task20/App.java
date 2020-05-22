package Task20;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.init();
        app.start();
    }

    public Scanner inputScanner;
    public DataDownloader dataDownloader;

    public void init() {
        inputScanner = new Scanner(System.in);
    }

    public void start() throws InterruptedException {
        while (true) {
            System.out.println("Input command: ");
            String command = inputScanner.nextLine().trim();
            switch (command) {
                case "start":
                    startDownloading();
                    break;
                case "progress":
                    showProgress();
                    break;
                case "stop":
                    stopDownloading();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    runHelp();
                    break;
                default:
                    System.out.println("Unknown command");
                    runHelp();
                    break;
            }
        }
    }

    public void startDownloading() {
        try {
            System.out.println("Write the URI:");
            URI uri = new URI(inputScanner.nextLine().trim());
            System.out.println("Write the path to save:" );
            Path path = Paths.get(inputScanner.nextLine()).toAbsolutePath().normalize();
            dataDownloader = new DataDownloader(uri,path);
            dataDownloader.start();
            System.out.println("Downloading has started");
            Thread.sleep(200);
        } catch (URISyntaxException | InterruptedException e) {
            e.getMessage();
        }
    }

    public void stopDownloading() throws InterruptedException {
        if (dataDownloader == null || !dataDownloader.isDownloading()) {
            System.out.println("Downloading has not started");
        } else {
            dataDownloader.stopDownloading();
            System.out.println("Downloading stopped");
        }
        Thread.sleep(200);
    }

    public void showProgress() throws InterruptedException {
        if (dataDownloader == null || !dataDownloader.isDownloading()) {
            System.out.println("Downloading has not started");
        } else {
            System.out.printf("%.1f", dataDownloader.showProgress());
            System.out.println("%");
            Thread.sleep(200);
        }
    }

    public void runHelp() throws InterruptedException {
        System.out.println("Commands that can be ran: start, stop, progress, exit, help");
        Thread.sleep(200);
    }

}
