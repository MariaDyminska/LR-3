package service;

import java.io.*;

public class BattleLog {
    public static void save(String text, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(text);
            System.out.println(" Збережено у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка при записі файлу.");
        }
    }

    public static void read(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Відтворення бою:");
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу.");
        }
    }
}
