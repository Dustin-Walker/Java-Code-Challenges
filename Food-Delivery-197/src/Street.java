/**
 * Created by Dustin Walker.
 * Every street connects 2 intersections and allows traffic in both directions. Represents an edge.
 * FoodDelivery program description
 */
public class Street {

    private Intersection intersection1, intersection2;
    private String name = "undefined";
    private int[] timeList = new int[4];

    private void setTimes(int[] timeList){
        System.arraycopy(timeList, 0, this.timeList, 0, 4);
    }

    public String getName() {
        return name;
    }

    public int getTime(int currentTime){
        assert currentTime>=0;
        if(currentTime > 600 && currentTime <= 1000) return timeList[0];
        if(currentTime > 1000 && currentTime <= 1500) return timeList[1];
        if(currentTime > 1500 && currentTime <= 1900) return timeList[2];
        if(currentTime > 1900 || currentTime <= 600) return timeList[3];
        return Integer.MAX_VALUE;
    }

    public Street(String name, int[] timeList, Intersection intersection1, Intersection intersection2){
        this.intersection1=intersection1;
        this.intersection2=intersection2;
        this.name = name;
        setTimes(timeList);
    }

    public Intersection[] getIntersections(){
        return new Intersection[]{intersection1, intersection2};
    }
}
