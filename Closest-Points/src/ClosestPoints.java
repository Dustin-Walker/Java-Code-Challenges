import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClosestPoints {

    // Page 1039 in Introduction to Algorithms by Cormen, et al has an optimized solution
    // This is a naive solution which runs in O(n^2)
    private double lowestDistance = Integer.MAX_VALUE;
    private String[] closestPoints = new String[2];

    public static void main(String[] args) throws IOException, NoSuchFileException {

        ClosestPoints closestPoints = new ClosestPoints();
        String closestPointsFromFile = closestPoints.printClosestPointsFromFile("sample.data");
        System.out.println(closestPointsFromFile);
        System.out.println(closestPoints.lowestDistance + " is the distance between the closest points.");
    }

    public String printClosestPointsFromFile(String fileName) throws IOException, NoSuchFileException {
        return pointPrinter(findClosestPoints(readInputData(fileName)));
    }

    public String pointPrinter(String[] points){
        return points[0] + " and " + points[1] + " form the closest pair of points.";
    }

    public List<String> readInputData(String fileName) throws IOException, NoSuchFileException{
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

    public String[] findClosestPoints(List<String> list){
        int length = list.size();
        for (int i = 1; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                double x1 = Double.valueOf(list.get(i).split(",")[0].substring(1));
                double y1 = Double.valueOf(removeLastChar(list.get(i).split(",")[1]));

                double x2 = Double.valueOf(list.get(j).split(",")[0].substring(1));
                double y2 = Double.valueOf(removeLastChar(list.get(j).split(",")[1]));

                double deltaX = x1-x2;
                double deltaY = y1-y2;

                double distanceBetweenPoints = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

                if (distanceBetweenPoints < lowestDistance){
                    lowestDistance = distanceBetweenPoints;
                    closestPoints[0] = list.get(i);
                    closestPoints[1] = list.get(j);
                }
            }
        }
        return closestPoints;
    }

    private String removeLastChar(String s){
        if (s.length() > 0 && s.charAt(s.length()-1)==')') {
            s = s.substring(0, s.length()-1);
        }
        return s;
    }


}