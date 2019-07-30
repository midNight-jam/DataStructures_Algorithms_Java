package darkRealm;

import java.util.*;

public class GroupAnagrams {


  /*  #49 Group Anagrams
   * Given an array of strings, group anagrams together.
   * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
   * Return:
   * [ ["ate", "eat","tea"],  ["nat","tan"],  ["bat"] ]
   * Note: All inputs will be in lower-case.
   * */
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length < 1) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    char[] arr;
    String k;
    for (String s : strs) {
      arr = s.toCharArray();
      Arrays.sort(arr);
      k = new String(arr);
      if (!map.containsKey(k))
        map.put(k, new ArrayList<>());
      map.get(k).add(s);
    }

    List<List<String>> res = new ArrayList<>();
    for (String kk : map.keySet())
      res.add(map.get(kk));

    return res;
  }

  public static void main(String[] args) {
//    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//    String[] strs = new String[]{""};
//    String[] strs = new String[]{"tea","","eat","","tea",""};
//    String[] strs = new String[]{"ape","and","cat"};
    String[] strs = new String[]{"", "b"};
    List<List<String>> res = groupAnagrams(strs);
    System.out.println("Res : " + Arrays.toString(res.toArray()));
  }
}
