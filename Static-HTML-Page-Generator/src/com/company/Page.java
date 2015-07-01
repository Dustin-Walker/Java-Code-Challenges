package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by User on 7/8/2014.
 * Represents HTML page.
 */
public class Page {

    private final String HEADER = "<!DOCTYPE html><html><head><title></title></head>";
    private String body;

    public Page(String inputParagraph){
        this.body = "<body><p>"+inputParagraph+"</p></body></html>";
    }

    public String constructPageToString(){
        return HEADER+body;
    }

    public void savePageToHTMLFile(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        /**
         * Saves the page object to an HTML file.
         * To do: Check to see if user added .html extension, add if not.
         * @param fileName File name to be used for the HTML file being created
         */
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.print(constructPageToString());
        writer.close();
    }



}
