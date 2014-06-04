package com.company;
import java.util.Random;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        //Display header
        System.out.println("# of Rolls 1s     2s     3s     4s     5s     6s    ");
        System.out.println("====================================================");
        //Create random seed
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        //Throw the di
        int throwIterations = 1;
	    for(int i=0;i<6;i++){
            throwIterations*=10;
            float[] results = throwIt(throwIterations, rnd);
            System.out.println(throwIterations+printBuffer(i)+
                    String.format("%5.2f", results[0])+"% "+
                    String.format("%5.2f", results[1])+"% "+
                    String.format("%5.2f", results[2])+"% "+
                    String.format("%5.2f", results[3])+"% "+
                    String.format("%5.2f", results[4])+"% "+
                    String.format("%5.2f", results[5])+"%");
        }
    }
    public static float[] throwIt(int iterations, Random rnd){
        /**
         * Returns an array of percentages detailing the distribution
         * of results from throwing a di a certain number of times.
         * The results being returned are formatted for the output.
         *
         * @param iterations number of times to throw the di
         * @param rnd Random number generator that is already seeded
         * @return Array of percentages showing distribution of di throws
         */
        float[] diResults = new float[6];
        int i;
        for(int k=0;k<iterations;k++){
            i = rnd.nextInt(6);
            diResults[i]++;
        }
        for(int j=0;j<6;j++){
            diResults[j]/=iterations;
            diResults[j]*=100;
        }
        return diResults;
    }
    public static String printBuffer(int i){
        /**
         * Returns a string that acts as a space buffer for display purposes
         *
         * @param i Reduces buffer by i spaces
         * @return String that consists of 9-i spaces
         */
        String buffer = "";
        for(int u=0;u<9-i;u++)
            buffer+=" ";
        return buffer;
    }
}