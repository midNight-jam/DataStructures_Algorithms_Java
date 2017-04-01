package darkRealm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jayam on 3/31/2017.
 */
public class LongestSubstringKDistinct {

  public static int longestSubStringKDistinctChars(String str, int k) {
    if (str == null || str.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, end = 0, maxLen = Integer.MIN_VALUE;

    while (end < str.length()) {
      map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
      while (map.size() > k) {
        map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
        if (map.get(str.charAt(start)) == 0)
          map.remove(str.charAt(start));
        start++;
      }
      end++;
      maxLen = Math.max(maxLen, end - start + 1);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String str = "eceba";
    int k = 2;
    int res = longestSubStringKDistinctChars(str, k);
    System.out.println(str+" res : "+res);
  }
}
