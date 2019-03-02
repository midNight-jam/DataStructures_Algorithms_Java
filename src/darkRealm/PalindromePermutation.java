package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

//  266. Palindrome Permutation
//  Given a string, determine if a permutation of the string could form a palindrome.
//      Example 1:
//
//  Input: "code"
//  Output: false
//  Example 2:
//
//  Input: "aab"
//  Output: true
//  Example 3:
//
//  Input: "carerac"
//  Output: true

  public static boolean canPermutePalindrome(String s) {
    if (s == null || s.length() < 1) return false;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i)))
        map.put(s.charAt(i), 0);
      map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
    }

    boolean odd = false;
    boolean possible = true;
    int count;
    for (char c : map.keySet()) {
      count = map.get(c);
      if ((count & 1) == 1 && !odd)
        odd = true;
      else if ((count & 1) == 1 && odd) {
        possible = false;
        break;
      }
    }
    return possible;
  }

  public static void main(String[] args) {
    String s = "aaa";
    boolean res = canPermutePalindrome(s);
    System.out.println(s);
    System.out.println(res);
  }
}
