import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by Dustin Walker on 10/28/2014 at 11:46.
 * This class handles the conversion of Java into HTML.
 */
public class JavaHTML {

    /**
     * Main constructor that takes in the file to be manipulated
     * @param file File to be processed for syntax highlighting
     */
    public JavaHTML(File file){
        this.inputFile = file;
    }

    File inputFile;

    /**
     * This method breaks the file down into strings which can be further manipulated.
     * @return Converts the file into a string to be manipulated
     */
    public String fileToString(){
        String returnString = "";
        try {
            Scanner sc = new Scanner(inputFile);
            while(sc.hasNextLine())
            {
                String fileString = sc.nextLine();
                if(fileString.contains("private")){
                    fileString = fileString.replace("private", "<span class=\"keyword\">private</span>");
                }
                returnString += "<p>" + fileString + "</p>";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnString;
    }



}
