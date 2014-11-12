import java.io.File;
import java.io.FileNotFoundException;
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
     * This is a list of all the keywords in Java.
     * Source: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
     */
    String[] keywordList = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "imports", "instanceof", "int ", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    /**
     * This method breaks the file down into strings which can be further manipulated.
     * @return Converts the file into a string to be manipulated
     */
    public String fileToHTML(){
        String returnString = "";
        try {
            Scanner sc = new Scanner(inputFile);
            while(sc.hasNextLine())
            {
                String fileString = sc.nextLine();
                fileString = keywordCheck(fileString);
                returnString += "<p>" + fileString + "</p>";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnString;
    }

    /**
     * This method checks for the presence of Java keywords in a line and highlights found keywords.
     * @param line String to be processed
     * @return String with added CSS keyword class modifications
     */
    private String keywordCheck(String line){
        String returnString=line;
        for(String keyword:keywordList)
            returnString = returnString.replace(keyword, "<span class=\"keyword\">" + keyword + "</span>");
        return returnString;
    }

}
