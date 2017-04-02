package darkRealm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jayam on 3/31/2017.
 */
public class LongestSubStringWithOutRepeatingChars {

  public static int longestSubStringWithOutRepeatingChars(String str) {
    if (str == null || str.length() == 0) return 0;
    Set<Character> set = new HashSet<>();
    int left = 0, right = 0, len = str.length(), max = Integer.MIN_VALUE;
    char ch;
    while (right < len) {
      ch = str.charAt(right);
      if (!set.contains(ch)) {
        set.add(ch);
        max = Math.max(set.size(), max);
        right++;
      } else {
        set.remove(str.charAt(left));
        left++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String str = "aab";
    int res = longestSubStringWithOutRepeatingChars(str);
    System.out.println(res);
  }
}