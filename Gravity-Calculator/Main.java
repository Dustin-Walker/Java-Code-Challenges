package com.company;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Read the file in through standard input
        Scanner fileScanner = null;
        try {
            //fileScanner = new Scanner(new FileReader("C:\\Programming\\Gravity Calculator\\sample2.in"));
            fileScanner = new Scanner(System.in);
            float mass1 = fileScanner.nextFloat(), tempForce;
            int numberOfLines = fileScanner.nextInt();
            Planet tempPlanet = new Planet();
            fileScanner.nextLine();
            for (int i = 0; i < numberOfLines; i++) {
                //Each line contains name, radius, density
                String[] line = fileScanner.nextLine().split(", ");
                tempPlanet.setName(line[0]);
                tempPlanet.setRadius(Float.parseFloat(line[1]));
                tempPlanet.setDensity(Float.parseFloat(line[2]));
                tempPlanet.setVolume(tempPlanet.getRadius());
                tempPlanet.setMass(tempPlanet.getVolume(), tempPlanet.getDensity());
                tempForce = tempPlanet.calcForce(mass1, tempPlanet.getMass(), tempPlanet.getRadius());
                System.out.println(tempPlanet.getName()+": "+String.format("%6.3f", tempForce));
            }
        } finally {
            if (fileScanner != null) fileScanner.close();
            else System.out.println("FileScanner not open");
        }
    }
}

