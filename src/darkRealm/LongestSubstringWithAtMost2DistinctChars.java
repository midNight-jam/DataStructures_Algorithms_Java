package darkRealm;

public class LongestSubstringWithAtMost2DistinctChars {

//  #159. Longest Substring with At Most Two Distinct Characters
//  Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//  For example, Given s = “eceba”,
//  T is "ece" which its length is 3.

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int maxLen = 0, k = 2;
    int left = 0, right = 0, count = 0;
    int[] map = new int[128];
    while (right < s.length()) {
      char c = s.charAt(right);
      if (map[c] == 0) count++;
      map[c]++;
      while (count > k) {
        c = s.charAt(left);
        map[c]--;
        if (map[c] == 0) count--;
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
      right++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println("R ");
  }
}
