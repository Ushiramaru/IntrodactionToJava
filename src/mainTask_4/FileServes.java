package mainTask_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServes {

    public static String readFrom(Path path) throws IOException {
        return Files.readString(path);
    }

    public static void writeTo(Path path, String json) throws IOException {
        Files.writeString(path, json);
    }

}