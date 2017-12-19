package darkRealm;

public class LongestSubstringWithAtleastKRepeatingChars {

  /*
  #395. Longest Substring with At Least K Repeating Characters
  Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
  Example 1:
  Input:
  s = "aaabb", k = 3
  Output:
      3
  The longest substring is "aaa", as 'a' is repeated 3 times.
      Example 2:
  Input:
  s = "ababbc", k = 2
  Output:
      5
  The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
  */


  public static int longestSubstring(String str, int k) {
    if (str == null || str.length() < k) return 0;
    return kHelper(str, 0, str.length() - 1, k);
  }

  private static int kHelper(String str, int start, int end, int k) {
    if (end - start + 1 < k) return 0;
    int[] map = new int[26];
    for (int i = start; i <= end; i++) {
      int index = str.charAt(i) - 'a';
      map[index]++;
    }
    for (int i = start; i <= end; i++) {
      // split the original string in to two parts from the char is repeating less times than K
      // and calculate the max again using recursion
      int index = str.charAt(i) - 'a';
      if (map[index] < k) {
        return Math.max(kHelper(str, start, i - 1, k), kHelper(str, i + 1, end, k));
      }
    }
    return end - start + 1;
  }

  public static void main(String[] args) {
    String s = "aaabb";
    int k = 3;
    int res = longestSubstring(s, k);
    System.out.println(res);
  }
}
