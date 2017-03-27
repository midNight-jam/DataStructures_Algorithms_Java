package darkRealm.CTCI.BigO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jayam on 8/24/2016.
 */
public class StringUtil {

    public static void permutation(String str) {
        permute(str, "");
    }

    public static void permute(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permute(rem, prefix + str.charAt(i));
            }
        }
    }

    public static String reverseString(String s) {
        int swapIndex = 0;
        char temp;
        char[] str = s.toCharArray();
        int strLength = s.length();
        for (int i = 0; i < strLength / 2; i++) {
            swapIndex = strLength - i - 1;
            temp = str[swapIndex];
            str[swapIndex] = str[i];
            str[i] = temp;
        }
        return String.valueOf(str);
    }


    // failing cases Abababab, Aaaaa
    public static String maxDistinctSubString(String str) {
        str = str.toLowerCase();
        boolean[] arrival = new boolean[26];
        int len = str.length();
        int tempLen = 0;
        int prevTempLen = 0;
        int distinctIndex = 0;
        char c;
        int ci = 0;
        String tempString = "";
        String result = "";
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            ci = c - 'a';
            if (arrival[ci]) {
                // take count of string
                if (tempLen > prevTempLen) {
                    prevTempLen = tempLen;
                    distinctIndex = i - tempLen;
                    arrival = new boolean[26]; // resetting the boolean array, weel this is not working
                    tempString = str.substring(distinctIndex, prevTempLen);
                    tempLen = tempLen - str.indexOf(c) - 1; // dont set it blindly to 0, ithas to also consdier the length made
                    // from last occurence, so repeatin char index + 1
                }
            }
            arrival[ci] = true;
            tempLen++;
        }
        if (tempString.length() < tempLen) {
            result = str.substring(str.length() - tempLen);
        } else {
            result = str.substring(distinctIndex, prevTempLen);
        }
        return result;
    }

    public static void printAllFoundPermutations(String small, String big) {
        if (big.length() > small.length()) {

            HashMap<Character, Integer> smallChars = new HashMap<>();
            //first initialize the hashSet of small strings char
            int count;
            int wi;
            char sc, bc;
            String result = "";
            int windowSize = small.length();
            for (int si = 0; si < small.length(); si++) {
                sc = small.charAt(si);
                if (smallChars.containsKey(sc)) {
                    count = smallChars.get(sc);
                    smallChars.put(sc, ++count);
                } else {
                    smallChars.put(sc, 1);
                }
            }

            HashMap<Character, Integer> windowHash = (HashMap<Character, Integer>) smallChars.clone();


            for (int i = 0; i < big.length() - windowSize; i++) {

                // initilaize windowhash with 0's

                for (Map.Entry<Character, Integer> entry : smallChars.entrySet()) {
                    windowHash.put(entry.getKey(), 0);
                }

                for (wi = i; wi < i + windowSize; wi++) {
                    bc = big.charAt(wi);
                    if (windowHash.containsKey(bc)) {
                        windowHash.put(bc, windowHash.get(bc) + 1);
                        if (windowHash.get(bc) > smallChars.get(bc)) {
                            break;
                        }
                    } else break;
                }

                if (wi == i + windowSize) {
                    result += " " + i;
                }
            }

            System.out.println("mathces found at : " + result);

        }
    }
}