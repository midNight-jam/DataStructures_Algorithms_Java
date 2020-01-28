package darkRealm;

public class ValidPalindromeII {

//  680. Valid Palindrome II
//  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//  Example 1:
//  Input: "aba"
//  Output: True
//  Example 2:
//  Input: "abca"
//  Output: True
//  Explanation: You could delete the character 'c'.

  public static boolean validPalindrome(String s) {
    int low = 0, high = s.length() - 1;
    while (low <= high) {
      if (s.charAt(low) != s.charAt(high))
        return isPalindrome(s, low, high - 1) || isPalindrome(s, low + 1, high);
      low++;
      high--;
    }
    return true;
  }

  public static boolean isPalindrome(String s, int low, int high) {
    for (; low <= high; low++, high--)
      if (s.charAt(low) != s.charAt(high)) return false;
    return true;
  }

  public static void main(String[] args) {
//    String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    String s = "abc";
//    String s = "lcuppucul";
//    String s = "ebcbbececabbacecbbcbe";
    boolean res = validPalindrome(s);
    System.out.println("S : " + s + "\nR : " + res);
  }
}
