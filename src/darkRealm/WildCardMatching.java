package darkRealm;

public class WildCardMatching {

//  #44. Wildcard Matching
//  Implement wildcard pattern matching with support for '?' and '*'.
//      '?' Matches any single character.
//      '*' Matches any sequence of characters (including the empty sequence).
//  The matching should cover the entire input string (not partial).
//  The function prototype should be:
//  bool isMatch(const char *s, const char *p)
//  Some examples:
//  isMatch("aa","a") → false
//  isMatch("aa","aa") → true
//  isMatch("aaa","aa") → false
//  isMatch("aa", "*") → true
//  isMatch("aa", "a*") → true
//  isMatch("ab", "?*") → true
//  isMatch("aab", "c*a*b") → false
// Explaination : https://www.youtube.com/watch?v=3ZDZ-N0EPV0&t=19s

  public static boolean isMatch(String s, String p) {
    if (s == null && p != null || p == null & s != null) return false;
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true; // Initial true, bcoz null string matches null pattern
    for (int j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) != '*')
        break; // p can be '*', '*', '**',etc. Once p.charAt(j-1) != '*', all the dp[0][j] afterwards will be false.
      dp[0][j] = true;
    }
    char sc, pc;
    for (int i = 1; i < dp.length; i++) {
      sc = s.charAt(i - 1);
      for (int j = 1; j < dp[0].length; j++) {
        pc = p.charAt(j - 1);
        if (pc == sc || pc == '?') // if both mathches or pattern char is *, take from diagonal
          dp[i][j] = dp[i - 1][j - 1];
        else if (pc == '*') // if pattern is * take OR from top & left
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        else
          dp[i][j] = false; // if none above then till here for s & p dont match.
      }
    }
    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    String s = "aa";
    String p = "*";
    boolean res = isMatch(s, p);
    System.out.println("S : " + s);
    System.out.println("P : " + p);
    System.out.println("R : " + res);
  }
}
