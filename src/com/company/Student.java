package com.company;

import java.util.Arrays;

/**
 * Created by User on 7/18/2014.
 */
public class Student {



    private String name;
    private int[] grades = new int[5];

    public Student(String inputLine){
        parseLine(inputLine);
    }

    private void parseLine(String inputLine) {
        /**
         * Sets up object by reading line from file
         * @param inputLine Line being parsed
         */
        String[] wordList = inputLine.split(" ");
        setName(wordList);
        setGrades(wordList);
        for(String w: wordList)
            System.out.print(w+" ");
    }

    public String getName() {
        return name;
    }

    public void setName(String[] inputList) {
        /**
         * @param inputList Line from input file to be parsed
         */
        this.name = inputList[2]+" "+inputList[0];
    }

    public void setGrades(String[] inputList) {
        for(int i=3; i<=7; i++)
            this.grades[i-3] = Integer.parseInt(inputList[i]);
    }

    private String getOrderedGradeList(){
        /**
         * Generates a string containing an ordered list of grades
         * for this particular student.
         * @return List of grades
         */
        Arrays.sort(this.grades);
        String output = "";
        for(int i: this.grades)
            output += i+" ";
        return output;
    }

    private int getMean(){
        /**
         * @return Mean of grades
         */
        int sum = 0;
        for(int i: this.grades)
            sum += i;
        return sum/grades.length;
    }

    private String getLetterGrade(){
        if(getMean()>=97)
            return "A+";
        if(getMean()>=93)
            return "A";
        if(getMean()>=90)
            return "A-";
        if(getMean()>=87)
            return "B+";
        if(getMean()>=83)
            return "B";
        if(getMean()>=80)
            return "B-";
        if(getMean()>=77)
            return "C-";
        if(getMean()>=73)
            return "C";
        if(getMean()>=70)
            return "C-";
        if(getMean()>=60)
            return "D";
        if(getMean()>=0)
            return "F";
        else
            return "ERROR";
    }

    public void printFormattedLine(){
        System.out.println(getName() +" ("+getMean()+"%) ("+getLetterGrade()+") "+getOrderedGradeList());
    }



}
