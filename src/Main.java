import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner(new FileReader("sample.in"));
        String[] line = fileScanner.nextLine().split("[,\\(\\)]");
        float[] temp = new float[3];
        //First line contains source point
        int i=0;
        for(String s: line)
            if (!s.isEmpty())
                temp[i++] = Float.parseFloat(s);
        Point sourcePoint = new Point(temp[0],temp[1]);
        //Read the transformation lines
        while(fileScanner.hasNextLine()) {
            line = fileScanner.nextLine().split("[,\\(\\)]");
            if(line[0].equals("rotate")){
                sourcePoint.rotate(Float.parseFloat(line[1]),Float.parseFloat(line[2]),Float.parseFloat(line[3]));}
            if(line[0].equals("scale")){
                sourcePoint.scale(Float.parseFloat(line[1]),Float.parseFloat(line[2]),Float.parseFloat(line[3]));}
            if(line[0].equals("reflect")){
                sourcePoint.reflect(line[1]);}
            if(line[0].equals("translate")){
                sourcePoint.translate(Float.parseFloat(line[1]),Float.parseFloat(line[2]));}
        }
        System.out.println("("+String.format("%.2f", sourcePoint.getX())+", "+String.format("%.2f", sourcePoint.getY())+")");
    }



}
