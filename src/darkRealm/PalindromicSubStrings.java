package darkRealm;

public class PalindromicSubStrings {

//  #647. Palindromic Substrings
//  Given a string, your task is to count how many palindromic substrings in this string.
//  The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//  Example 1:
//  Input: "abc"
//  Output: 3
//  Explanation: Three palindromic strings: "a", "b", "c".
//  Example 2:
//  Input: "aaa"
//  Output: 6
//  Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

  static int count = 0;
  public static int countSubStrings(String s) {
    for (int i = 0; i < s.length(); i++) {
      tryPalindrome(s, i, i);
      tryPalindrome(s, i, i + 1);
    }
    return count;
  }

  private static void tryPalindrome(String s, int left, int right) {
    while (left > -1 && right < s.length()) {
      if (s.charAt(left) == s.charAt(right)) {
        count++;
        left--;
        right++;
      } else break;
    }
  }

  public static void main(String[] args) {
    String s = "abc";
//    String s = "aaa";
    int res = countSubStrings(s);
    System.out.println("S : " + s);
    System.out.println("R : " + res);
  }
}
