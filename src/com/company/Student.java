package com.company;

import java.util.Arrays;

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

    public int getMean(){
        /**
         * @return Mean of grades
         */
        int sum = 0;
        for(int i: this.grades)
            sum += i;
        return sum/grades.length;
    }

    private String getLetterGrade(){
        int mean = getMean();
        if(mean>=97)
            return "A+";
        if(mean>=93)
            return "A";
        if(mean>=90)
            return "A-";
        if(mean>=87)
            return "B+";
        if(mean>=83)
            return "B";
        if(mean>=80)
            return "B-";
        if(mean>=77)
            return "C-";
        if(mean>=73)
            return "C";
        if(mean>=70)
            return "C-";
        if(mean>=60)
            return "D";
        if(mean>=0)
            return "F";
        else
            return "ERROR";
    }

    public void printFormattedLine(){
        System.out.println(getName() +" ("+getMean()+"%) ("+getLetterGrade()+") "+getOrderedGradeList());
    }

}
