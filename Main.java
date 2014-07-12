package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// Enable1.txt is the local dictionary file to use
        File file = new File("enable1.txt");
        ArrayList<String> wordList = constructList(file);
        ArrayList<String> newList = listCompactor(wordList);
        for(String word : newList){
            System.out.println(word);
        }

    }

    public static ArrayList<String> constructList(File file) {
        /**
         * @param file Name of the dictionary file to be used
         * @return List of strings to use for the game
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
        ArrayList<String> newList = new ArrayList<String>(10);
        Random generator = new Random(System.currentTimeMillis());
        for(int i=0;i<10;i++) {
            int randomPosition = generator.nextInt(wordList.size());
            newList.add(wordList.get(randomPosition));
            wordList.remove(randomPosition);
        }
        return newList;
    }
}
