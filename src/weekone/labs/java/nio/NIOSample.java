package weekone.labs.java.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOSample {
  public static void main(String[] args) {
    // File to read from
    File file = new File("src/weekone/labs/java/nio/data.txt");

    try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
      // Allocate a byte buffer
      ByteBuffer buffer = ByteBuffer.allocate(1024);

      int bytesRead;
      do {
        // Attempt to read data into the buffer (might not read all requested bytes)
        bytesRead = channel.read(buffer);

        // Process the read data (e.g., print or write to another file)
        if (bytesRead > 0) {
          buffer.flip();
          // Create or open the file to write
          try {
              try (FileChannel writeChannel = FileChannel.open(
                      Paths.get("write_to_file.txt"),
                      StandardOpenOption.CREATE,
                      StandardOpenOption.WRITE,
                      StandardOpenOption.APPEND)) {
                  writeChannel.write(buffer);

              }
          } catch (IOException e) {
            System.err.println("An I/O error occurred while writing: " + e.getMessage());
          }
          buffer.clear();
        }
      } while (bytesRead > 0); // Continue reading until EOF
    } catch (NoSuchFileException e) {
      System.err.println("The specified file was not found: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("An I/O error occurred: " + e.getMessage());
    }
  }
}
