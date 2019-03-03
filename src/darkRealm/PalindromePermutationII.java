package darkRealm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {

//  267. Palindrome Permutation II
//  Given a string s, return all the palindromic permutations (without duplicates) of it.
//  Return an empty list if no palindromic permutation could be form.
//
//  Example 1:
//
//  Input: "aabb"
//  Output: ["abba", "baab"]
//  Example 2:
//
//  Input: "abc"
//  Output: []
//

  public static List<String> generatePalindromes(String s) {
    Map<Character, Integer> map = new HashMap<>();
    if (s == null || s.length() < 1)
      return new ArrayList<String>();

    int odd = 0;
    int count;
    char oddChar = ' ';

    for (char c : s.toCharArray()) {
      if (!map.containsKey(c))
        map.put(c, 0);
      map.put(c, map.get(c) + 1);
    }

    for (char c : map.keySet()) {
      count = map.get(c);
      if ((count & 1) == 1) {
        odd++;
        oddChar = c;
      }
    }

    if (odd > 1) // not possible to permute a palindrome
      return new ArrayList<>();

    String mid = "";
    if (oddChar != ' ') {
      mid += oddChar;
      if (map.get(oddChar) == 1)
        map.remove(oddChar);
      else
        map.put(oddChar, map.get(oddChar) - 1);
    }
    List<Character> palinChars = new ArrayList<>();
    for (char c : map.keySet()) {
      count = map.get(c) / 2; // add only half char as the same permutation will be used on the other side of the mid
      while (count != 0) {
        palinChars.add(c);
        count--;
      }
    }

    List<String> res = new ArrayList<>();
    boolean[] used = new boolean[palinChars.size()];
    helper(res, palinChars, new StringBuilder(), mid, used);
    return res;
  }

  private static void helper(List<String> res, List<Character> subPalins, StringBuilder palin, String mid, boolean[] used) {
    if (palin.length() == subPalins.size()) {
      StringBuilder sbr2 = new StringBuilder(palin);
      // to create the palindrome add the other half reversed
      res.add(palin.toString() + mid + sbr2.reverse().toString());
      return;
    }

    for (int i = 0; i < subPalins.size(); i++) {
      // there can be duplicate chars even when we add half of them, so skip the same chars to generate unique permutations
      if (used[i] || i > 0 && subPalins.get(i) == subPalins.get(i - 1) && used[i - 1]) continue;
      used[i] = true;
      palin.append(subPalins.get(i));
      helper(res, subPalins, palin, mid, used);
      palin.setLength(palin.length() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    String s = "cccccaabb";
//    String s = "cccaabb";
//    String s = "aab";
//    String s = "aabb";
//    String s = "a";
    List<String> res = generatePalindromes(s);
    System.out.println(s);
    System.out.println(res);
  }
}
