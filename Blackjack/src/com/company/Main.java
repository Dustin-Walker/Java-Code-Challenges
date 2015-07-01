package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many decks do you want to use?");
        int deckCount = new Scanner(System.in).nextInt();
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        ArrayList<Card> mainDeck = generateDeck(deckCount);
        int deckSize = mainDeck.size(), blackjackCounter=0;
        int handsDealt=0;
        shuffleDeck(mainDeck, rnd);
        for(int k=2; k<deckSize; ) {
            Card[] hand = dealEm(mainDeck);
            if(blackjackCheck(hand))
                blackjackCounter++;
            deckSize = mainDeck.size();
            handsDealt++;
        }
        System.out.println("After "+handsDealt+" hands there were "+
               blackjackCounter+" blackjacks at "+
               String.format("%5.2f", 100.0f*blackjackCounter/handsDealt)+"%");
    }

    public static ArrayList<Card> generateDeck(int deckCount){
        /**
         * This function generates at least one deck of cards
         *
         * @param deckCount Number of decks to be generated
         * @return Collection of non-shuffled decks
         */
        ArrayList<Card> resultDeck = new ArrayList<Card>();
        if(deckCount<1 || deckCount>10)
            deckCount=1;
        for(; deckCount>0; deckCount--) {
            for (int suitID = 0; suitID < 4; suitID++) {
                for (int valueID = 0; valueID < 13; valueID++) {
                    resultDeck.add(new Card(suitID, valueID));
                }
            }
        }
        return resultDeck;
    }

    public static void shuffleDeck(ArrayList<Card> inputDeck, Random rnd){
        /**
         * This function shuffles the decks of cards into random order
         * Implementation of modern Fisher-Yates shuffle
         *
         * @param inputDeck The deck to be shuffled
         * @param rnd Random number generator that is already seeded
         * @return Nothing
         */
        int deckSize = inputDeck.size(), j;
        Card temp;
        for(int i=0; i<deckSize; i++){
            j = i+rnd.nextInt(deckSize-i);
            temp = inputDeck.get(j);
            inputDeck.set(j, inputDeck.get(i));
            inputDeck.set(i, temp);
        }
    }

    public static Card[] dealEm(ArrayList<Card> inputDeck){
        /**
         * Deal cards from deck based on blackjack rules
         * Always draw extra card when hand is <=11
         *
         * @param inputDeck Deck from which cards are to be drawn
         * @return Two or more cards to form a hand
         */
        int deckSize = inputDeck.size()-1;
        Card[] resultHand = new Card[3];
        resultHand[0] = inputDeck.get(deckSize);
        inputDeck.remove(deckSize--);
        resultHand[1] = inputDeck.get(deckSize);
        inputDeck.remove(deckSize--);
        if(resultHand[0].value+resultHand[1].value<=11){
            resultHand[2] = inputDeck.get(deckSize);
            inputDeck.remove(deckSize);
        }
        else
            resultHand[2] = resultHand[1];
        return resultHand;
    }

    public static void printHand(Card[] inputHand){
        /**
         * Prints hand to screen
         *
         * @param Hand to be printed
         * @return Nothing
         */
        int handValue;
        System.out.println("Card1: "+inputHand[0].getSuit()+inputHand[0].getCValue());
        System.out.println("Card2: " + inputHand[1].getSuit() + inputHand[1].getCValue());
        if(inputHand[2]!=inputHand[1]) {
            handValue=inputHand[0].value+inputHand[1].value+inputHand[2].value;
            System.out.println("Card3: " + inputHand[2].getSuit() + inputHand[2].getCValue());
        } else {
            handValue=inputHand[0].value+inputHand[1].value;
        }
        if(handValue>21)
            handValue-=10;
        if(handValue!=21)
            System.out.println("Hand value is: "+handValue+"\n");
        else
            System.out.println("You got blackjack!\n");
    }

    public static boolean blackjackCheck(Card[] inputHand){
        /**
         * Determines whether hand is blackjack
         *
         * @param inputHand Hand to be checked
         * @return true=Blackjack, false=No blackjack
         */
        if(!inputHand[2].equals(inputHand[1]))
            return false;
        return (inputHand[0].value+inputHand[1].value)==21;
    }

}

