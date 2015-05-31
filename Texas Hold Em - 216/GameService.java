/**
 * This class acts as the entry point to the program.
 */

public class GameService {

    public static void main(String[] args) {
        Deck deck = new Deck();
        for (Card card : deck){
            System.out.println(card.toString());
        }
    }

}
