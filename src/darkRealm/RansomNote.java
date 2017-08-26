package darkRealm;

import java.util.HashMap;

public class RansomNote {
//  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//  Each letter in the magazine string can only be used once in your ransom note.
//  You may assume that both strings contain only lowercase letters.
//  canConstruct("a", "b") -> false
//  canConstruct("aa", "ab") -> false
//  canConstruct("aa", "aab") -> true

  public static boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : ransomNote.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);

    for (char c : magazine.toCharArray())
      if (map.containsKey(c))
        if (map.get(c) == 1)
          map.remove(c);
        else
          map.put(c, map.get(c) - 1);
    return map.size() == 0;
  }

  public static void main(String[] args) {
//    String ransomeNote = "a";
//    String magazine = "b";
    String ransomeNote = "aa";
    String magazine = "aab";
    boolean res = canConstruct(ransomeNote, magazine);
    System.out.println("Res : " + res);
  }
}