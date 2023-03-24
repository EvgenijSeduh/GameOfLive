//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.ArrayList;
//
//abstract class Hash extends MessageDigest {
//
//MessageDigest hash = MessageDigest.getInstance("SHA-256");
//
//    Hash() throws NoSuchAlgorithmException {
//    }
//    public static int simpleHash(boolean[][] arr) {
//        short countA = 0;
//        short countB = 0;
//        short count = 0;
//        short hashA = 0;
//        short hashB = 0;
//        short controlSumm = 0;
//        for (short i = 0; i < arr.length; i++) {
//            short j = 0;
//            for (; j < arr[0].length; j++) {
//                if (arr[i][j]) {
//                    countA++;
//                    count++;
//                }
//            }
//            hashA += (short) (countA * j - i);
//            controlSumm = count;
//        }
//        for (short j = 0; j < arr[0].length; j++) {
//            short i = 0;
//            for (; i < arr.length; i++) {
//                if (arr[i][j])
//                    countB++;
//            }
//            hashB += (short) (countB * i - j);
//        }
//        return (int) ((hashA * 10000) - (hashB * 100) + controlSumm);
//    }
//}
