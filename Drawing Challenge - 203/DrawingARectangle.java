import javax.swing.*;
import java.awt.*;
public class DrawingARectangle {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                Joins js = new Joins();
                js.setVisible(true);
            }
        });
    }
}

class Surface extends JPanel{
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke basicStroke = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(basicStroke);
        g2d.drawRect(50,50,300,500);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
}

class Joins extends JFrame{
    public Joins(){
        initialize();
    }

    private void initialize(){
        setTitle("Drawing a Rectangle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Surface());
        setSize(600,600);
        setLocationRelativeTo(null);
    }
}