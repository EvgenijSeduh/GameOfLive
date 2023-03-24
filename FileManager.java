import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FileManager {
    private int numberOfLines(Scanner s) {
        int i = 0;
        while (s.hasNextLine()) {
            s.nextLine();
            i++;
        }
        return i;
    }

    private boolean checkFile(ArrayList<String> list) {
        int lines = list.size();
        for (int i = 0; i < lines; i++) {
             list.set(i,list.get(i).replace(" ", ""));
             char[] str = list.get(i).toCharArray();
            if ((str.length!= lines)) {
                System.out.println("В файле должны совпадать высота и ширина");
                return false;
            } else {
                for(int j = 0;j<list.size();j++){
                    if((str[j]!='0')&&(str[j]!='1')){
                        System.out.println("В файле не должно присутствовать символов помимо 1 и 0");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean[][] ArrStrInArrBool(ArrayList<String> list) {
        if(checkFile(list)) {
            boolean[][] result = new boolean[list.size()][list.size()];
            for(int i = 0;i < list.size();i++) {
                char[] arrChar = list.get(i).toCharArray();
                for (int j = 0; j < arrChar.length; j++) {
                    if(list.get(i).charAt(j) == '1')
                        result[i][j] =true;
                    else
                        result[i][j] = false;
                    //result[i][j] = Boolean.parseBoolean(String.valueOf(arrChar[j]));
                }
            }
            return result;
        }
        return null;
    }

    public void infoArr(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j])
                    System.out.println("+ ");
                else
                    System.out.println(". ");
            }
            System.out.println();
        }
    }

    public void infoFile(Scanner s) {
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(str);
        }
    }
    public boolean[][] fileInArray(FileReader fr){
        Scanner s = new Scanner(fr);
        s = new Scanner(fr);
        ArrayList<String> arrResult = new ArrayList<String>();
        while(s.hasNextLine()){
            arrResult.add(s.nextLine());
        }
        return ArrStrInArrBool(arrResult);
    }
}