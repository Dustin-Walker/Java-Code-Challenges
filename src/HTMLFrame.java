import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dustin Walker on 10/28/2014 at 11:43.
 * LINK - link to the program description
 * Syntax Highlighting program description
 */
public class HTMLFrame {

    private final String HEADER = "<!DOCTYPE html><html><head><link rel=\"stylesheet\" type =\"text/css\" href=\"test.css\"><title></title></head>";
    private String body;

    public void constructBody(String bodyText){
        this.body = "<body>"+bodyText+"</body></html>";
    }

    private String constructPage(){
        return HEADER+body;
    }

    /**
     * This method creates the HTML file.
     * @param fileName Name of file to be created
     */
    public void saveHTMLFile(String fileName){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            writer.print(constructPage());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
