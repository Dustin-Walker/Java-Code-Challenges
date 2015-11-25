import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

    /**
     * Brute force approach
     * Runs in O(n^2) time
     * @param list List of points
     * @return String array representing points
     */
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

    /**
     * Optimized solution to the closest points problem.
     * Uses a more object oriented approach.
     * Runs in O(n log n) time.
     * Based on the algorithm described in Introduction to Algorithms
     *  3rd Edition by Cormen, et al on page 1039.
     * This is a divide and conquer based approach.
     * @param P Subset of all points
     * @param X Set P ordered by X coordinate
     * @param Y Set P ordered by Y coordinate
     * @return Closest two points
     */
    public Point[] getClosestPoints(Set<Point> P, List<Point> X, List<Point> Y){
        // Brute force case
        if (P.size() <= 3){
            // brute force solution
        }
        // Divide step involves dividing and sorting points into groups
        int sumX = 0, sumY = 0;
        Set<Point> PL = new HashSet<>();
        Set<Point> PR = new HashSet<>();
        for (Point point : P){
            sumX += point.getX();
            sumY += point.getY();
        }
        // Divide points into two equal sized groups on either side of a vertical line
        Set<Point> XL = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double x1 = o1.getX(), x2 = o2.getX();
                if (x1 < x2)
                    return -1;
                if (x1 > x2)
                    return 1;
                return 0;
            }
        });
        Set<Point> XR = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double x1 = o1.getX(), x2 = o2.getX();
                if (x1 < x2)
                    return -1;
                if (x1 > x2)
                    return 1;
                return 0;
            }
        });

        // Divide points into two equal sized groups on either side of a horizontal line
        Set<Point> YL = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double y1 = o1.getY(), y2 = o2.getY();
                if (y1 < y2)
                    return -1;
                if (y1 > y2)
                    return 1;
                return 0;
            }
        });
        Set<Point> YR = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double y1 = o1.getY(), y2 = o2.getY();
                if (y1 < y2)
                    return -1;
                if (y1 > y2)
                    return 1;
                return 0;
            }
        });

        for (Point point : P){
            if (point.getX() < sumX / 2)
                PL.add(point);
            else
                PR.add(point);
        }

        XL.addAll(PL);
        XR.addAll(PR);
        YL.addAll(PL);
        YR.addAll(PR);

    }


}