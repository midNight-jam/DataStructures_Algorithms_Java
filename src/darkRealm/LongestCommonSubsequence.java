package darkRealm;

public class LongestCommonSubsequence {


//  # LongestCommonSubsequence of two Strings   :::   Complexity  - Time : O(m*n)
//  LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
//  LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

  public static int longestCommonSubsequence(String a, String b) {
    if (a == null || a.length() == 0 || b == null || b.length() == 0) return 0;
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 1; i < dp.length; i++)
      for (int j = 1; j < dp[0].length; j++)
        if (a.charAt(i - 1) == b.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

    return dp[a.length()][b.length()];
  }

  public static void main(String[] args) {
//    String a = "AGGTAB";
//    String b = "GXTXAYB";
    String a = "ABCDAF";
    String b = "ACBCF";

    int res = longestCommonSubsequence(a, b);
    System.out.println("a : " + a);
    System.out.println("b : " + b);
    System.out.println("r : " + res);
  }
}
