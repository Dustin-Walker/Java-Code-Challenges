import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dustin Walker on 2/25/2015 at 18:30.
 * MetroTileMeltdown
 */
public class ScreenMap {

    private final int BORDER_VALUE = 46;
    private final int NULL_VALUE = 0;

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

    private int height, width;

    private int[][] mapLayout;

    private HashMap<Integer, Tile> tileList = new HashMap<Integer, Tile>();

    public ScreenMap(int height, int width){
        setHeight(height);
        setWidth(width);
        mapLayout = new int[height][width];
    }

    public void readFile(Path file) throws IOException {
        List<String> stringList = Files.readAllLines(file);
        String line = stringList.remove(0);
        for(int h = 0, w = 0; !stringList.isEmpty() ;h++,w=0, line=stringList.remove(0)){
            for(char c : line.toCharArray())
                this.mapLayout[h][w++] = (int)c;
        }
        lookForTiles();
    }

    /**
     * This method looks for tiles in the matrix.
     */
    private void lookForTiles(){
        int initialW = 0, initialH = 0;
        for(int h = 0,w = 0; h < height; h++, w = 0){
            for(;w<width;w++){
                if(mapLayout[h][w]== BORDER_VALUE || mapLayout[h][w]== NULL_VALUE )
                    continue;
                else{
                    if(tileList.keySet().contains(mapLayout[h][w]))
                        continue;
                    else{
                        initialW = w; initialH = h;
                        tileList.put(mapLayout[h][w], new Tile(h, w, (char) mapLayout[h][w]));
                        while(w<width && h<height && mapLayout[h][w]==mapLayout[h][w+1])
                            w++;
                        tileList.get(mapLayout[h][w]).setWidth(w-initialW+1);
                        while(mapLayout[h][w]==mapLayout[h+1][w])
                            h++;
                        tileList.get(mapLayout[h][w]).setHeight(h-initialH+1);
                    }
                    h = initialH;
                }
            }
        }
    }

    public void printTileList(){
        for(Tile tile : tileList.values())
            System.out.println(tile.getWidth()+"x"+tile.getHeight()+
                    " tile of character \'"+tile.getCharValue()+
                    "\' located at ("+tile.getPositionX()+","+tile.getPositionY()+")");
    }



}
