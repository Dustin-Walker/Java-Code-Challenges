package com.company;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your paragraph:");
        String userInput = sc.nextLine();
        Page newPage = new Page(userInput);
        System.out.println("Enter a file name:");
        userInput = sc.nextLine();
        newPage.savePageToHTMLFile(userInput);
    }
}
