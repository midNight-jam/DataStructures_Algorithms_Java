package darkRealm.Hyper;

import java.util.Arrays;

/**
 * Created by Jayam on 7/30/2017.
 * Q) Write a function to determine the longest common prefix in the given array of strings
 * ["abc", "ab", "a", "abcd" ] --> "a"
 * ["abc", "ab", "a", "cabcd" ] --> ""
 * A) We sort the given array of strings, and if we just compare the first and the last strings we can determine that
 * a common prefix has been carried out till the last string, and then we can traverse the first and last string till the
 * character matches. If this is not the case and the first and the last string dont even start with the same char, then
 * we dont have any common prefix among the array of strings
 */
public class LongestCommonPrefix {

  private static String getLongestCommonPrefix(String[] strs) {
    if (strs == null || strs.length < 1)
      return "";

    Arrays.sort(strs);
    String a = strs[0];
    String b = strs[strs.length - 1];
    StringBuilder sbr = new StringBuilder();
    for (int i = 0; i < a.length(); i++)
      if (b.length() > i && a.charAt(i) == b.charAt(i))
        sbr.append(a.charAt(i));

      else
        return sbr.toString();

    return sbr.toString();
  }

  public static void main(String[] args) {
    String[] arr = new String[]{"abc", "abcd", "ab", "a", "abcde"};
    String res = getLongestCommonPrefix(arr);
    System.out.println("Longest Common Prefix : " + res + " Arr : " + Arrays.toString(arr));
  }
}
