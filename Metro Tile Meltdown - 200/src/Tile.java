/**
 * Created by Dustin Walker on 2/25/2015 at 19:02.
 * Tile class file
 */
public class Tile {

    private int height, width, positionX, positionY;
    private char charValue;

    public Tile(int positionY, int positionX, char charValue){
        setPositionX(positionX);
        setPositionY(positionY);
        setCharValue(charValue);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getCharValue() {
        return charValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }
}
