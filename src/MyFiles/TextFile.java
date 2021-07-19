package MyFiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFile extends File {

    public TextFile(Path path) {
        super(path);
    }

    @Override
    public void open() {
        try {
            List<String> list = Files.readAllLines(path, Charset.forName("windows-1251"));
            for (String str : list) {
                System.out.println(str);
            }
        }
        catch (MalformedInputException e){
            System.out.println("Unable to read file " + path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
