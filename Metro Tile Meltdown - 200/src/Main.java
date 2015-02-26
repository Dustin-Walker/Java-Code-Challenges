import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int width = Integer.valueOf(line.split("\\s")[0]);
        int height = Integer.valueOf(line.split("\\s")[1]);
        System.out.println("Width: "+width+"\nHeight: "+height);
        ScreenMap screenMap = new ScreenMap(height, width);
        Path  file = FileSystems.getDefault().getPath("src", "data.txt");
        screenMap.readFile(file);
        screenMap.printTileList();
    }
}
