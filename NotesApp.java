import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Simple Notes App ---");
            System.out.println("1. Write New Note (Overwrite)");
            System.out.println("2. Add to Existing Notes (Append)");
            System.out.println("3. View All Notes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> writeToFile(scanner, false);
                case 2 -> writeToFile(scanner, true);
                case 3 -> readFromFile();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void writeToFile(Scanner scanner, boolean append) {
        System.out.print("Enter your note: ");
        String text = scanner.nextLine();
        // try-with-resources ensures the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, append))) {
            writer.write(text);
            writer.newLine(); // Adds a line break after the note
            System.out.println("Note saved!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        System.out.println("\n--- Your Saved Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasContent = false;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                hasContent = true;
            }
            if (!hasContent) System.out.println("The notes file is empty.");
        } catch (FileNotFoundException e) {
            System.out.println("No notes file found. Start by writing a note!");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
