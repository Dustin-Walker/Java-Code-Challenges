/**
 * Created by user on 5/31/15.
 */
public class Card {

    final public Suite suite;
    final public CardType cardType;

    public Card(Suite suite, CardType cardType) {
        this.suite= suite;
        this.cardType = cardType;
    }
    

    @Override
    public String toString(){
        return cardType+" of "+suite;
    }
}

