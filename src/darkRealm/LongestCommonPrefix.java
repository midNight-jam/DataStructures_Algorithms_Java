package darkRealm;

import java.util.Arrays;

/**
 * Created by Jayam on 3/31/2017.
 */


/*
  #14. Longest Common Prefix
 * Q) Write a function to determine the longest common prefix in the given array of strings
 * ["abc", "ab", "a", "abcd" ] --> "a"
 * ["abc", "ab", "a", "cabcd" ] --> ""
 * A) We sort the given array of strings, and if we just compare the first and the last strings we can determine that
 * a common prefix has been carried out till the last string, and then we can traverse the first and last string till the
 * character matches. If this is not the case and the first and the last string dont even start with the same char, then
 * we dont have any common prefix among the array of strings
 */

public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] arr) {
    if (arr == null || arr.length == 0)
      return "";
    String pre = arr[0];
    for (int i = 1; i < arr.length; i++) {
      while (arr[i].indexOf(pre) != 0)
        pre = pre.substring(0, pre.length() - 1);
    }
    return pre;
  }

  public static void main(String[] args) {
    String [] arr = new String[]{"abcdef","abcde","abcd"};
    String res = longestCommonPrefix(arr);
    System.out.println("Rse : " + res + " : "+ Arrays.toString(arr)); // abcd
  }
}