package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner;
        try{
            fileScanner = new Scanner(new FileReader("sample2.in"));
            ArrayList<Student> studentList = new ArrayList<Student>();
            while(fileScanner.hasNextLine())
                studentList.add(new Student(fileScanner.nextLine()));
            //Sort studentList here
            sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for(Student s : studentList)
                s.printFormattedLine();
        } finally {

        }
    }
}
