package darkRealm;

public class DistinctSubsequence {

//  #115. Distinct Subsequences ::: Complexity - Time : O(s * t), Space : O(s * t)
//  Given a string S and a string T, count the number of distinct subsequences of S which equals T.
//  A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
//  of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
//  of "ABCDE" while "AEC" is not).
//  Here is an example:
//  S = "rabbbit", T = "rabbit"
//  Return 3.

  public static int numDistinct(String s, String t) {
    if (s == null || t == null) return 0;
    // T is the row and S is col
    int[][] dp = new int[t.length() + 1][s.length() + 1];
    char sc, tc;
    // For first row, t is empty, so how many substrings are empty for s only 1 always thus for first row all are 1
    for (int j = 0; j < dp[0].length; j++) dp[0][j] = 1;

    for (int i = 1; i < dp.length; i++) {
      // for each char in T
      tc = t.charAt(i - 1);
      for (int j = 1; j < dp[0].length; j++) {
        sc = s.charAt(j - 1);
        // If the chars at T nad S dnont match, then the no of distinct subsequences are carried from prev char in S, ie LEFT
        dp[i][j] = dp[i][j - 1];
        // If the chars at T and S match then, also add the value from diagonal, which is the no of distinct subseqeuences
        // prior to this char
        if (sc == tc)
          dp[i][j] += dp[i - 1][j - 1];
      }
    }

    return dp[t.length()][s.length()]; 
  }

  public static void main(String[] args) {
    String s = "";
    String t = "a";
    int res = numDistinct(s, t);
    System.out.println("T : " + res);
  }
}
