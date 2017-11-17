package darkRealm;

public class InterleavingString {

//  #97. Interleaving String  ::: Complexity  - Time : O(n*m)   Space : O(n*m)
//  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//  For example,
//  Given:
//  s1 = "aabcc",
//  s2 = "dbbca",
//  When s3 = "aadbbcbcac", return true.
//  When s3 = "aadbbbaccc", return false.

  public static boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) return false;
    if (s1.length() + s2.length() != s3.length()) return false;
    boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
    dp[0][0] = true;
    // First Col
    for (int i = 1; i < dp.length; i++)
      if (dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1))
        dp[i][0] = true;

    // First Row initilization
    for (int j = 1; j < dp[0].length; j++)
      if (dp[0][j - 1] && s1.charAt(j - 1) == s3.charAt(j - 1))
        dp[0][j] = true;

    char c1, c2, c3;
    for (int i = 1; i < dp.length; i++) {
      c2 = s2.charAt(i - 1);
      for (int j = 1; j < dp[0].length; j++) {
        c1 = s1.charAt(j - 1);
        c3 = s3.charAt(i + j - 1);
        if (dp[i][j - 1] && c1 == c3) dp[i][j] = true; // if match from s1, take from prev col
        else if (dp[i - 1][j] && c2 == c3) dp[i][j] = true; // if match from s2, take from prev row
      }
    }
    return dp[s2.length()][s1.length()];
  }

  public static void main(String[] args) {
//    String s1 = "aabcc";
//    String s2 = "dbbca";
////    String s3 = "aadbbcbcac";
//    String s3 =  "aadbbbaccc";

//    String s1 = "a";
//    String s2 = "";
//    String s3 = "c";

//
//    String s1 = "";
//    String s2 = "abc";
//    String s3 = "ab";

//
//    String s1 = "a";
//    String s2 = "b";
//    String s3 = "ab";

    String s1 = "ab";
    String s2 = "bc";
    String s3 = "babc";

    boolean res = isInterleave(s1, s2, s3);
    System.out.println("S1 : " + s1);
    System.out.println("S2 : " + s2);
    System.out.println("S3 : " + s3);
    System.out.println("R  : " + res);
  }
}
