package darkRealm;

public class LongestPalindromicSubsequence {

  /*
    #516 Longest Palindromic Subsequence
  * Given a string s, find the longest palindromic subsequence's length in s.
  * You may assume that the maximum length of s is 1000.
  * Example 1:
  * Input:
  * "bbbab"
  * Output:
  * 4
  * One possible longest palindromic subsequence is "bbbb".
  * Example 2:
  * Input:
  * "cbbd"
  * Output:
  * 2
  * One possible longest palindromic subsequence is "bb".
  *  A) USE DP  In this solution we solve while moving towards top right, rather than usual bottom right. So Effectively
  *  lower half of matrix is useless, only top half of matrix is utilized
  *  Two Rules :
  *   if char at head == char at tail pick vlaue from lower diagonal & add 2
  *   if chats are diff then take max of one col behind & one row below
  */
  public static int longestPalidromicSubsequence(String str) {
    int len = str.length();
    int[][] DP = new int[len][len];
    // red strings fromlast
    for (int i = len - 1; i >= 0; i--) {
      DP[i][i] = 1;
      for (int j = i + 1; j < len; j++) {
        if (str.charAt(i) == str.charAt(j)) {
          DP[i][j] = DP[i + 1][j - 1] + 2;
        } else {
          DP[i][j] = Math.max(DP[i + 1][j], DP[i][j - 1]);
        }
        System.out.println(str.substring(i, j));
      }
    }
    return DP[0][len - 1];
  }

  public static void main(String[] args) {
    String str = "bbbab";
//    String str = "cbbd";
    int res = longestPalidromicSubsequence(str);
    System.out.println("Res : " + res + " Str : " + str);
  }
}
