package darkRealm;

public class RegularExpressionMatching {

  /*  [Prob 10] Regular Expression Matching
  *   Explaination : https://www.youtube.com/watch?v=l3hda49XcDE
  *
  *   Two Rules :
  *   1: if pattern char is * (star) assign value from two left (0 occurence ) OR
  *    OR 1 occurrence for this check if previous char in pattern matches the current char in string or is prev char a dot
   *    (dot : it always matches)
  *   2: If both chars match or pattern char is .(dot) then assign value from diagonal
  * */
  public static boolean regularExpressionMatching(String str, String pattern) {
    boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
    dp[0][0] = true;
    //Deals with patterns like a* or a*b* or a*b*c*
    for (int i = 1; i < dp[0].length; i++) {
      if (pattern.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      }
    }

    char pchar, schar;
    for (int i = 1; i < dp.length; i++) {
      schar = str.charAt(i - 1);
      for (int j = 1; j < dp[0].length; j++) {
        pchar = pattern.charAt(j - 1);
        //1: if pattern char is * (star) assign value from two left (ignoring pattern) OR one above (one char removed)
        if (pchar == '*') {
          dp[i][j] = dp[i][j - 2]; //twoLeft (0 occurences)
          char prev = pattern.charAt(j - 2);
          if (prev == '.' || prev == schar) {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        }
        //2: If both chars match or pattern char is .(dot) then assign value from diagonal
        else if ((pchar == schar) || pchar == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[str.length()][pattern.length()];
  }


  public static void main(String[] args) {
//    String str = "aab";
//    String pat = "c*a*b";
//
//    String str = "xaabyc";
//    String pat = "xa*b.c";
//
    String str = "abcd";
    String pat = "d*";


    boolean res = regularExpressionMatching(str, pat);
    System.out.println(" Str : " + str + "  Pattern : " + pat);
    System.out.println(" Res : " + res);
  }
}
