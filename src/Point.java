/**
 * Created by User on 9/3/2014.
 * This class represents a point such as (x,y) on a Cartesian coordinate plane
 */
public class Point {

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void translate(float changeX, float changeY){
        this.x += changeX;
        this.y += changeY;
    }

    public void rotate(float pivotPointX, float pivotPointY, float rotationAngle){
        //Step 1: Set up new point so I can rotate around origin
        float tmpX = this.x-pivotPointX;
        float tmpY = this.y-pivotPointY;

        //Step 2: Rotation
        float tmpX2 = (float) (tmpX*Math.cos(rotationAngle)-tmpY*Math.sin(rotationAngle));
        float tmpY2 = (float) (tmpX*Math.sin(rotationAngle)-tmpY*Math.cos(rotationAngle));

        //Step 3: Move point back
        this.x = tmpX2+pivotPointX;
        this.y = tmpY2+pivotPointY;
    }

    public void scale(){

    }

    public void reflect(){

    }
}
