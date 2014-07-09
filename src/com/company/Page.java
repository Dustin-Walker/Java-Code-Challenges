package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by User on 7/8/2014.
 * Represents HTML page.
 */
public class Page {

    private static String header = "<!DOCTYPE html><html><head><title></title></head>";
    private String body;

    public Page(String inputParagraph){
        this.body = "<body><p>"+inputParagraph+"</p></body></html>";
    }

    public String constructPageToString(){
        return header+body;
    }

    public void savePageToHTMLFile(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.print(constructPageToString());
        writer.close();
    }



}
