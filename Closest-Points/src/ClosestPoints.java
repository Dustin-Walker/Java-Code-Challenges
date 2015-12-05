import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
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
    private String[] closestPointsStrings = new String[2];
    private Point[] closestPoints = new Point[2];

    public static void main(String[] args) throws IOException, NoSuchFileException {

        ClosestPoints closestPoints = new ClosestPoints();
       // String closestPointsFromFile = closestPoints.printClosestPointsFromFile("sample.data");
        Set<Point> P = closestPoints.stringListToPointSet(closestPoints.readInputData("sample.data"));
        System.out.println(closestPoints.getClosestPoints(P)[0].getX() + " " + closestPoints.getClosestPoints(P)[0].getY());
    //    System.out.println(closestPointsFromFile);
    //    System.out.println(closestPoints.lowestDistance + " is the distance between the closest points.");
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
                    closestPointsStrings[0] = list.get(i);
                    closestPointsStrings[1] = list.get(j);
                }
            }
        }
        return closestPointsStrings;
    }

    private String removeLastChar(String s){
        if (s.length() > 0 && s.charAt(s.length()-1)==')') {
            s = s.substring(0, s.length()-1);
        }
        return s;
    }

    public Set<Point> stringListToPointSet(List<String> list){
        HashSet<Point> pointSet = new HashSet<>();
        list.remove(0);
        for (String string : list){
        //    System.out.println(string);
            float x = Float.valueOf(string.split(",")[0].substring(1));
            float y = Float.valueOf(removeLastChar(string.split(",")[1]));
            Point point = new Point(x, y);
            pointSet.add(point);
        }
        return  pointSet;
    }

    /**
     * Optimized solution to the closest points problem.
     * Uses a more object oriented approach.
     * Runs in O(n log n) time.
     * Based on the algorithm described in Introduction to Algorithms
     *  3rd Edition by Cormen, et al on page 1039.
     * This is a divide and conquer based approach.
     * @param P Subset of all points
     * @return Closest two points
     */
    public Point[] getClosestPoints(Set<Point> P){
        // Brute force case
        if (P.size() <= 3){
            // brute force solution
        }
        // Divide step
        // Divide and sort points into groups
        int sumX = 0, sumY = 0;
        Set<Point> PL = new HashSet<>();
        Set<Point> PR = new HashSet<>();
        for (Point point : P){
            sumX += point.getX();
            sumY += point.getY();
        }
        // Divide points into two equal sized groups on either side of a vertical line
        // X set consists of points ordered by X coordinate
        Set<Point> XLset = new TreeSet<Point>(new Comparator<Point>() {
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
        Set<Point> XRset = new TreeSet<Point>(new Comparator<Point>() {
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
        // Y set consists of points ordered by Y coordinate
        Set<Point> YLset = new TreeSet<Point>(new Comparator<Point>() {
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
        Set<Point> YRset = new TreeSet<Point>(new Comparator<Point>() {
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

        // Adding after the comparator has been described means the points are added upon insertion
        // This improves the speed of the algorithm, preventing the need for repeated sorting operations
        for (Point point : P){
            if (point.getX() < sumX / 2)
                PL.add(point);
            else
                PR.add(point);
        }

        XLset.addAll(PL);
        XRset.addAll(PR);
        YLset.addAll(PL);
        YRset.addAll(PR);

        ArrayList<Point> XL = new ArrayList<>(XLset);
        ArrayList<Point> XR = new ArrayList<>(XRset);
        ArrayList<Point> YL = new ArrayList<>(YLset);
        ArrayList<Point> YR = new ArrayList<>(YRset);

        // Conquer step
        // Make two recursive calls to find closest pairs of points within PL and PR
        // Inputs for first call with be PL, XL, YL. Second call gets PR, XR, YR

        float deltaL = distanceBetweenPoints(getClosestPoints(PL, XL, YL)); // closest-pair distance in PL
        float deltaR = distanceBetweenPoints(getClosestPoints(PR, XR, YR)); // closest-pair distance in PR
        float delta = Math.min(deltaL, deltaR);

        if (deltaL < deltaR)
            return getClosestPoints(PL, XL, YL);
        else
            return getClosestPoints(PR, XR, YR);

    }

    private float distanceBetweenPoints(Point[] points){
        return (float) Math.sqrt(Math.pow(points[0].getX()-points[1].getX(), 2) + Math.pow(points[0].getY() - points[1].getY(), 2));
    }

    private Point[] getClosestPoints(Set<Point> P, List<Point> X, List<Point> Y){
        // Brute force case
        if (P.size() <= 3) {
            // brute force solution
            Point[] Parray = (Point[]) P.toArray();
            for (int i = 0; i < P.size() - 1; i++) {
                for (int j = i + 1; j < P.size(); j++) {

                    double deltaX = Parray[i].getX() - Parray[j].getX();
                    double deltaY = Parray[i].getY() - Parray[j].getY();

                    double distanceBetweenPoints = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

                    if (distanceBetweenPoints < lowestDistance) {
                        lowestDistance = distanceBetweenPoints;
                        closestPoints[0] = Parray[i];
                        closestPoints[1] = Parray[j];
                    }
                }
            }
            return closestPoints;
        }
        // Non-brute force case
        int sumX = 0, sumY = 0;
        Set<Point> PL = new HashSet<>();
        Set<Point> PR = new HashSet<>();
        for (Point point : P){
            sumX += point.getX();
            sumY += point.getY();
        }

        for (Point point : P){
            if (point.getX() < sumX / 2)
                PL.add(point);
            else
                PR.add(point);
        }

        ArrayList<Point> XL = new ArrayList<>(PL);
        ArrayList<Point> XR = new ArrayList<>(PR);
        ArrayList<Point> YL = new ArrayList<>(PL);
        ArrayList<Point> YR = new ArrayList<>(PR);

        float min = Math.min(distanceBetweenPoints(getClosestPoints(PL, XL, YL)), distanceBetweenPoints(getClosestPoints(PR, XR, YR)));
        if (min == distanceBetweenPoints(getClosestPoints(PL, XL, YL)))
            return getClosestPoints(PL, XL, YL);
        else
            return getClosestPoints(PR, XR, YR);

        //return getClosestPoints()


    }


}