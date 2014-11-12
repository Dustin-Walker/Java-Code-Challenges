import java.io.File;

public class Main {

    public static void main(String[] args) {
	    /*
	    TODO Handle string literals
	    TODO Handle class fields
	    */

        File file = new File("content/SmartStackList.java");
        HTMLFrame frame = new HTMLFrame();
        JavaHTML javaProcessor = new JavaHTML(file);
        frame.constructBody(javaProcessor.fileToHTML());
        frame.saveHTMLFile("test.html");
        JavaCSS javaCSS = new JavaCSS("test.css");
        javaCSS.constructCSSFile();
    }
}
