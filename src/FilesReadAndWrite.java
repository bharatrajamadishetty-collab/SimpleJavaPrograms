import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesReadAndWrite {
    public static void main(String[] args) throws IOException{
        Path path = Path.of("data.txt");
        Files.writeString(path, "Glad to read and write data to files using Java 11 Files API Enhancements");
        String data = Files.readString(path);
        System.out.println(data);
        boolean b = Files.isExecutable(path);
        System.out.println(b);
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isSymbolicLink(path));
    }
}
