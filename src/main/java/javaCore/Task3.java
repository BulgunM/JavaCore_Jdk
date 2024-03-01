package javaCore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task3 {

    public static void main(String[] args) {
        String prefix = "new_";
        String[] filenames = {"file1.txt", "file2.txt"};

        addPrefix(prefix, filenames);
    }

    public static void addPrefix(String prefix, String... filenames) {

        for(String filename : filenames) {

            Path path = Paths.get(filename);
            if (Files.exists(path)) {

                String newName = prefix + filename;
                Path newPath = Paths.get(newName);

                try {
                    Files.move(path, newPath);
                } catch (Exception e) {
                    System.out.println("Не удалось переименовать файл: " + e.getMessage());
                }

            } else {
                System.out.println("Файл не найден: " + filename);
            }
        }

        System.out.println("Префикс добавлен к:");
        for(String filename : filenames) {
            System.out.println(filename);
        }
    }
}
