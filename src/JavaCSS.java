import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dustin Walker on 10/28/2014 at 11:58.
 * This class creates the CSS file for java.
 */
public class JavaCSS {

    public JavaCSS(String fileName){
        this.fileName = fileName;
    }

    String fileName;

    public final String keywordCSS = ".keyword{color:blue}";

    public void constructCSSFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            writer.print(keywordCSS);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
