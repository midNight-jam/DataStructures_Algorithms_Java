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
    List<String> res = new ArrayList<>();
    boolean odd = false;
    Map<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()){
      if(!map.containsKey(c))
        map.put(c, 0);
      map.put(c, map.get(c) + 1);
    }
    
    int len = 0;
    char oc=' ';//oddchar
    for(Character c : map.keySet()){
      int f = map.get(c);
      len += f;
      if((f & 1) == 1){
        oc = c;
        if(!odd)
          odd = true;
        else// more than 1 odd
          return new ArrayList<>();
      }
    }
    // reduce the odd to even
    if(oc !=' ')
      map.put(oc, map.get(oc) - 1);
    
    String start = oc == ' '? "" : ""+oc+""; // use the oddchar as start
    helper(start, len, map, res);
    return res;
  }

   private static void helper(String p, int len, Map<Character, Integer> map,  List<String> res){
    if(len == p.length()){
      res.add(p);
      return;
    }
    
    for(Character c : map.keySet()){
      if(map.get(c) == 0) continue;
      String next = c + p + c;
      map.put(c, map.get(c) - 2);
      helper(next, len, map, res);
      map.put(c, map.get(c) + 2);
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
