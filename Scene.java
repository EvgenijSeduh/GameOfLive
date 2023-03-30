import javax.swing.*;
import java.awt.*;

public class Scene extends JFrame {
    public static final int WIDTH = 400, HEIGHT = 400;
    private Plane p1;

    public Scene(Plane p1) {
        this.setSize(p1.getWidth()*20+80,p1.getHeight()*20+80);
        this.setTitle("Game of Live");
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        getContentPane().setBackground(new Color(50,50,50));

        this.p1 = p1;
    }

    public int getWidth(){
        return this.getSize().width;
    }

    public int getHeight(){
        return this.getSize().height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int sizeCell = Math.min((getSize().width/p1.getWidth()),(getSize().height/p1.getHeight()));
        g.translate(((getSize().width/2)-(p1.getWidth()*sizeCell/2)),((getSize().height/2)-(p1.getHeight())*sizeCell/2));
        p1.drawPlane(g,getWidth(),getHeight(), sizeCell);
    }
}
