package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


  /*  #49 Group Anagrams
* Given an array of strings, group anagrams together.
* For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
* Return:
* [ ["ate", "eat","tea"],  ["nat","tan"],  ["bat"] ]
* Note: All inputs will be in lower-case.
* */
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      char[] sar = s.toCharArray();
      Arrays.sort(sar);
      String s2 = new String(sar);
      if (map.containsKey(s2)) {
        map.get(s2).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(s2, list);
      }
    }
    List<List<String>> results = new ArrayList<>();
    for (String k :
        map.keySet()) {
      results.add(map.get(k));
    }
    return results;
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