import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by user on 5/31/15.
 */
public class Player{


    public Card[] hand;


    public Player(Card card1, Card card2) {
        // Players can only have 2 cards at most
        hand = new Card[2];
        this.hand[0] = card1;
        this.hand[1] = card2;
    }
}
