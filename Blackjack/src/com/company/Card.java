package com.company;

public class Card {
    private char suit;
    private char cValue;
    public int value;

    public Card(int suitValue, int cValue){
        setSuit(suitValue);
        setValue(cValue);
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(int suitValue) {
        this.suit = suitValueParser(suitValue);
    }

    public char getCValue() {
        return cValue;
    }

    public void setValue(int cValue) {
        this.cValue = cValueParser(cValue);
        this.value = iValueParser(cValue);
    }

    private static int iValueParser(int cValue){
        /**
         * This function converts the card face code
         * to a numerical play value.
         *
         * @param cValue CharValue of card
         * @return Integer representing play value of card
         */
        switch (cValue){
            case 0: return 11;
            case 1: return 2;
            case 2: return 3;
            case 3: return 4;
            case 4: return 5;
            case 5: return 6;
            case 6: return 7;
            case 7: return 8;
            case 8: return 9;
            case 9: return 10;
            case 10: return 10;
            case 11: return 10;
            case 12: return 10;
            default: return 0;
        }
    }

    private static char cValueParser(int cValue){
        /**
         * This function converts the card face code
         * to a char face value.
         *
         * @param cValue CharValue of card
         * @return Integer representing play value of card
         */
        switch (cValue){
            case 0: return 'A';
            case 1: return '2';
            case 2: return '3';
            case 3: return '4';
            case 4: return '5';
            case 5: return '6';
            case 6: return '7';
            case 7: return '8';
            case 8: return '9';
            case 9: return 'T';
            case 10: return 'J';
            case 11: return 'Q';
            case 12: return 'K';
            default: return 0;
        }
    }
    private static char suitValueParser(int suitValue){
        /**
         * This function converts an integer into a card suit
         *
         * @param suitValue Integer code to be converted
         * @return Char representing card suit
         */
        switch (suitValue){
            case 0: return '♠';
            case 1: return '♥';
            case 2: return '♦';
            case 3: return '♣';
            default: return 'E';
        }
    }
}
