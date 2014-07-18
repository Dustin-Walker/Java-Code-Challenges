package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner fileScanner;
    try{
        fileScanner = new Scanner(new FileReader("sample1.in"));
        ArrayList<Student> studentList = new ArrayList<Student>();
        while(fileScanner.hasNextLine()){
            studentList.add(new Student(fileScanner.nextLine()));
            System.out.println();
        }
        for(Student s : studentList)
            s.printFormattedLine();
    } finally {

    }
    }
}
