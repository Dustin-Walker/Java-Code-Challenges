/**
 * Created by user on 12/4/15.
 */
public class Point {
    private float x;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float y;

    public Point(float x, float y){
        this.x = x; this.y = y;
    }
}
