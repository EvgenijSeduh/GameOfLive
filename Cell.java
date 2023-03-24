import java.awt.*;

public class Cell {
    private boolean status = false;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean newStatus) {
        status = newStatus;
    }

    public void drawCeil(Graphics g, int i, int j, int size) {
        //g.setColor(Color.BLACK);
        //g.drawRect(j, i, size, size);
        if (status) {
            g.setColor(Color.BLUE);
            //g.fillRect(j + 1, i + 1, size - 2, size - 2);
        }
        else{
            g.setColor(Color.WHITE);
        }
        g.fillRect(j+1,i+1,size-2,size-2);

    }
}
