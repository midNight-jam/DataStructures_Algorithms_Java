package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

//  205. Isomorphic Strings
//  Given two strings s and t, determine if they are isomorphic.
//  Two strings are isomorphic if the characters in s can be replaced to get t.
//  All occurrences of a character must be replaced with another character while preserving the order of characters.
//  No two characters may map to the same character but a character may map to itself.
//  For example,
//  Given "egg", "add", return true.
//  Given "foo", "bar", return false.
//  Given "paper", "title", return true.
//  Note:
//  You may assume both s and t have the same length.


  public static boolean isIsomorphicBASIC(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) return false;

    Map<Character, Character> map = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    char cs, ct;

    for (int i = 0; i < s.length(); i++) {
      cs = s.charAt(i);
      ct = t.charAt(i);
      // if both keys are new update & continue;
      if (!map.containsKey(cs) && !map2.containsKey(ct)) {
        map.put(cs, ct);
        map2.put(ct, cs);
        continue;
      }
      // if atleast one key is new means incorrect mapping
      if (!map.containsKey(cs) || !map2.containsKey(ct)) return false;

      // if both keys are old then should map to each other
      if (!(map.get(cs) == ct && map2.get(ct) == cs)) return false;
    }
    return true;
  }

  public static boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) return false;

    int[] map = new int[256];
    int[] map2 = new int[256];
    Arrays.fill(map, -1);
    Arrays.fill(map2, -1);
    char cs, ct;
    for (int i = 0; i < s.length(); i++) {
      cs = s.charAt(i);
      ct = t.charAt(i);
      // either both keys should be new, so update & continue;
      if (map[cs] == -1 && map2[ct] == -1) {
        map[cs] = ct;
        map2[ct] = cs;
        continue;
      }
      // else both keys should be old & should be mapped to each other
      if (!(map[cs] == ct && map2[ct] == cs)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
//    String s = "egg";
//    String t = "add";

//    String s = "foo";
//    String t = "bar";

//    String s = "paper";
//    String t = "title";

    String s = "13";
    String t = "42";


//    String s = "ab";
//    String t = "aa";

//    String s = "ab";
//    String t = "ca";


//    String s = "ca";
//    String t = "ab";

    boolean res = isIsomorphic(s, t);
    System.out.println("S : " + s);
    System.out.println("S : " + t);
    System.out.println("R : " + res);
  }
}