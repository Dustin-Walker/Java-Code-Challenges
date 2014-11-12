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

    public final String keywordCSS =
            ".keyword{\n    color:blue;\n}\n";

    public final String bodyCSS="body{\n    font-family: Roboto, sans-serif;" +
            "\n    background-color: rgba(0, 0, 0, 0.12);" +
            "\n    font-size: small;\n}";

    public final String commentCSS=".comment{\ncolor:rgba(0, 0, 0, 0.50);\n}\n";

    public void constructCSSFile(){
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            writer.println(keywordCSS);
            writer.println(bodyCSS);
            writer.println(commentCSS);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
