import MyFiles.*;

import java.nio.file.Path;
import java.util.Scanner;

public class FileExplorer {
    private File currentItem;

    public FileExplorer(){
        Path path = Path.of("D://").normalize();
        currentItem = new Directory(path);
    }

    public void run(){
        mainloop: while (true) {
            System.out.println("Current item: " + currentItem.getName() + '\n');
            System.out.println("-2 ) Exit");
            System.out.println("-1 ) ..");
            currentItem.open();

            while (true) {
                System.out.println("Enter the number:");
                Scanner in = new Scanner(System.in);
                int number = in.nextInt();

                if (number == -2) {
                    break mainloop;
                }
                if (number == -1) {
                    currentItem = currentItem.getParent();
                    break;
                }
                if (currentItem instanceof Directory) {
                    currentItem = ((Directory) currentItem).move(number);
                    break;
                }
            }
        }
    }
}
