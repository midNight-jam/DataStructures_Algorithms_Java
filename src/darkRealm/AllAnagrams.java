package darkRealm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayam on 3/31/2017.
 */
public class AllAnagrams {

  public static List<Integer> allAnagrams(String s, String anagram) {
    if (s == null || s.length() == 0 || anagram == null || anagram.length() == 0)
      return new ArrayList<>();
    int[] hash = new int[256];
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < anagram.length(); i++)
      hash[anagram.charAt(i)]++;
    int windowWidth = anagram.length();
    int windowCount = anagram.length();
    int start = 0, end = 0;
    while (end < s.length()) {
      if (hash[s.charAt(end)] >= 1)
        windowCount--;
      hash[s.charAt(end)]--;
      end++;
      if (windowCount == 0)
        results.add(start);
      if (end - start == windowWidth) {
        char outGoing = s.charAt(start);

        if (hash[outGoing] >= 0)
          windowCount++;
        hash[outGoing]++;
        start++;
      }
    }
    return results;
  }

  public static void main(String[] args) {
    String s = "cbaebabacd";
    String p = "abc";
    List<Integer> result = allAnagrams(s, p);
    System.out.println(result);
  }
}