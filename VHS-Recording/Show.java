/**
 * Created by user on 12/17/15.
 */
public class Show {

    private int startTime, endTime;

    public String getTitle() {
        return title;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    private String title;

    public Show(int startTime, int endTime, String title){
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }

    public Show(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = "Unknown";
    }

}
