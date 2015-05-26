/**
 * Created by Dustin on 5/17/15.
 * From http://www.reddit.com/r/dailyprogrammer/comments/351b0o/intermediate
 * This program calculates and displays the 'effort' required to type a sentence using the hunt-and-peck typing method.
 */
public class LazyTypist {
    // TODO Write method to parse incoming text
    // TODO Write a method to display output

    public static void main(String[] args) {
	// write your code here
        LazyTypist lazyTypist = new LazyTypist();
        Graph g = new Graph().keyboardToGraph(lazyTypist.keyboard);
        for (Node node : g.nodeCollection.values())
            System.out.println(node.key+" "+node.printEdgeList());
    }

    private final String[] keyboard = {"qwertyuiop","asdfghjkl ", "^zxcvbnm ^", "   #####  "};

    private static char leftFinger = '=';
    private static char rightFinger = '=';

    public void analyzeStringKeyboardDistance(String inputString){
        int inputLength = inputString.length();
        char[] inputArray = inputString.toCharArray();

        // Initial character has no effort

        // Compare all the other characters against the follow character
        if(inputLength>1){
            for (int i = 0; i < inputLength; i++) {

            }
        }

    }

    /**
     * Calculates the 'effort' or Manhattan distance (x+y) from one key to another
     * @param source
     * @param destination
     * @return Number representing number of 'steps' required to move from source to destination
     */
    private int calculateEffort(char source, char destination){
          // Set the fingerPositions
        if( leftFinger=='=' || rightFinger=='=' ){
            // Find which finger is closer

        }

        // TODO Finish this method

        return 0;
    }

    /**
     * Method performs Dijkstra's algorithm to search the graph and calculate the 'effort'
     * @param source Source key
     * @param destination Destination key
     * @return Integer representing how many edges were crossed to travel from source to destination
     */
    private int dijkstraGraphSearch(char source, char destination){
        // TODO Re-use this code https://github.com/Dustin-Walker/FoodDelivery/blob/master/src/Main.java#L62-L138
        return 0;
    }

    /**
     * This method relaxes an edge. Updates and tests whether vertex v is an improvement upon the current path.
     * This technique is described on page 649 of Introduction to Algorithms by Cormen et al.
     * @param u Source vertex
     * @param v Destination vertex
     * @param w Edge being tested for relaxation
     */
    private void relax(Node u, Node v, String w){
        // TODO Fill in this method
    }

}