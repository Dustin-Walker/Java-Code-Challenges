import java.util.HashMap;
import java.util.Scanner;

/**
 * This class acts as the entry point to the program.
 */

public class GameService {

    public static void main(String[] args) {
        Deck deck = new Deck();
        GameService gameService = new GameService();
        //for (Card card : deck)
          //  System.out.println(card.toString());
        int numberOfPlayers = gameService.queryNumberOfPlayers();
        System.out.println();
        HashMap<Integer, Player> playerList = gameService.dealNewCardsToPlayers(numberOfPlayers, deck);
        gameService.flop(deck);
        for (Player player : playerList.values())
            System.out.println("Player has "+player.hand[0]+" and "+player.hand[1]);
        System.out.println("\n" + SharedCards.flopToString());
        gameService.turn(deck);
        System.out.println(SharedCards.turnToString());
        gameService.river(deck);
        System.out.println(SharedCards.riverToString());

        // TODO Iterate over each player in the hash table using this approach
        Card[] playerHand = new Card[7];
        playerHand[0] = playerList.get(0).hand[0];
        playerHand[1] = playerList.get(0).hand[1];
        for (int i = 0; i < 5; i++) {
            playerHand[i+2] = SharedCards.cardList[i];
        }
        GameLogic logic = new GameLogic();
        System.out.println("Player one has a "+logic.highestTexasHand(playerHand));

        Card[] player2Hand = new Card[7];
        player2Hand[0] = playerList.get(1).hand[0];
        player2Hand[1] = playerList.get(1).hand[1];
        for (int i = 0; i < 5; i++) {
            player2Hand[i+2] = SharedCards.cardList[i];
        }
        System.out.println("Player two has a "+logic.highestTexasHand(player2Hand));
    }

    private void turn(Deck deck) {
        deck.pop();
        SharedCards.add(deck.pop());
    }

    private void river(Deck deck){
        turn(deck);
    }

    private int queryNumberOfPlayers(){
        System.out.println("How many players (2-8) ? ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * This method deals new hands and starts a new game.
     * @param numberOfPlayers The number of players in the game
     * @param deck The deck of cards to deal from
     */
    private HashMap<Integer, Player> dealNewCardsToPlayers(int numberOfPlayers, Deck deck){
        assert numberOfPlayers <=8 && numberOfPlayers >= 2;
        HashMap<Integer, Player> playerSet = new HashMap<Integer, Player>(numberOfPlayers);
        for (int playerIndex = 0; playerIndex < numberOfPlayers; playerIndex++) {
            playerSet.put(playerIndex, new Player(deck.pop(), deck.pop()));
        }
        return playerSet;
    }

    /**
     * pop pop pop
     * @param deck Deck to work with
     */
    private void flop(Deck deck){
        deck.pop();
        SharedCards.add(deck.pop());
        SharedCards.add(deck.pop());
        SharedCards.add(deck.pop());
    }

}
