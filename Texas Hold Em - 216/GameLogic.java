/**
 * Created by user on 5/31/15.
 */
public class GameLogic {

    public String highestTexasHand(Card[] cards){

        assert cards.length==7;
        
        int[] cardTypes = cardTypeCounter(cards);
        int[] suites = cardSuiteCounter(cards);

        if (isStraight(cardTypes) && isFlush(suites))
            return "straight flush";

        if (isFlush(suites))
            return "flush";

        if (isFourOfAKind(cardTypes))
            return "four of a kind";

        if (isFullHouse(cardTypes))
            return "full house";

        if (isStraight(cardTypes))
            return "straight";

        if (isTwoPair(cardTypes))
            return "two pair";

        if (isPair(cardTypes))
            return "pair";

        return "high card";
    }

    /**
     * This method is used to determine the high card for a player's hand.
     * Thanks to David and Justin for pointing out the enum ordinal property.
     * @param cards Cards to assess
     * @return CardType of highest card in hand
     */
    public CardType playerHighCard(Card[] cards){
        CardType highCard = CardType.Two;
        for(Card card : cards)
            if (card.cardType.ordinal() > highCard.ordinal())
                highCard = card.cardType;
        return  highCard;
    }

    private boolean isFullHouse(int[] cardTypes) {
        return (isPair(cardTypes) && isThreeOfAKind(cardTypes));
    }

    private boolean isThreeOfAKind(int[] cardTypes) {
        for (int cardType : cardTypes)
            if (cardType >= 3)
                return true;
        return false;
    }

    private boolean isFourOfAKind(int[] cardTypes) {
        int fourOfAKindCounter = 0;
        for(int cardType : cardTypes)
            if(cardType >= 4)
                fourOfAKindCounter++;
        return fourOfAKindCounter > 0;
    }

    private boolean isPair(int[] cardTypes) {
        for (int cardType : cardTypes)
            if (cardType >= 2)
                return true;
        return false;
    }

    private boolean isTwoPair(int[] cardTypes){
        int twoPairCounter = 0;
        for (int cardType : cardTypes)
            if (cardType >= 2)
                twoPairCounter++;
        return twoPairCounter >= 2;
    }

    private boolean isFlush(int[] suites) {
        for (int suite : suites)
            if (suite >= 5)
                return true;
        return false;
    }

    private boolean isStraight(int[] cardTypes){
        int straightCounter = 0;
        for (int cardType : cardTypes) {
            if (cardType > 0)
                straightCounter++;
            else
                straightCounter = 0; // Reset
            if (straightCounter >= 5)
                return true;
        }
        return false;
    }

    private int[] cardTypeCounter(Card[] cards){
        int[] cardTypes = new int[14];
        for (Card card : cards) {
            switch (card.cardType){
                case Ace:   cardTypes[0]++; cardTypes[13]++; break;
                case Two:   cardTypes[1]++; break;
                case Three: cardTypes[2]++; break;
                case Four:  cardTypes[3]++; break;
                case Five:  cardTypes[4]++; break;
                case Six:   cardTypes[5]++; break;
                case Seven: cardTypes[6]++; break;
                case Eight: cardTypes[7]++; break;
                case Nine:  cardTypes[8]++; break;
                case Ten:   cardTypes[9]++; break;
                case Jack:  cardTypes[10]++; break;
                case Queen: cardTypes[11]++; break;
                case King:  cardTypes[12]++; break;
            }
        }
        return cardTypes;
    }

    private int[] cardSuiteCounter(Card[] cards){
        int[] suites = new int[4];
        for(Card card : cards){
            switch (card.suite){
                case Clubs:     suites[0]++; break;
                case Spades:    suites[1]++; break;
                case Diamonds:  suites[2]++; break;
                case Hearts:    suites[3]++; break;
            }
        }
        return suites;
    }

}
