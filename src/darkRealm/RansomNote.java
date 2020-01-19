package darkRealm;

import java.util.HashMap;

public class RansomNote {
  
//  383. Ransom Note
//  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will 
//  return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//  Each letter in the magazine string can only be used once in your ransom note.
//  You may assume that both strings contain only lowercase letters.
//  canConstruct("a", "b") -> false
//  canConstruct("aa", "ab") -> false
//  canConstruct("aa", "aab") -> true

  public static boolean canConstruct(String ransomNote, String magazine) {
    int [] map = new int[256];
    for(char c : magazine.toCharArray())
      map[c]++;
    
    for(char c : ransomNote.toCharArray()){
      if(map[c] == 0) return false;
      map[c]--;
    }
    
    return true;
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
