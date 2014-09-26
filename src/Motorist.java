import java.util.ArrayList;

/**
 * Created by User on 9/25/2014.
 */
public class Motorist {


    //Class members are all private.
    //Once a motorist objected is initialized, the data should only be accessed
    //via the averageSpeed function.
    private String licensePlate;
    private ArrayList<Double> vehiclePositionList = new ArrayList<Double>();
    private ArrayList<Float> vehicleTimeList = new ArrayList<Float>();
    public ArrayList<Double> averageSpeedList = new ArrayList<Double>();

    //Class constructor
    public Motorist(Double p1, String t1, String licensePlate) {
        vehiclePositionList.add(p1);
        this.addTime(t1);
        this.licensePlate = licensePlate;
    }
    //Class methods

    private float parseTime(String time) {
        //Convert string time to float time
        //regex split along ':'
        String[] temp = time.split("[:]");
        float returnTime=0;//represents milliseconds
        //parse here and return returnTime
        returnTime += Float.parseFloat(temp[2]);
        returnTime += 60*Float.parseFloat(temp[1]);
        returnTime += 60*60*Float.parseFloat(temp[0]);
        return returnTime;
    }

    public void addPosition(Double position) {
        vehiclePositionList.add(position);
    }

    public void addTime(String time){
        vehicleTimeList.add(parseTime(time));
    }

    public void calculateAverageSpeeds(){
        if(vehicleTimeList.size()>1){
            for(int i=1;i<vehicleTimeList.size();i++){
                double deltaX = Math.abs(vehiclePositionList.get(i)-vehiclePositionList.get(i-1));
                float deltaT = Math.abs((float) ((vehicleTimeList.get(i)-vehicleTimeList.get(i-1))));
                averageSpeedList.add((deltaX)/(deltaT));
            }
        }
        int e=1;
        for(Double f: averageSpeedList){
            System.out.println("Average speed #"+e+": "+f);
            e++;
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
