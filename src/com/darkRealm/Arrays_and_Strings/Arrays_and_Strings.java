package com.darkRealm.Arrays_and_Strings;

import com.darkRealm.BigO.QuickSort;
import com.sun.deploy.util.ArrayUtil;

import java.util.HashMap;

/**
 * Created by Jayam on 10/2/2016.
 */
public class Arrays_and_Strings {

    /* the question mentioned not to use extra ds thats why we are not using HashMap,
       with using hash map it would be simpler, just keep pushing curent char in to hashmap, if not alreaday ther,
       if its present retun false. In below appraoch we have sorted string & then traversed it for finding duplicate
       hence excluing conversion :  S = string len,  total is O(SlogS) + O(S) === O(SlogS) */
    public static boolean IsUnique(String str) {
        int[] asciiArr = new int[str.length()];
        for (int i = 0; i < asciiArr.length; i++) {
            asciiArr[i] = (int) str.charAt(i);
        }
        QuickSort.doQuickSort(asciiArr);

        char[] charArr = new char[str.length()];
        for (int i = 0; i < asciiArr.length; i++) {
            charArr[i] = (char) asciiArr[i];
        }
        int i = 0;
        for (i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                break;
            }
        }
        return i == str.length() - 1 ? true : false;
    }

    public static boolean CheckPermutation(String str, String perm) {
        HashMap<Character, Integer> originalStrMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (originalStrMap.containsKey(str.charAt(i))) {
                int count = originalStrMap.get(str.charAt(i));
                originalStrMap.put(str.charAt(i), count + 1);
            } else {
                originalStrMap.put(str.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> permStrMap = new HashMap<>();

        for (int i = 0; i < perm.length(); i++) {
            // present in original map
            if (originalStrMap.containsKey(perm.charAt(i))) {
                // present in perm Map
                if (permStrMap.containsKey(perm.charAt(i))) {
                    // increment value
                    int permCount = permStrMap.get(perm.charAt(i));
                    permStrMap.put(perm.charAt(i), permCount + 1);
                    // if after increasing its more
                    if (permStrMap.get(perm.charAt(i)) > originalStrMap.get(perm.charAt(i))) {
                        return false;
                    }
                }
                // have to add to perm map
                else {
                    permStrMap.put(perm.charAt(i), 1);
                }
            } else {
                return false;
            }
        }

        // final traversal to se if any char appeared less

        for (int i = 0; i < str.length(); i++) {
            if (originalStrMap.get(str.charAt(i)) != permStrMap.get(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /* @Param str : a string which we have to prove if its a permutation  of a palindrome
    input : tactcoa
    output : True bcoz [ "tac o cat", "act o tca"]
     if the given string is EVEN len then all the elemets  ahve to appear only even times inorder to able to form
     a posiible palindrome,
     if the given string is ODD len , then all except one elemsnts have to appear even times & ONLY ONE element has to
     appear odd times.
    * */
    public static boolean palindromePermutation(String str){
        // first create hasmap with count of char appearnce
        HashMap<Character,Integer> map = new HashMap<>();
        int len = str.length();
        char c;
        // preapre map
        for(int i = 0; i<len;i++){
            c = str.charAt(i);
            if(map.containsKey(str.charAt(i))){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }

        boolean even = isEven(len);
        int charCount;
        int oneOddCount = 0;
        for(int i = 0; i<len;i++){
            if(even){
                charCount = map.get(str.charAt(i));
                if(!isEven(charCount)){
                    return false;
                }
            }
            else {
                charCount = map.get(str.charAt(i));
                if(!isEven(charCount)){
                    oneOddCount ++;
                }
                else if(isEven(charCount)){
                    continue;
                }
                else if(oneOddCount>1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEven(int i){
        return (i & 1) == 1 ? false:true;
    }
    /*@Param str :  a string which will be compressed
    input: aabbcccaaa
    output : a2b2c3a3
    * */
    public static String stringCompression(String str){
        StringBuilder compressedString = new StringBuilder();
        int len = str.length();
        if(len>0) {
            int count = 1;
            char c;
            int i = 1;
            for (; i < len; i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                } else {
                    compressedString.append(str.charAt(i - 1) + "" + count);
                    count = 1;
                }
            }
            compressedString.append(str.charAt(i - 1) + "" + count);
            System.out.println(compressedString);
        }
        return compressedString.toString();
    }
}

