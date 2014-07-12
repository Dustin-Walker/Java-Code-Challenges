package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Enable1.txt is the local dictionary file to use
        File file = new File("enable1.txt");
        ArrayList<String> wordList = constructList(file);
        ArrayList<String> newList = listCompactor(wordList);
        Scanner inputReader = new Scanner(System.in);
        boolean inputCheck=false;
        for(String word : newList)
            System.out.println(word.toUpperCase());
        Random generator = new Random(System.currentTimeMillis());
        String referenceWord = newList.get(generator.nextInt(newList.size()));
        for(int i = 4; i > 0;i--){
            System.out.print("Guess ("+i+" left)? ");
            String inputString=inputReader.next();
            while(inputString.length()!=referenceWord.length()){
                System.out.print("Invalid entry. Try again: ");
                inputString=inputReader.next();
            }
            inputCheck = inputChecker(inputString, referenceWord);
            if(inputCheck)
                break;
        }
        if(inputCheck){
            System.out.println("You win!");
        } else {
            System.out.println("You lose :(\nThe word was "+referenceWord);
        }
    }

    public static ArrayList<String> constructList(File file) {
        /**
         * This method creates a list of all words of some length
         * from a dictionary file.
         * @param file Name of the dictionary file to be used
         * @return List of strings of equal length
         */
        BufferedReader reader = null;
        ArrayList<String> wordList = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            wordList = new ArrayList<String>();
            while ((text = reader.readLine()) != null) {
                //Change the 7 right here for varying difficulty
                if (text.length() == 7) {
                    wordList.add(text);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wordList;
    }

    public static  ArrayList<String> listCompactor(ArrayList<String> wordList){
        /**
         * Takes list of words and returns a new list consisting of
         * ten random words from the original list.
         * @param wordList Source list
         * @return List of 10 words of equal length
         */
        ArrayList<String> newList = new ArrayList<String>(10);
        Random generator = new Random(System.currentTimeMillis());
        for(int i=0;i<10;i++) {
            int randomPosition = generator.nextInt(wordList.size());
            newList.add(wordList.get(randomPosition));
            wordList.remove(randomPosition);
        }
        return newList;
    }

    public static boolean inputChecker(String input, String referenceWord){
        /**
         * Checks to see how many letters from the input word
         * match the reference word.
         * @param input User input word
         * @param referenceWord Word the user is trying to guess
         * @return True if user correctly guesses reference word
         */
        int correctLetters=0;
        input = input.toLowerCase();
        System.out.println(input);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == referenceWord.charAt(i))
                correctLetters++;
            }
            System.out.println(correctLetters+"/7 correct");
            return (correctLetters==7);
    }
}
