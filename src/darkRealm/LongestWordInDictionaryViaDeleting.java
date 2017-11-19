package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryViaDeleting {

//  #524. Longest Word in Dictionary through Deleting   ::: Complexity  -  Time : O(d*l), no of string in dict & their len, Space: O(1)
//  Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
//  some characters of the given string. If there are more than one possible results, return the longest word with the
//  smallest lexicographical order. If there is no possible result, return the empty string.
//  Example 1:
//  Input:
//  s = "abpcplea", d = ["ale","apple","monkey","plea"]
//  Output:
//  "apple"
//  Example 2:
//  Input:
//  s = "abpcplea", d = ["a","b","c"]
//  Output:
//  "a"
//  Note:
//  All the strings in the input will only contain lower-case letters.
//  The size of the dictionary won't exceed 1,000.
//  The length of all the strings in the input won't exceed 1,000.

  public static String findLongestWord(String s, List<String> dict) {
    if (s == null || s.length() == 0 || dict == null || dict.size() == 0) return "";
    String res = "";
    int len = Integer.MIN_VALUE;
    int pa, pd;
    for (String d : dict) {
      pd = 0;
      pa = 0;
      while (pa < s.length() && pd < d.length()) {
        if (s.charAt(pa) == d.charAt(pd)) pd++;
        pa++;
      }
      if (pd == d.length()) {
        if (pd > len) {
          len = pd;
          res = d;
        } else if (pd == len && d.compareTo(res) < 0)
          res = d;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "abpcplea";
    List<String> dictionary = new ArrayList<>(Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"}));
    String res = findLongestWord(s, dictionary);
    System.out.println("S : " + s);
    for (String d : dictionary)
      System.out.print( d + " ");
    System.out.println("\nR : " + res);
  }
}
