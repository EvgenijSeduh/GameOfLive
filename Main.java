import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner in = new Scanner(System.in);
        HashArray history = new HashArray();

        System.out.println("Размер поля: ");
        Plane plane = new Plane(in.nextInt(), in.nextInt());//(in.nextInt(),in.nextInt());

        Scene s1 = new Scene(plane);

        FileManager reader = new FileManager();//Проблемма в том что после того когда мы узнаем кол-во строк то курсор в Scanner остаётся в конце, нужно все данные записать String[] и работать с массивом
        System.out.println("Введите путь к файлу: ");//C:\Users\Пользователь\Desktop\testPlane.txt
        String path = in.next();
        //FileReader fr = new FileReader("");
        FileReader fr = null;
        while (true) {
            try {
                fr = new FileReader(path);
                break;
            } catch (Exception e) {
                System.out.println("Файл не найден, введите путь повторно:");
            }
        }

        System.out.println("Введите координаты куда разместить поле: ");
        boolean[][] arr = reader.fileInArray(fr);
        plane.setColony(in.nextInt() - 1, in.nextInt() - 1, arr);


        fr.close();


//        s1.repaint();
//        Thread.sleep(2000);
        while (plane.IsThereLife() && history.checkUniqueness()) {
            history.add(plane.getColony());
            s1.repaint();
            plane.move();
            System.out.println("хуй");
            Thread.sleep(100);
        }
        s1.gameOver();


    }
}