package darkRealm;

import java.util.*;

public class SubstringWithConcatenationOfWords {

//  #30. Substring with Concatenation of All Words    :::   Complexity  -   Time : O(w*L*N)
//  You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices
//  of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//  For example, given:
//  s: "barfoothefoobarman"
//  words: ["foo", "bar"]
//  You should return the indices: [0,9].
//  (order does not matter).

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
    Map<String, Integer> map = new HashMap<>();
    for (String w : words)
      map.put(w, map.getOrDefault(w, 0) + 1);

    int gap = words.length * words[0].length();
    int wl = words[0].length();
    int ptr = 0;

    for (int i = 0; i <= s.length() - gap; i++) {
      String head = s.substring(i, i + wl);
      if (!map.containsKey(head)) continue;
      Map<String, Integer> temp = new HashMap<>(map); // creating copy of map, to determine that the current window matches
      for (int j = 0; j < words.length; j++) {
        ptr = i + j * wl; //  from ith index, the jth word of dictionary
        head = s.substring(ptr, ptr + wl);
        if (temp.containsKey(head) && temp.get(head) > 0) {
          if (temp.get(head) == 1) temp.remove(head);
          else temp.put(head, temp.get(head) - 1);
        } else break;
      }
      if (temp.size() == 0)
        res.add(i);
    }
    return res;
  }

  public static void main(String[] args) {
//    String s = "barfoothefoobarman";
//    String[] words = new String[]{"foo", "bar"};
//    String s = "barfoofoobarthefoobarman";
//    String[] words = new String[]{"bar", "foo", "the"};

    String s = "wordgoodgoodgoodbestword";
    String[] words = new String[]{"word", "good", "best", "good"};

    List<Integer> res = findSubstring(s, words);
    System.out.println(s);
    System.out.println(res);
  }
}
