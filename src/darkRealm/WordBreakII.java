package darkRealm;


import java.util.*;

public class WordBreakII {


/*
  #140 Word Break II
  Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
  Return all such possible sentences.
  For example, given
  s = "catsanddog",
  dict = ["cat", "cats", "and", "sand", "dog"].
  A solution is ["cats and dog", "cat sand dog"].
*/

  public static List<String> wordBreak(String str, List<String> dict) {
    if (str == null || str.length() == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    return helper(str, dict, map);
  }

  // break the string from behind for valid strings/suffix
  private static List<String> helper(String str, List<String> dict, Map<String, List<String>> map) {
    // if we have encountered this str/prefix before return the list against it
    if (map.containsKey(str)) return map.get(str);
    String suffix;
    List<String> subList = new ArrayList<>();
    int len = str.length();
    if (dict.contains(str)) subList.add(str);
    for (int i = 1; i < len; i++) {
      suffix = str.substring(i, len);
      if (dict.contains(suffix)) {
        String prefix = str.substring(0, i);
        // get all the valid prefixes that can be formed using the dictionary & append this suffix to them
        List<String> remList = helper(prefix, dict, map);
        for (String s : remList) {
          subList.add(s + " " + suffix);
        }
      }
    }
    map.put(str, subList);
    return subList;
  }


  public static List<String> wordBreakTLE(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    res = new ArrayList<>();
    helperTLE(s, 0, dict, new ArrayList<>());
    StringBuilder sbr = new StringBuilder();
    List<String> fres = new ArrayList<>();
    for (List<String> r : res) {
      sbr.setLength(0);
      for (String ss : r)
        sbr.append(ss);
      String f = sbr.toString().substring(0, sbr.length() - 1);
      fres.add(f);
    }
    return fres;
  }

  static List<List<String>> res;

  private static void helperTLE(String s, int index, Set<String> dict, List<String> list) {
    if (index >= s.length()) {
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = index + 1; i <= s.length(); i++) {
      String head = s.substring(index, i);
      if (dict.contains(head)) {
        list.add(head + " ");
        helperTLE(s, i, dict, list);
        list.remove(list.size() - 1);
      }
    }
  }


  public static void main(String[] args) {
//    String s = "catsanddog";
//    List<String> dict = new ArrayList<>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
//    String s = "pineapplepenapple";
//    List<String> dict = new ArrayList<>(Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"}));

    String s = "catsanddog";
    List<String> dict = new ArrayList<>(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));

    List<String> res = wordBreak(s, dict);
    for (String st : res)
      System.out.println(st);
  }
}
