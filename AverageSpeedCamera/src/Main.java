import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner fileScanner;
        float speedLimit = 0;
        boolean measurementSystem = false;
        try {
            fileScanner = new Scanner(new FileReader("sample1.in"));
            String[] line;
            ArrayList<Double> cameraPositions = new ArrayList<Double>();
            Hashtable<String, Motorist> motoristList = new Hashtable<String, Motorist>();
            if(fileScanner.hasNextLine()) {
                line = fileScanner.nextLine().split("[\\s]");
                measurementSystem = !line[4].equals("mph.");
                speedLimit = Float.parseFloat(line[3]);
            }
            while(fileScanner.hasNextLine()){
                line = fileScanner.nextLine().split("[\\s]");
                //Camera position case
                if(line[0].equals("Speed")) {
                    cameraPositions.add(Integer.parseInt(line[3])-1, (double) Integer.parseInt(line[5]));
                } else
                //Vehicle passes camera case
                if(line[0].equals("Vehicle")){
                    String licensePlateNumber = line[1]+line[2];
                    if(motoristList.containsKey(licensePlateNumber)){
                        //Motorist has passed a camera before.
                        Motorist temp = motoristList.get(licensePlateNumber);
                        temp.addPosition(cameraPositions.get(Integer.parseInt(line[5])-1));
                        temp.addTime(line[7]);
                    } else {
                        //Motorist has not passed a camera yet.
                        Motorist temp = new Motorist(cameraPositions.get(Integer.parseInt(line[5])-1), line[7],
                             licensePlateNumber);
                        motoristList.put(licensePlateNumber, temp);
                    }
                }
            }
            for(String s: motoristList.keySet()){
                Motorist temp = motoristList.get(s);
                temp.calculateAverageSpeeds();
                for(Double d: temp.averageSpeedList)
                    if (isSpeeding(speedLimit, d))
                        System.out.println("Vehicle " + s + " broke the speed limit by " +
                                String.format("%.1f", Math.abs(speedLimit - d * 2.23694))+" mph.");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method prints the position of all cameras.
     * This was for testing purposes.
     */
    public static void printCameraPositions(ArrayList<Double> cameraPositions){
        int e=1;
        for(Double i:cameraPositions){
            System.out.println("Speed camera number "+e+" is "+i+" meters down the road.");
            e++;
        }
    }

    /**
     * This method can be used to determine if a motorist was speeding.
     */
    public static boolean isSpeeding(float speedLimit, Double vehicleSpeed){
        vehicleSpeed*=2.23694;
        return vehicleSpeed > speedLimit;
    }
}
