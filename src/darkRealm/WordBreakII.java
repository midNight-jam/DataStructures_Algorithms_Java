package darkRealm;


import java.util.*;

public class WordBreakII {


/*
  #140 Word Break II
  DescriptionHintsSubmissionsDiscussSolution
  Discuss Pick One
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
    return wordBreakAllZZ(str, dict, map);
  }

  private static List<String> wordBreakAllZZ(String str, List<String> dict, Map<String, List<String>> map) {
    if (map.containsKey(str)) return map.get(str);
    String backPart;
    List<String> subList = new ArrayList<>();
    int len = str.length();
    if (dict.contains(str)) subList.add(str);
    for (int i = 1; i < len; i++) {
      backPart = str.substring(i, len);
      if (dict.contains(backPart)) {
        String frontRem = str.substring(0, i);
        List<String> remList = wordBreakAllZZ(frontRem, dict, map);
        for (String s : remList) {
          subList.add(s + " " + backPart);
        }
      }
    }
    map.put(str, subList);
    return subList;
  }

  public static void main(String[] args) {
    String s = "catsanddog";
    List<String> dict = new ArrayList<>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
    List<String> res  = wordBreak(s, dict);
    for (String st : res)
      System.out.println(st);
  }
}
