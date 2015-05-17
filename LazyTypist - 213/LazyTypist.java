/**
 * Created by Dustin on 5/17/15.
 * From http://www.reddit.com/r/dailyprogrammer/comments/351b0o/intermediate
 * This program calculates and displays the 'effort' required to type a sentence using the hunt-and-peck typing method.
 */
public class LazyTypist {

    public static void main(String[] args) {
	// write your code here
    }

    private final String[] keyboard = {"qwertyuiop","asdfghjkl", "^zxcvbnm ^", "   #####  "};

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
     * @return
     */
    private int calculateEffort(char source, char destination){
        // TODO Use BFS algorithm
        return 0;
    }

    /**
     * TConverts a keyboard layout into a graph
     * @param keyboard String array where each string element represents a line on the keyboard
     * @return Populated graph containing keys as nodes
     */
    private Graph keyboardToGraph(String[] keyboard){
        int keyboardRows = keyboard.length;
        Graph g = new Graph();
        for (int i = 0; i < keyboardRows; i++) {
            int keyboardRowLength = keyboard[i].length();
            for (int j = 0; j < keyboardRowLength; j++) {
                g.addNode(new Node(keyboard[i].charAt(j)));
                if(keyboardRowLength>1){
                    // Add edges
                }
            }
        }
        return new Graph();
    }
}