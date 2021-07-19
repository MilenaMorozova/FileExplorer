package MyFiles;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileFactory {
    public static File create(Path path){
        if (Files.isDirectory(path)){
            return new Directory(path);
        }
        return new TextFile(path);
    }
}