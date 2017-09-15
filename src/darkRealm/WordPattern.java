package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

//  Given a pattern and a string str, find if str follows the same pattern.
//  Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//  Examples:
//  pattern = "abba", str = "dog cat cat dog" should return true.
//  pattern = "abba", str = "dog cat cat fish" should return false.
//  pattern = "aaaa", str = "dog cat cat dog" should return false.
//  pattern = "abba", str = "dog dog dog dog" should return false.
//  Notes:
//  You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

  public static boolean wordPattern(String s, String t) {
    Map<Character, String> map = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    String[] arr = t.split(" ");
    if (s.length() != arr.length) return false;
    char ch;
    for (int i = 0; i < arr.length; i++) {
      ch = s.charAt(i);
      if (map.containsKey(ch)) {
        if (!(map.get(ch).equals(arr[i]) && map2.get(arr[i]) == ch)) return false;
      } else {
        map.put(ch, arr[i]);
        if (map2.containsKey(arr[i])) return false;
        else map2.put(arr[i], ch);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "abba";
//    String t = "dog cat cat dog";
//    String t = "dog cat cat fish";
    String t = "dog dog dog dog";
    boolean res = wordPattern(s, t);
    System.out.println("S : " + s + "\nT : " + t + "\nR : " + res);
  }
}