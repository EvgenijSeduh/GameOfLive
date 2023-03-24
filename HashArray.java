import com.sun.crypto.provider.GCM;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HashArray extends ArrayList<boolean[][]> {
        public boolean checkUniqueness() {
            if (size() == 1) {
                for (int i = 0; i < size()-1; i++) {
                    if (comparison((get(size() - 1)), get(i))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean comparison(boolean[][] arr1, boolean[][] arr2){
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[0].length; j++) {
                    if(arr1[i][j]!=arr2[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }

}
