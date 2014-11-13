import java.io.File;

public class Main {

    public static void main(String[] args) {
	    /*
	    TODO Handle bug in string literals with \" character
	    TODO Handle class fields
	    */

        File file = new File("content/SmartStackList.java");
        HTMLFrame frame = new HTMLFrame();
        JavaHTML javaProcessor = new JavaHTML(file);
        frame.constructBody(javaProcessor.fileToHTML());
        frame.saveHTMLFile("test3.html");
        JavaCSS javaCSS = new JavaCSS("test.css");
        javaCSS.constructCSSFile();
    }
}
