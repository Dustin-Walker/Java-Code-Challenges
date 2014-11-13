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

    /**
     * Class fields
     * inputFile is the java class file to be manipulated
     * stringLiteral is a boolean to assist in marking string literals
     */
    File inputFile;
    boolean stringLiteral = false;

    /**
     * This is a list of all the keywords in Java.
     * Source: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
     */
    String[] keywordList = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "imports", "instanceof", "int ", "interface", "long", "native",
            "new ", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    /**
     * This method breaks the file down into strings which can be further manipulated.
     * @return Converts the file into a string to be manipulated
     */
    public String fileToHTML(){
        String returnString = "";
        try {
            Scanner sc = new Scanner(inputFile);
            int i=1;
            while(sc.hasNextLine())
            {
                String fileString = sc.nextLine();
                fileString = replaceBrackets(fileString);
                fileString = keywordCheck(fileString);
                fileString = commentMarker(fileString);
                fileString = stringLiteralMarker(fileString);
                fileString = ("<span class=\"comment\">" + String.format("%3d",(i++)) + "|</span> " + fileString);
                returnString += fileString+"\n";
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

    /**
     * Marks sections of the code as comments and applies relevant CSS code.
     * @param line String to be processed
     * @return String with comments marked
     */
    private String commentMarker(String line){
        String returnString=line;
        if(returnString.contains("//")){
            returnString = returnString.replace("//", "<span class=\"comment\">//");
            return returnString+="</span>";
        }
        if(returnString.contains("/*")){
            returnString = returnString.replace("/*", "<span class=\"comment\">/*");
        }
        if(returnString.contains("*/")){
            returnString = returnString.replace("*/", "*/</span>");
        }
        return returnString;
    }

    /**
     * Replaces < and > with appropriate HTML friendly code.
     * @param line String to be processed
     * @return String with brackets replaced
     */
    private String replaceBrackets(String line){
        String returnString=line;
        if(line.contains("<")){
            returnString = returnString.replace("<", "&lt;");
        }
        if(line.contains(">")){
            returnString = returnString.replace("<", "&gt;");
        }
        return returnString;
    }

    /**
     * Marks string literals for appropriate CSS
     * @param line String to be processed
     * @return String with string literals marked with a CSS tag
     */
    private String stringLiteralMarker(String line){
        String sb = line;
        if(line.contains("\"")) {
            stringLiteral=false;
            String[] splitLine = line.split("\"");
            for (int i = 0, splitLineLength = splitLine.length; i < splitLineLength; i++) {
                String s = splitLine[i];
                if(s.length()>0 && s.charAt(s.length()-1)=='\\'){
                    s +="\""+s; continue;
                }
                if(s.contains("<span class=") || s.equals("keyword") || s.equals("comment")
                        /*|| s.length()>0
                        && s.charAt(s.length()-1)=='\\'*/
                        ){
                    continue;}

                if (stringLiteral) {
                    s = "<span class=\"stringLiteral\">\"" + s + "\"</span>";
                    splitLine[i] = s;
                    stringLiteral = false;
                } else {
                    stringLiteral = true;
                }
            }
            sb="";
            for(String s : splitLine)
                sb+=s;
        }
        return sb;
    }

}