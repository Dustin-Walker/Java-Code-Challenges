import java.util.HashMap;
import java.util.Scanner;

/**
 * This class acts as the entry point to the program.
 */

public class GameService {

    public static void main(String[] args) {
        Deck deck = new Deck();
        //for (Card card : deck)
          //  System.out.println(card.toString());
        int numberOfPlayers = new GameService().queryNumberOfPlayers();
        HashMap<Integer, Player> playerList = new GameService().dealNewGame(numberOfPlayers, deck);
     //   for (Player player : playerList.values())
    //        System.out.println("Player has "+player.hand[0]+" and "+player.hand[1]);
    }

    public int queryNumberOfPlayers(){
        System.out.println("How many players (2-8) ? ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * This method deals new hands and starts a new game.
     * @param numberOfPlayers The number of players in the game
     * @param deck The deck of cards to deal from
     */
    public HashMap<Integer, Player> dealNewGame(int numberOfPlayers, Deck deck){
        assert numberOfPlayers <=8 && numberOfPlayers >= 2;
        HashMap<Integer, Player> playerSet = new HashMap<Integer, Player>(numberOfPlayers);
        for (int playerIndex = 0; playerIndex < numberOfPlayers; playerIndex++) {
            playerSet.put(playerIndex, new Player(deck.pop(), deck.pop()));
        }
        return playerSet;
    }

}
