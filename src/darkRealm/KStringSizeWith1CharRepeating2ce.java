package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class KStringSizeWith1CharRepeating2ce {


//  In the given string s and len k, find all substrings of len k such that there is only one char that is repeating twice
//    String s = "democracy"  k = 5
// return [ ocrac , cracy ], as both are of len 5, and have at max one char repeating twice


  public static List<String> some(String s, int k) {
    int maxLen = 0;
    int left = 0, right = 0, count = 0;
    int[] map = new int[128];
    List<String> res = new ArrayList<>();
    while (right < s.length()) {
      char c = s.charAt(right);
      if (map[c] < 2) count++;
      map[c]++;
      while (k == right - left + 1) {
        c = s.charAt(left);
        if (map[s.charAt(left)] + map[s.charAt(right)] == 3) {
          String sub = s.substring(left, right + 1);
          res.add(sub);
        }
        map[c]--;
        if (map[c] < 2) count--;
        left++;
      }
      right++;
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "democracy";
//    String s = "wawaglknagagwunagkwkwagl";
//    String s = "awaglk";
    int k = 5;
//    int k = 4;
    List<String> res = some(s, k);
    System.out.println(res);

  }
}
