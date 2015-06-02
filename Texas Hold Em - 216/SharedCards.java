import java.util.Collection;

/**
 * Created by user on 6/1/15.
 */
public class SharedCards {

    final static private int SHARED_CARD_SIZE = 5; // 5 for Texas
    public static Card[] cardList = new Card[SHARED_CARD_SIZE];

    /**
     * Adds a card to the shared cards list
     * @param card Card to add
     * @return True if the add was successful, false for a failure
     */
    public static boolean add(Card card){
        for (int arrayIndex = 0; arrayIndex < SHARED_CARD_SIZE; arrayIndex++) {
            if(cardList[arrayIndex] == null){
                cardList[arrayIndex] = card;
                return true;
            }
        }
        return false;
    }


    public static String flopToString() {
        return "Flop: "+cardList[0]+", "+cardList[1]+", "+cardList[2];
    }

    public static String turnToString() {
        return "Turn: "+cardList[3];
    }

    public static String riverToString() {
        return "River: "+cardList[4];
    }
}
