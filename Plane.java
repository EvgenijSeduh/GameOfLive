import java.awt.*;
import java.util.ArrayList;

public class Plane {
    private int height;
    private int width;
    private Cell[][] plane;
    //private ArrayList<boolean[][]> cache = new ArrayList<boolean[][]>();

    public Plane(int height, int width) {
        this.width = width;
        this.height = height;
        this.plane = new Cell[this.height][this.width];
        clearPlane();
    }

    public void clearPlane() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                plane[i][j] = new Cell();
                //plane[i][j] = plane[i][j].setStatus(false);
            }
        }
    }

    public boolean[][] getColony() {
        boolean[][] res = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = plane[i][j].getStatus();
            }
        }
        return res;
    }

    public void setNewPlane(boolean[][] arr) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                plane[i][j].setStatus(arr[i][j]);
            }
        }
    }

    public void move() {
        boolean[][] mem = getColony();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (regionVerification(i, j) == 3) {
                    mem[i][j] = true;
                } else if ((regionVerification(i, j) == 2) && (this.plane[i][j].getStatus()) == true) {
                    mem[i][j] = true;
                } else {
                    mem[i][j] = false;
                }
            }
        }
        setNewPlane(mem);
    }

    private int regionVerification(int iPosition, int jPosition) {
        int count = 0;
        for (int i = (iPosition - 1); i <= (iPosition + 1); i++) {
            for (int j = (jPosition - 1); j <= (jPosition + 1); j++) {
                if ((i != iPosition) || (j != jPosition)) {
                    if (((i >= 0) && (i < height)) && ((j >= 0) && (j < width))) {
                        if (plane[i][j].getStatus()) {
                            count++;
                        }
                    } else {

                        int mem_i = i;
                        int mem_j = j;

                        if (i < 0) {
                            mem_i = height - 1;
                        } else if (i >= height) {
                            mem_i = 0;
                        }
                        if (j < 0) {
                            mem_j = width - 1;
                        } else if (j >= width) {
                            mem_j = 0;
                        }

                        if (plane[mem_i][mem_j].getStatus()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public void drawPlane(Graphics g, int width, int height) {
        int sizeCell = (Math.min(width,height) - 80) / Math.max(this.width, this.height);
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                plane[i][j].drawCeil(g, i * sizeCell, j * sizeCell, sizeCell);
            }
        }
    }

    public void info() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (plane[i][j].getStatus() == true)
                    System.out.print("+ ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    public Cell getCell(int i, int j) {
        return plane[i][j];
    }

    public boolean IsThereLife() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (plane[i][j].getStatus() == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void GameOver(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("EVERYONE IS DEAD", (Scene.WIDTH - 80) / 2, Scene.HEIGHT / 2);
    }

    public boolean setColonyWithCheck(boolean[][] colony) {
        if (colony != null) {
            if (colony.length == colony[0].length) {
                if ((colony.length <= height) && (colony[0].length <= width)) {
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            plane[i][j].setStatus(colony[i][j]);
                        }
                        return true;
                    }
                } else
                    System.out.println("Массив больше размера поля");
            } else
                System.out.println("Высота и ширина массива должны совпадать");
        } else
            System.out.println("Массив пустой");
        return false;
    }

    public void setColony(int iColony, int jColony, boolean[][] colony) {
        if ((colony.length <= height) && (colony[0].length <= width)) {
            if ((iColony >= 0) && (iColony <= height) && (jColony >= 0) && (jColony <= width)) {
                for (int i = 0; i < colony.length; i++) {
                    for (int j = 0; j < colony[0].length; j++) {
                        if (iColony >= height) {
                            iColony = 0;
                        }
                        if (iColony < 0) {
                            iColony = height--;
                        }
                        if (jColony >= width) {
                            jColony = 0;
                        }
                        if (jColony < 0) {
                            jColony = width--;
                        }
                        plane[iColony + i][jColony + j].setStatus(colony[i][j]);
                    }
                }
            } else
                System.out.println("Координаты должны входить в промежуток от 0 до " + width + " x " + height);

        } else
            System.out.println("Размер массива не должен превышать рамеры поля(" + height + " x " + width + ")");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getMinSize(){
        return Math.min(width,height);
    }
}