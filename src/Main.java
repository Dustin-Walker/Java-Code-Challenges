import java.io.File;

public class Main {

    public static void main(String[] args) {
	    /*
	    TODO Add more keywords to keyword list
	    TODO Methods to handle comments and CSS
	    */

        File file = new File("content/SmartStackList.java");
        HTMLFrame frame = new HTMLFrame();
        JavaHTML javaProcessor = new JavaHTML(file);
        frame.constructBody(javaProcessor.fileToString());
        frame.saveHTMLFile("test.html");
        JavaCSS javaCSS = new JavaCSS("test.css");
        javaCSS.constructCSSFile();
    }
}
