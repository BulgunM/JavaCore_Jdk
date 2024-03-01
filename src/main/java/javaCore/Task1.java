package javaCore;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
// во вновь созданную папку ./backup
public class Task1 {
    public static void main(String[] args) {
        try {
            createBackup("C:/Users/user/Desktop/документы/Память");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void createBackup(String sourceDir) throws Exception {

        File backupDir = new File(sourceDir + "/backup");
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = new File(sourceDir).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                File backupFile = new File(backupDir.getPath() + "/" + file.getName());
                Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        System.out.println("Резервная копия файлов создана в " + backupDir.getAbsolutePath());
    }
}
