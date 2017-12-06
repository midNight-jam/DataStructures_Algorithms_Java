package darkRealm;

public class RepeatedSubstringPattern {

  /*
    #459 Repeated SubString
  * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies
  * of the substring together. You may assume the given string consists of lowercase English letters only and its length
  * will not exceed 10000.
  * Example 1:
  * Input: "abab"
  * Output: True
  * Explanation: It's the substring "ab" twice.
  * Example 2:
  * Input: "aba"
  * Output: False
  * Example 3:
  * Input: "abcabcabcabc"
  * Output: True
  * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
  * */

  public static boolean repeatedSubStringPattern(String str) {
    if (str == null || str.length() < 2) {
      return true;
    }
    StringBuilder pattern = new StringBuilder();
    int len = str.length();
    char c = '\u0000';
    for (int i = 0; i < len / 2; i++) {
      c = str.charAt(i);
      pattern.append(c);
      if (len % pattern.length() == 0) {
        int times = len / pattern.length();
        StringBuilder match = new StringBuilder();
        while (times != 0) {
          match.append(pattern);
          times--;
        }
        if (match.toString().equals(str)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
//  /    String str = "aaaabbaaaaba";
//    String str = "abab";
//    String str = "aba";
    String str = "abcabcabcabc";
    boolean res = repeatedSubStringPattern(str);
    System.out.println("Res : " + res + " Str : " + str);
  }
}
