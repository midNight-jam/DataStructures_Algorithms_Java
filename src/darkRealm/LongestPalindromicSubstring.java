package darkRealm;

public class LongestPalindromicSubstring {


  /*  #5 Longest Palindromic Substring
   *   Q) Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
   *   Example:
   *   Input: "babad"
   *   Output: "bab"
   *   Note: "aba" is also a valid answer.
   *   Example:
   *   Input: "cbbd"
   *   Output: "bb"
   *
   * */
  static int start, maxLen;

  static public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;
    int N = s.length();
    boolean[][] dp = new boolean[N][N];
    String res = "";
    
     // as each single char is a palindrome in itself
    for (int i = 0; i < N; i++)
      dp[i][i] = true;

    for (int start = N - 1; start > -1; start--) {
      for (int end = start; end < N; end++) {
        if (s.charAt(start) != s.charAt(end)) continue;
        boolean adj = end - start <= 2;
        boolean subPartIsPalin = start + 1 < end && end - 1 > -1 ? dp[start + 1][end - 1] : false;
        if (adj || subPartIsPalin) {
          dp[start][end] = true;
          if (end - start + 1 > res.length())
            res = s.substring(start, end + 1);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
//    String str = "edbabcdcbaba";
//    String str = "ccc";
//    String str = "abb";
//    String str = "aaaa";
//    String str = "bb";
//    String str = "asdasdabceecbaasdasdasd";
//    String str = "cabababcbc";
    String str = "cbbd";

//    String str = "asdasdasdbbaabbasdasdasdasdasdasdasdasdsafiwenrfblw ebrfbwjhrfb";
//    String str = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
//    String str = "aaaaaaaaaaaaaaaaaabbbbbbbbbbbb";
//   String str = "bppbasooos";
//    String str = "dabcba";
    String plain = longestPalindrome(str);
    System.out.println(" Str : " + str);
    System.out.println(" Longest substring : " + plain);
    System.out.println(" len " + plain.length());
    System.out.println(" Str : " + str);
    System.out.println(" Longest substring : " + plain);
    System.out.println(" len " + plain.length());

  }
}
