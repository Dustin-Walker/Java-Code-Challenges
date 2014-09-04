import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        Scanner fileScanner = new Scanner(new FileReader("sample2.in"));
        String[] line = fileScanner.nextLine().split("[\\D]");
        float[] temp = new float[30];
        //First line contains source point
        int i=0;
        for(String s: line)
            if (s.matches("[\\d]"))
                temp[i++] = Float.parseFloat(s);
        Point sourcePoint = new Point(temp[0],temp[1]);
        //Read the transformation lines
        while(fileScanner.hasNextLine()) {
            line = fileScanner.nextLine().split("[,\\(\\)]");
            if(line[0].equals("rotate"))
                sourcePoint.rotate(Float.parseFloat(line[1]),Float.parseFloat(line[2]),Float.parseFloat(line[3]));
        }
        System.out.println("The new value should be (7,6). Value: ("+sourcePoint.getX()+","+sourcePoint.getY()+")");

    }



}
