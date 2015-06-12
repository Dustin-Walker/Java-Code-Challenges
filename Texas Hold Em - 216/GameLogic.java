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
     * @param cards Cards to assess
     * @return CardType of highest card in hand
     */
    public CardType playerHighCard(Card[] cards){
        int cardType = 0;
        for (Card card : cards){
            switch (card.cardType){
                case Two: if (cardType>2) break; else cardType = 2; break;
                case Three: if (cardType>3) break; else cardType = 3; break;
                case Four: if (cardType>4) break; else cardType = 4; break;
                case Five: if (cardType>5) break; else cardType = 5; break;
                case Six: if (cardType>6) break; else cardType = 6; break;
                case Seven: if (cardType>7) break; else cardType = 7; break;
                case Eight: if (cardType>8) break; else cardType = 8; break;
                case Nine: if (cardType>9) break; else cardType = 9; break;
                case Ten: if (cardType>10) break; else cardType = 10; break;
                case Jack: if (cardType>11) break; else cardType = 11; break;
                case Queen: if (cardType>12) break; else cardType = 12; break;
                case King: cardType = 13; break;
                case Ace: return CardType.Ace;
            }
        }
        switch (cardType){
            case 2: return CardType.Two;
            case 3: return CardType.Three;
            case 4: return CardType.Four;
            case 5: return CardType.Five;
            case 6: return CardType.Six;
            case 7: return CardType.Seven;
            case 8: return CardType.Eight;
            case 9: return CardType.Nine;
            case 10: return CardType.Ten;
            case 11: return CardType.Jack;
            case 12: return CardType.Queen;
            case 13: return CardType.King;
        }
        return null;
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
