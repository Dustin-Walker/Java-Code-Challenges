import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *  http://www.reddit.com/r/dailyprogrammer/comments/2sfs8f/20150114_challenge_197_intermediate_food_delivery/
 *  Approach: Use Dijkstra's Algorithm to solve the shortest path problem.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("src\\data.txt");
        Main main = new Main();
        HashMap<String, Intersection> graph = main.addIntersectionsFromFile(file);
        Intersection origin = graph.get("A");
        Intersection destination = graph.get("O");
        System.out.println(main.shortestPath(graph, origin, destination, 1600));
    }

    /**
     * This method loads the information from the data file into a hash table.
     * @param file File to process.
     * @return Hash map representing a graph of vertices and edges.
     * @throws IOException Throw an exception if the file is not found.
     */
    public HashMap<String, Intersection> addIntersectionsFromFile(Path file) throws IOException {
        List<String> dataList = Files.readAllLines(file);
        HashMap<String, Intersection> intersectionSet = new HashMap<String, Intersection>();
        for(String line : dataList){
            String[] dataParts = line.split(",");
            assert dataParts.length == 7; // All lines should contain 7 discrete data points
            String origin = dataParts[0];
            String destination = dataParts[1];
            String streetName = dataParts[2];
            int t1 = Integer.valueOf(dataParts[3]); // 0600-1000
            int t2 = Integer.valueOf(dataParts[4]); // 1000-1500
            int t3 = Integer.valueOf(dataParts[5]); // 1500-1900
            int t4 = Integer.valueOf(dataParts[6]); // 1900-1600
            int[] edgeList = {t1, t2, t3, t4};
            Intersection intersection1 = new Intersection(origin);
            Intersection intersection2 = new Intersection(destination);
            Street street = new Street(streetName,edgeList, intersection1, intersection2);
            intersection1.addConnection(street);
            intersection2.addConnection(street);
            if(!intersectionSet.keySet().contains(intersection1.name)){
                intersectionSet.put(intersection1.name, intersection1);
            } else {
                intersectionSet.get(intersection1.name).addConnection(street);
            }
            if(!intersectionSet.keySet().contains(intersection2.name)){
                intersectionSet.put(intersection2.name, intersection2);
            } else {
                intersectionSet.get(intersection2.name).addConnection(street);
            }
        }
        return intersectionSet;
    }

    /**
     * This shortest path search uses Dijkstra's algorithm.
     * This algorithm is described on page 658 of Introduction to Algorithms by Cormen et al.
     * This is an implementation of Dijkstra's Algorithm using a min-priority queue. This search runs in O(V^2) time.
     * This version modifies the approach from the book by using the timeState mechanic.
     * @param graph Graph to analyze
     * @param origin Origin vertex
     * @param destination Destination vertex
     * @param timeState Time to search in 0000 format where 0000 is midnight, 1200 is noon, and 2359 is 11:59 PM.
     * @return String representing shortest path solution
     */
    public String shortestPath(HashMap<String, Intersection> graph, Intersection origin, Intersection destination, int timeState){
        initializeSingleSourceGraph(graph, origin);
        PriorityQueue<Intersection> Q = new PriorityQueue<Intersection>(new Comparator<Intersection>() {
            @Override
            public int compare(Intersection o1, Intersection o2) {
                return Integer.compare(o1.shortestPathEstimate,o2.shortestPathEstimate);
            }
        });
        for(Intersection intersection : graph.values())
            Q.add(intersection);
        while(!Q.isEmpty()){
            Intersection u = Q.poll();
            Intersection v=null;
            for(Street s : u.getConnections()){
                assert s.getIntersections()[0]==u||s.getIntersections()[1]==u;
                if(s.getIntersections()[0].name.equals(u.name))
                    v=graph.get(s.getIntersections()[1].name);
                else v=graph.get(s.getIntersections()[0].name);
                relax(u, v, s, timeState);
            }
        }
        int timeEstimate = destination.shortestPathEstimate;
        StringBuilder returnString = new StringBuilder("The shortest route from "
                +origin.name+" to "+destination.name+" is:");
        Stack<Intersection> stack = new Stack<Intersection>();
        while(destination!=null){
            stack.push(destination);
            destination=destination.predecessor;
        }
        if(!stack.empty())
            returnString.append("\n").append(stack.pop().name);
        while(!stack.empty())
            returnString.append(" -> ").append(stack.pop().name);
        returnString.append("\nThis route take about ").append(timeEstimate).append(" minutes.");
        return returnString.toString();
    }

    /**
     * This method initializes a graph for a single-source shortest path search.
     * This technique is described on page 648 of Introduction to Algorithms by Cormen et al.
     * @param g Graph to iterate over
     * @param origin Source vertex
     */
    private void initializeSingleSourceGraph(HashMap<String, Intersection> g, Intersection origin){
        final int ALMOST_INFINITE= 100000;
        for(Intersection vertex : g.values()) {
            vertex.shortestPathEstimate = ALMOST_INFINITE;
            vertex.predecessor = null ;
        }
        origin.shortestPathEstimate = 0;
    }

    /**
     * This method relaxes an edge. Updates and tests whether vertex v is an improvement upon the current path.
     * This technique is described on page 649 of Introduction to Algorithms by Cormen et al.
     * @param u Source vertex
     * @param v Destination vertex
     * @param w Edge being tested for relaxation
     */
    private void relax(Intersection u, Intersection v, Street w, int timeState){
        if(v.shortestPathEstimate>(u.shortestPathEstimate+w.getTime(timeState))){
            v.shortestPathEstimate=u.shortestPathEstimate+w.getTime(timeState);
            v.predecessor=u;
        }
    }
}
