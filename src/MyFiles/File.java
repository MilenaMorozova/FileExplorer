package MyFiles;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class File implements Openable {
    Path path;

    public File(Path path){
        if (!Files.exists(path)){
            throw new IllegalArgumentException("No such file");
        }
        this.path = path;
    }

    public Path getName(){
        Path fileName = path.getFileName();
        if (fileName == null){
            return path;
        }
        return fileName;
    }

    public File getParent(){
        Path parentPath = path.getParent();
        if (parentPath == null){
            return this;
        }
        return new Directory(parentPath);
    }
}

