import java.util.ArrayList;

/**
 * Created by User on 9/25/2014.
 */
public class Motorist {


    //Class members are all private.
    private String licensePlate;
    private ArrayList<Double> vehiclePositionList = new ArrayList<Double>();
    private ArrayList<Float> vehicleTimeList = new ArrayList<Float>();
    public ArrayList<Double> averageSpeedList = new ArrayList<Double>();

    /**
     * This is the only class constructor that should be used.
     * This constructor should be used when a vehicle first passes a camera.
     * @param p1 Position of vehicle when first passing the camera
     * @param t1 Time when vehicle first passing the camera
     * @param licensePlate Vehicle license plate and object identifier
     */
    public Motorist(Double p1, String t1, String licensePlate) {
        vehiclePositionList.add(p1);
        this.addTime(t1);
        this.licensePlate = licensePlate;
    }

    /**
     * Converts a string representing time in
     * the format "hours:minutes:seconds" into
     * a float representing total seconds.
     *
     * @param time time to be parsed
     * @return total seconds in time
     */
    private float parseTime(String time) {
        String[] temp = time.split("[:]");
        float returnTime=0;//represents milliseconds
        //parse here and return returnTime
        returnTime += Float.parseFloat(temp[2]);
        returnTime += 60*Float.parseFloat(temp[1]);
        returnTime += 60*60*Float.parseFloat(temp[0]);
        return returnTime;
    }

    /**
     * @param position Value to be stored locally
     */
    public void addPosition(Double position) {
        vehiclePositionList.add(position);
    }

    /**
     * @param time Value to be stored locally
     */
    public void addTime(String time){
        vehicleTimeList.add(parseTime(time));
    }

    /**
     * This method calculates all of the average speeds
     * between every position the motorist has passed.
     * All values are stored in an arrayList.
     */
    public void calculateAverageSpeeds(){
        if(vehicleTimeList.size()>1){
            for(int i=1;i<vehicleTimeList.size();i++){
                double deltaX = Math.abs(vehiclePositionList.get(i)-vehiclePositionList.get(i-1));
                float deltaT = Math.abs((float) ((vehicleTimeList.get(i)-vehicleTimeList.get(i-1))));
                averageSpeedList.add((deltaX)/(deltaT));
            }
        }
    }

    @Override
    public String toString(){
        System.out.println("Vehicle "+licensePlate);
        int e=1;
        for(float f: vehicleTimeList) {
            System.out.println("time #" + e +": "+ f);
            e++;
        }
        e=1;
        for(Double f: vehiclePositionList) {
            System.out.println("position #" + e +": "+ f);
            e++;
        }
        calculateAverageSpeeds();
        System.out.println();
        return null;
    }
}
