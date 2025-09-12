import java.io.*;

public class FileIODemo {
    public static void main(String[] args) {
        String filename = "sample.txt";
        String content = "Hello, file I/O!";

        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            System.out.println("Read from file: " + line);
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}

