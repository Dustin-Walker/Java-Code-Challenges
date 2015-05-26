/**
 * Created by Dustin on 5/17/15.
 * From http://www.reddit.com/r/dailyprogrammer/comments/351b0o/intermediate
 * This program calculates and displays the 'effort' required to type a sentence using the hunt-and-peck typing method.
 */
public class LazyTypist {

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
        // TODO Use BFS algorithm

        // Set the fingerPositions
        if( leftFinger=='=' || rightFinger=='=' ){

        }



        return 0;
    }


}