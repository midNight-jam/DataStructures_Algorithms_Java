package darkRealm;

import java.util.Arrays;

/**
 * Created by Jayam on 3/31/2017.
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