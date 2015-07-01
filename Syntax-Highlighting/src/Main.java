import java.io.File;

public class Main {

    public static void main(String[] args) {
	    /*
	    TODO Handle bug in string literals with \" character
	    TODO Handle class fields
	    */
        String fileName = "BST.java";
        File file = new File("content/"+fileName);
        HTMLFrame frame = new HTMLFrame();
        JavaHTML javaProcessor = new JavaHTML(file);
        frame.constructBody(javaProcessor.fileToHTML());
        frame.saveHTMLFile(fileName+".html");
        JavaCSS javaCSS = new JavaCSS(fileName+".css");
        javaCSS.constructCSSFile();
    }
}
