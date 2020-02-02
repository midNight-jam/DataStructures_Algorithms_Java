package darkRealm;

public class LicenseKeyFormatting {
//  #482. License Key Formatting
//  Now you are given a string S, which represents a software license key which we would like to format. The string S is
//  composed of alphanumerical characters and dashes. The dashes split the alphanumerical characters within the string
//  into groups. (i.e. if there are M dashes, the string is split into M+1 groups). The dashes in the given string are
//  possibly misplaced.
//  We want each group of characters to be of length K (except for possibly the first group, which could be shorter,
//  but still must contain at least one character). To satisfy this requirement, we will reinsert dashes. Additionally,
//  all the lower case letters in the string must be converted to upper case.
//  So, you are given a non-empty string S, representing a license key to format, and an integer K. And you need to
//  return the license key formatted according to the description above.
//      Example 1:
//  Input: S = "2-4A0r7-4k", K = 4
//  Output: "24A0-R74K"
//  Explanation: The string S has been split into two parts, each part has 4 characters.
//      Example 2:
//  Input: S = "2-4A0r7-4k", K = 3
//  Output: "24-A0R-74K"
//  Explanation: The string S has been split into three parts, each part has 3 characters except the first part as it
//  could be shorter as said above.
//      Note:
//  The length of string S will not exceed 12,000, and K is a positive integer.
//  String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
//  String S is non-empty.


  public static String licenseKeyFormatting(String S, int k) {
    if (S == null || S.length() < 1 || k < 1) return "";
    StringBuilder sbr = new StringBuilder();
    int g = k;
    char c;
    S = S.toUpperCase();
    for (int i = S.length() - 1; i >= 0; i--) {
      c = S.charAt(i);
      if (c == '-') continue;
      sbr.append(c);
      g--;
      if (g == 0) {
        if (i > 0)
          sbr.append('-');
        g = k;
      }
    }
    String res = sbr.reverse().toString();
    return res.length() > 0 && res.charAt(0) == '-' ? res.substring(1) : res;
  }

  public static String licenseKeyFormattingOLD(String S, int K) {
    StringBuilder sbr = new StringBuilder();
    char c;
    int groupLen = 0;
    for (int i = S.length() - 1; i > -1; i--) {
      c = S.charAt(i);
      if (c == '-') continue;
      c = (char) ((c > 96 && c < 123) ? c - 32 : c);
      if ((sbr.length() % (K + 1)) == K) sbr.append('-'); // beacuase if  adding '-' makes it a multiple of K then add
      sbr.append(c);
    }
    return sbr.reverse().toString();
  }

  public static void main(String[] args) {
//    String S = "2-4A0r7-4k";
//    int K = 4;
//    String S = "2-4A0r7-4k";
//    int K = 3;

    String S = "--a-a-a-a--";
    int K = 2;
    String res = licenseKeyFormatting(S, K);
    System.out.println("S : " + S);
    System.out.println("K : " + K);
    System.out.println("R : " + res);
  }
}