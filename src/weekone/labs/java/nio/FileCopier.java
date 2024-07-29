package weekone.labs.java.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/** Copies the contents of the source file to the destination file. */
public class FileCopier {

  public static void copyFile(Path sourcePath, Path destinationPath) throws IOException {

    if (!Files.exists(sourcePath)) {
      throw new IOException("Source file does not exist: " + sourcePath);
    }

    // Copy the source file to the destination file
    try {
      Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("File copied successfully from " + sourcePath + " to " + destinationPath);
    } catch (IOException e) {

      System.err.println("Error copying file: " + e.getMessage());
      throw e;
    }
  }

  public static void main(String[] args) {

    Path sourcePath = Path.of("src/weekone/labs/java/nio/data.txt");
    Path destinationPath = Path.of("src/weekone/labs/java/nio/writeto.txt");

    try {
      copyFile(sourcePath, destinationPath);
    } catch (IOException e) {
      System.err.println("Failed to copy file: " + e.getMessage());
      System.exit(1);
    }
  }
}
