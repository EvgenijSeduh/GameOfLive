import javax.swing.*;
import java.awt.*;

public class Scene extends JFrame {
    public static final int WIDTH = 400, HEIGHT = 400;
    private Plane p1;

    public Scene(Plane p1) {
        this.setSize(WIDTH, HEIGHT);
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
        //g.translate(40, 40);
        //this.setSize(this.getSize().width,this.getSize().width);
        int size = Math.min(getSize().width,getSize().height);
        g.translate(this.getSize().width/2-(((this.getSize().width- 80) / p1.getMinSize()) * (p1.getMinSize()/2)), this.getSize().height/2-(((this.getSize().height - 80)/ (p1.getMinSize()))* (p1.getMinSize()/2)));

        p1.drawPlane(g,getWidth(),getHeight());
    }

    public void gameOver(){
        System.exit(0);
    }

}
