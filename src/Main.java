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
        System.out.println("The original value is ("+sourcePoint.getX()+","+sourcePoint.getY()+")");
        //Read the transformation lines
        while(fileScanner.hasNextLine()) {
            line = fileScanner.nextLine().split("[,\\(\\)]");
            if(line[0].equals("rotate")){
                System.out.println("Rotate command called");
                System.out.println(line[1]+","+line[2]+","+line[3]);
                sourcePoint.rotate(Float.parseFloat(line[1]),Float.parseFloat(line[2]),Float.parseFloat(line[3]));}
            if(line[0].equals("scale")){
                System.out.println("Scale command called");
                System.out.println(line[1]+","+line[2]+","+line[3]);
                sourcePoint.scale(Float.parseFloat(line[1]),Float.parseFloat(line[2]),Float.parseFloat(line[3]));}
            if(line[0].equals("reflect")){
                System.out.println("Reflect command called");
                System.out.println(line[1]);
                sourcePoint.reflect(line[1]);}
            if(line[0].equals("translate")){
                System.out.println("Translate command called");
                System.out.println(line[1]+","+line[2]);
                sourcePoint.translate(Float.parseFloat(line[1]),Float.parseFloat(line[2]));}
            System.out.println("New point location: ("+sourcePoint.getX()+","+sourcePoint.getY()+")");
        }
        System.out.println("The new value should be (7,6). Value: ("+sourcePoint.getX()+","+sourcePoint.getY()+")");

    }



}
