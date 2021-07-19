package MyFiles;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Directory extends File {
    private ArrayList<Path> content;
    public Directory(Path path) {
        super(path);
        updateContent();
    }

    private void updateContent() {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            content = new ArrayList<Path>();
            for (Path file : files) {
                content.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void open() {
        if (content.size() == 0) {
            System.out.println("No content");
        }

        int i = 0;
        for(Path file : content){
            String name = i++ + " ) " + file.getFileName();
            System.out.println(Files.isDirectory(file) ? name + '/' : name);
        }
    }

    public File move(int index){
        if (index < 0 || index >= content.size()){
            System.out.println("No such file or directory");
            return this;
        }

        Path fileItem;
        fileItem = content.get(index);

        return FileFactory.create(fileItem);
        //return Files.isDirectory(fileItem) ? new Directory(fileItem) : new TextFile(fileItem);
    }
}
