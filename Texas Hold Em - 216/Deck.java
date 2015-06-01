import java.util.Random;
import java.util.Stack;

/**
 * Created by user on 5/31/15.
 */
public class Deck extends Stack<Card>{

    final public int DECK_SIZE = 52;

    /**
     * Fisher-Yates shuffle
     */
    private void shuffleDeck(int deckSize, Deck deck) {
        Random random = new Random();
        for (int i = 0; i < deckSize-2; i++) {
            int j = random.nextInt(deckSize - i) + i;
            deck.swap(deck.elementAt(i), deck.elementAt(j));
        }
    }

    /**
     * Swap two cards in the deck
     * @param card1 First card to be swapped
     * @param card2 Second card to be swapped
     */
    private void swap(Card card1, Card card2){
        int i = this.indexOf(card1);
        int j = this.indexOf(card2);
        this.set(i, card2); this.set(j, card1);
    }

    public Deck(){
        for(Suite suite : Suite.values())
            for(CardType cardType : CardType.values())
                this.push(new Card(suite,cardType));
        shuffleDeck(DECK_SIZE, this);
    }
}
