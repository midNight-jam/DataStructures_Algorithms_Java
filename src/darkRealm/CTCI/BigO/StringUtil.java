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

    /*First, this fucntion was really complex & I was not happy to have such a big function.
    Second, however it worked for many scenarios it failed insome, for eg: "Abcdedcd" gives ouptut as edc,
    where as output should have been "Abcde". thus this method is discarded.
    * */
    /*public static String maxDistinctSubString(String str) {
        str = str.toLowerCase();
        Stack<Character> stack = new Stack<>();
        boolean[] arrival = new boolean[26];
        int ai, si, ri;
        ai = si = ri = 0;
        String s1, s2;
        s1 = s2 = "";
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            ai = c - 'a';
            // if repeating char
            if (arrival[ai]) {
                // if we evalautaed already
                s2 = s1;
                s1 = "";
                ri = -1;
                //first get the string that is in stack
                for (si = 0; si < stack.size(); si++) {
                    s1 += stack.elementAt(si);
                    // use this loop to initialize the index of repeating char
                    if (stack.elementAt(si) == c) {
                        ri = si;
                    }
                }
                // now remove extra , & keep only those chars which are after the char that is repeating,
                // or iam just trying to remove those chars till repating char from stack
                for (int j = 0; j <= ri; j++) {
                    stack.remove(0);
                }
                // add the current char also to stack
                stack.push(c);
            }
            // new char, insert in stack & make arrival true
            else {
                stack.push(str.charAt(i));
                arrival[ai] = true;
            }
        }

        //after loop compare s1 with string in stack whcih is longer return that,
        String stackStr = "";
        for (int i = 0; i < stack.size(); i++) {
            stackStr += stack.elementAt(i);
        }

        // get the string with max length
        int m = s1.length();
        String result = s1;
        if (m < s2.length()) {
            result = s2;
            m = s2.length();
        }
        if (m < stackStr.length()) {
            result = stackStr;
        }

        return result;
    }*/

    public static void printAllFoundPermutations(String small, String big) {
        if (big.length() > small.length()) {

            HashMap<Character, Integer> smallChars = new HashMap<>();
            //first initialize the hashSet of small strings char
            int count;
            int wi;
            char sc, bc;
            String result="";
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

/*      //older logic that only checks for presence, but doesnt mathces
        //the exact count of each numbers
     boolean matching;
            char c;
            int w = 0;
            String result = "";
            int windowSize = small.length();

            for (int i = 0; i < big.length() - windowSize; i++) {
                matching = false;
                for (w = i; w < i + windowSize; w++) {
                    c = big.charAt(w);
                    if (smallChars.containsKey(c)) {
                        matching = true;
                    } else {
                        matching = false;
                        break;
                    }
                }
                if (w == i + windowSize && matching) {
                    result += " "+i;
                }
            }*/
            System.out.println("mathces found at : "+result);

        }
    }
}