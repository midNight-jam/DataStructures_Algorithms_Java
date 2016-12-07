package com.darkRealm;
import com.darkRealm.Arrays_and_Strings.*;
/**
 * Created by Jayam on 10/2/2016.
 */
public class Arrays_and_Strings_Main {
    public static void doIsUnique(){
        System.out.println(Arrays_and_Strings.IsUnique("sabcds"));
    }

    public static void doCheckPerm(){
        System.out.println(Arrays_and_Strings.CheckPermutation("sabcds","ssbcda"));
        System.out.println(Arrays_and_Strings.CheckPermutation("sabcds","sbcda"));
        System.out.println(Arrays_and_Strings.CheckPermutation("sabcds","ssbcdas"));
        System.out.println(Arrays_and_Strings.CheckPermutation("sabcds","sbcd"));
    }

    public static void doCheckPermPalindrome(){
        System.out.println(Arrays_and_Strings.palindromePermutation("abaab"));
    }

    public static void doCompresssion(){
        Arrays_and_Strings.stringCompression("abcdeeeeeeeee");
    }
}
