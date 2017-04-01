package darkRealm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jayam on 3/31/2017.
 */
public class LongestSubStringWithOutRepeatingChars {

  public static int longestSubStringWithOutRepeatingChars(String str) {
    if (str == null || str.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int maxLen = 0;
    for (int start = 0, end = 0; end < str.length(); end++) {
      if (map.containsKey(str.charAt(end))) {
        start = Math.max(start, map.get(str.charAt(end)) + 1);
      }
      map.put(str.charAt(end), end);
      maxLen = Math.max(maxLen, end - start + 1);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    String str = "aab";
    int res = longestSubStringWithOutRepeatingChars(str);
    System.out.println(res);
  }
}