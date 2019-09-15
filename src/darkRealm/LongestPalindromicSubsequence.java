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
  public static int longestPalidromicSubsequence(String s) {
    if (s == null || s.length() < 1) return 0;
    int N = s.length();

    int[][] dp = new int[N][N];

    for (int i = 0; i < N; i++)
      dp[i][i] = 1;

    for (int start = N - 1; start > -1; start--) {
      for (int end = start + 1; end < N; end++) {
        // if char at head == char at tail pick vlaue from lower diagonal & add 2
        if (s.charAt(start) == s.charAt(end)) {
          dp[start][end] = start + 1 < N && end - 1 > -1 ? dp[start + 1][end - 1] : 0;
          dp[start][end] += 2;
        }
        // if chars are diff then take max of one col behind & one row below
        else {
          int bottom = start + 1 < N ? dp[start + 1][end] : 0;
          int left = end - 1 > -1 ? dp[start][end - 1] : 0;
          dp[start][end] = Math.max(bottom, left);
        }
      }
    }

    return dp[0][N - 1];
  }

  public static void main(String[] args) {
    String str = "bbbab";
//    String str = "cbbd";
    int res = longestPalidromicSubsequence(str);
    System.out.println("Res : " + res + " Str : " + str);
  }
}
