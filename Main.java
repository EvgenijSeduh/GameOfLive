import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner in = new Scanner(System.in);
        HashArray history = new HashArray();

        System.out.println("Размер поля: ");
        Plane plane = null;

        try {
            plane = new Plane(in.nextInt(), in.nextInt());
        }catch (Exception e){
            System.out.println("Недопустимые знвчения");
            System.exit(0);
        }

        Scene s1 = new Scene(plane);

        FileManager reader = new FileManager();
        System.out.println("Введите путь к файлу: ");//C:\Users\Пользователь\Desktop\testPlane.txt
        String path = in.next();
        //FileReader fr = new FileReader("");
        FileReader fr = null;
        try {
            fr = new FileReader(path);
        } catch (Exception e) {
            System.out.println("Файл не найден");
            System.exit(0);
        }

        System.out.println("Введите координаты куда разместить поле: ");
        plane.setColony(in.nextInt() - 1, in.nextInt() - 1, reader.fileInArray(fr));

        fr.close();

        while (plane.IsThereLife() && history.checkUniqueness()) {
            history.add(HashArray.hashCode(plane.getColony()));
            s1.repaint();
            plane.move();
            Thread.sleep(150);
        }
        System.out.println("Game Over");
        System.exit(0);
    }
}