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
    public final String bodyGithubCSS="body{\n    font-family: Roboto, sans-serif;" +
            "\n    background-color: white;" +
            "\n    font-size: small;" +
            "\n    font-color: #6e5494;\n}";

    public final String commentCSS=".comment{\ncolor:grey !important;\n}\n";

    public final String stringLiteralCSS=".stringLiteral{\ncolor:mediumvioletred;\n}\n";
    public final String stringLiteralGithubCSS=".stringLiteral{\ncolor:#df5000;\n}\n";



    public final String commentkeywordCSS=".comment .keyword{\ncolor:grey !important;\n}\n";



    public void constructCSSFile(){
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            writer.println(keywordCSS);
            writer.println(bodyCSS);
            writer.println(commentCSS);
            writer.println(commentkeywordCSS);
            writer.println(stringLiteralCSS);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            writer = new PrintWriter("javagithub.css", "UTF-8");
            writer.println(bodyGithubCSS);
            writer.println(commentCSS);
            writer.println(stringLiteralGithubCSS);
            writer.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
