package Task15;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class CommandLine {
    public static void main(String[] args)  {
        start();
    }

    private static Path currentPath = Paths.get(".").normalize().toAbsolutePath();

    private static void start() {
        try {
            System.out.print(currentPath + ">: ");
            while (true) {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                String command = input.trim().split("\\s")[0];
                String parameter = null;
                if (input.trim().split("\\s").length > 1) {
                    parameter = input.trim().split("\\s")[1];
                }
                switch (command) {
                    case "cd":
                        changeDirectory(parameter);
                        break;
                    case "dir":
                        listDirectoryContent();
                        break;
                    case "cp":
                        copy(parameter);
                        break;
                    case "rm":
                        remove(parameter);
                        break;
                    case "open":
                        open(parameter);
                        break;
                    default:
                        System.out.println("Unknown command");
                        runHelp();
                        break;
                }
                System.out.print(currentPath + ">: ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void changeDirectory(String directory) {
        if (directory.length() != 0) {
            Path pathToChange = Paths.get(directory).normalize();
            if (pathToChange.toString().charAt(0) == '\\') {
                pathToChange = pathToChange.toAbsolutePath().normalize();
            } else {
                pathToChange = Paths.get(currentPath.toString(), pathToChange.toString()).toAbsolutePath().normalize();
            }

            if (Files.exists(pathToChange)) {
                currentPath = pathToChange;
            } else {
                System.out.println("Cannot find directory");
            }
        }
    }

    private static void listDirectoryContent() {
        try {
            System.out.println("Directory: " + currentPath.toString());
            System.out.println();
            File[] files = new File(currentPath.toString()).listFiles();
            for (File file: files) {
                FileTime time = Files.getLastModifiedTime(Paths.get(file.getPath()));
                System.out.print(time.toString().substring(0, 10) + " ");
                System.out.print(time.toString().substring(11, 16) + "       ");
                if (file.isDirectory()) {
                    System.out.print("<DIR>         ");
                } else {
                    System.out.print("<FILE>        ");
                }
                System.out.print(file.getName());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copy(String path) {
        try {
            String[] paths = path.split("\\s");
            File inputFile;
            if (paths[0].charAt(0) == '\\') {
                inputFile = new File(paths[0]);
            } else {
                inputFile = new File(currentPath.toString() + '\\' + paths[0]);
            }
            File outputFile;
            if (paths[0].charAt(0) == '\\') {
                outputFile = new File(paths[0]);
            } else {
                outputFile = new File(currentPath.toString() + '\\' + paths[0]);
            }
            if (Files.exists(inputFile.toPath())) {
                if (outputFile.isDirectory()) {
                    Files.copy(inputFile.toPath(), new File (outputFile.getPath() + '\\' + inputFile.getName()).toPath());
                } else {
                    Files.copy(inputFile.toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            } else {
                System.out.println("Cannot find this file");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void remove(String path) {
        if (path.length() != 0) {
            File fileToDelete;
            if (path.charAt(0) == '\\') {
                fileToDelete = new File(path);
            } else {
                fileToDelete = new File(currentPath.toString() + '\\' + path);
            }
            if (fileToDelete.delete()) {
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Cannot delete");
            }
        } else {
            System.out.println("Cannot find this file");
        }
    }

    private static boolean open (String path) {
        try {
            File fileToOpen;
            if (path.charAt(0) == '\\') {
                fileToOpen = new File(path);
            } else {
                fileToOpen = new File(currentPath.toString() + "\\" + path);
            }
            if (Files.exists(fileToOpen.toPath()) && !Files.isDirectory(fileToOpen.toPath())) {
                Desktop.getDesktop().open(fileToOpen);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static void runHelp() {
        System.out.println("Commands that can be ran: cd, dir, cp, rm, open");
    }
}
