import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ClosestPoints {

    public Set<Point> fileToPointSet(String fileName) throws IOException {
        return stringListToPointSet(readInputData(fileName));
    }

    public List<String> readInputData(String fileName) throws IOException, NoSuchFileException{
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
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
            float x = Float.valueOf(string.split(",")[0].substring(1));
            float y = Float.valueOf(removeLastChar(string.split(",")[1]));
            Point point = new Point(x, y);
            pointSet.add(point);
        }
        return  pointSet;
    }

    private float distanceBetweenPoints(Point point1, Point point2){
        return (float) Math.sqrt(Math.pow(point1.getX()-point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

    public String pointSetToString(Set<Point> P){
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : P){
            stringBuilder.append("(").append(point.getX()).append(", ").append(point.getY()).append(")").append(" ");
        }
        return removeLastChar(stringBuilder.toString());
    }


    /**
     * Optimized solution to the closest points problem.
     * Uses a more object oriented approach.
     * Runs in O(n log n) time.
     * Based on the algorithm described in Introduction to Algorithms
     *  3rd Edition by Cormen, et al on page 1039.
     * This is a divide and conquer based approach.
     * This is the master algorithm as described in the book.
     * @param P Subset of all points
     **/
    public Set<Point> closestPointsInSet(Set<Point> P){
        float closestDistance = Float.MAX_VALUE;
        Set<Point> closestSet = null;
        if (P.size() <= 3){
            // When |P| < 3, use the brute force approach
            return bruteForceClosestPoints(P);
        }
        // Pre-sort points
        Point[] Y = new Point[P.size()];
        Point[] X = new Point[P.size()];
        int i = 0;
        for (Point point : P) {
            Y[i] = point;
            X[i++] = point;
        }
        Arrays.sort(Y, (o1, o2) -> {
            double x1 = o1.getY(), x2 = o2.getY();
            if (x1 < x2)
                return -1;
            if (x1 > x2)
                return 1;
            return 0;
        });
        Arrays.sort(X, (o1, o2) -> {
            double x1 = o1.getX(), x2 = o2.getX();
            if (x1 < x2)
                return -1;
            if (x1 > x2)
                return 1;
            return 0;
        });

        // Divide and conquer step
        Set<Point> deltaSet = closestPointsInSet(P, X, Y);
        float delta = distanceBetweenPoints(deltaSet);
        closestDistance = delta;
        closestSet = deltaSet;
        assert closestSet != null;
        assert closestDistance != Float.MAX_VALUE;

        // Combine step:
        // Pair is either deltaSet or points that exist on either side of the vertical dividing line
        // If closest pair are on either side of the dividing line, they must be within 2*delta units of each other
        float l = (X[X.length/2].getX()+X[(X.length/2)+1].getX())/2;
        Set<Point> Yprime = new HashSet<>();
        for (Point p : Y){
            if (p.getX()-l <= delta){
                Yprime.add(p);
            }
        }
        // Brute force approach for closest points in Yprime
        Set<Point> deltaPrimeSet = bruteForceClosestPoints(Yprime);
        float deltaPrime = distanceBetweenPoints(deltaPrimeSet);
        // Return set that corresponds to min(δ, δ')
        if (delta < deltaPrime)
            return deltaSet;
        else
            return deltaPrimeSet;
    }

    /**
     * Optimized solution to the closest points problem.
     * Uses a more object oriented approach.
     * Runs in O(n log n) time.
     * Based on the algorithm described in Introduction to Algorithms
     *  3rd Edition by Cormen, et al on page 1039.
     * This is a divide and conquer based approach.
     * @param P Subset of all points
     * @param X List of points sorted by x-coordinate
     * @param Y List of points sorted by y-coordinate
     * @return Closest two points
     */
    private Set<Point> closestPointsInSet(Set<Point> P, Point[] X, Point[] Y){
        if (P.size() <= 3){
            // When |P| < 3, use the brute force approach
            return bruteForceClosestPoints(P);
        }

        // When |P| > 3, execute the divide and conquer, recursive approach
        // Divide step:
        //  Find vertical line l that bisects set P into equally sized sets PL and PR
        //  where PL is to the left of l and PR is to the right
        Set<Point> PL = new HashSet<>();
        Set<Point> PR = new HashSet<>();
        PL.addAll(Arrays.asList(X).subList(0, X.length / 2));
        PR.addAll(Arrays.asList(X).subList(X.length / 2, X.length));

        // Place points from PL and PR into XL, XR, YL, and YR
        // XL and XR and the points from sets PL and PR ordered by X coordinate
        // YL and YR are similar but ordered by Y coordinate
        Point[] XL = new Point[PL.size()];
        Point[] XR = new Point[PR.size()];
        Point[] YL = new Point[PL.size()];
        Point[] YR = new Point[PR.size()];

        // Place points into XL and XR
        XL = Arrays.copyOfRange(X, 0, P.size()/2);
        XR = Arrays.copyOfRange(X, P.size()/2, P.size());

        // Place points into YL and YR
        YL = Arrays.copyOfRange(Y, 0, P.size()/2);
        YR = Arrays.copyOfRange(Y, P.size()/2, P.size());

        // Conquer step:
        // Make two recursive calls
        Set<Point> deltaLSet = closestPointsInSet(PL, XL, YL);
        Set<Point> deltaRSet = closestPointsInSet(PR, XR, YR);

        float deltaL = distanceBetweenPoints(deltaLSet);
        float deltaR = distanceBetweenPoints(deltaRSet);

        if (deltaL < deltaR){
            return deltaLSet;
        } else
            return deltaRSet;
    }

    private float distanceBetweenPoints(Set<Point> points){
        float closestDistance = Float.MAX_VALUE;
        Set<Point> closestPair = new HashSet<>(2);
        for (Point point : points){
            for (Point point1: points){
                if (point.equals(point1))
                    continue;
                if (distanceBetweenPoints(point, point1) < closestDistance)
                    closestDistance = distanceBetweenPoints(point, point1);
            }
        }
        return closestDistance;
    }

    private Set<Point> bruteForceClosestPoints(Set<Point> P){
        float closestDistance = Float.MAX_VALUE;
        Set<Point> closestPair = new HashSet<>(2);
        for (Point point : P){
            for (Point point1: P){
                if (point.equals(point1))
                    continue;
                if (distanceBetweenPoints(point, point1) < closestDistance){
                        /*
                        If the distance between the points is the closest yet encountered, set the closestDistance
                        variable to the new distance, clear the closestPair set, and add the new points to the
                        closestPair set.
                         */
                    closestDistance = distanceBetweenPoints(point, point1);
                    closestPair.clear();
                    closestPair.add(point); closestPair.add(point1);
                }

            }
        }
        return closestPair;
    }

}