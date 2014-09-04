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
        float tmpX2 = (float) (tmpX*Math.cos((-1)*rotationAngle)-tmpY*Math.sin((-1)*rotationAngle));
        float tmpY2 = (float) (tmpX*Math.sin((-1)*rotationAngle)+tmpY*Math.cos((-1)*rotationAngle));

        //Step 3: Move point back
        this.x = tmpX2+pivotPointX;
        this.y = tmpY2+pivotPointY;

    }

    public void scale(float scalePointX, float scalePointY, float scaleFactor){
        float tempX = ((this.x-scalePointX)*scaleFactor)+scalePointX;
        float tempY = ((this.y-scalePointY)*scaleFactor)+scalePointY;
        this.x = tempX;
        this.y = tempY;
    }

    public void reflect(String axis){
        axis = axis.toLowerCase();
        if(axis.equals("y"))
            this.x *= -1.0;
        else
            this.y *= -1.0;
    }
}
