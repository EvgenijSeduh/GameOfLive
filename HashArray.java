import com.sun.crypto.provider.GCM;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HashArray extends ArrayList<Long> {

    public boolean checkUniqueness() {
        if (size() == 1 || isEmpty()||indexOf(get(size()-1))==size()-1)
            return true;
        return false;
    }

    public static long hashCode(boolean[][] arr) {
        int res = 0;
        int live = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    live++;
                    if ((i % 2 == 0) && (j % 2 == 0)) {
                        res += (i + j + 2) * 5;
                    } else if ((i % 2 == 1) && (j % 2 == 0)) {
                        res += ((i + 1) * 7) + j + 1;
                    } else if ((i % 2 == 0) && (j % 2 == 1)) {
                        res += i + 1 + ((j + 1) * 11);
                    } else {
                        res += (i + j + 1) * 13;
                    }
                    res *= 19;
                }
            }
        }
        return res - live;
    }

}
