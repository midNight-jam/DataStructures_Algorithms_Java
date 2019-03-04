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

  public static String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return s;
    int[][] dp = new int[s.length()][s.length()];
    char[] arr = s.toCharArray();

    // as each single char is a palindrome in itself
    for (int end = 0; end < s.length(); end++)
      for (int start = 0; start <= end; start++)
        if (start == end)
          dp[start][end] = 1;
    // we will be dealing in the upperhalf of the matrix only, and starting from bottom right, bcoz add a char at the
    // end assuming adding this will make string palindrome
    // why we are starting from behind, well debug on paper

    int max = Integer.MIN_VALUE;
    String res = null;
    for (int end = 0; end < s.length(); end++) {
      for (int start = 0; start <=end; start++) {
        // ----------------------------------------------- lookup from bottom left
        if (arr[start] == arr[end] && (end - start <= 2 || dp[start + 1][end - 1] == 1)) {
          if (end - start > max) {
            max = end - start;
            res = s.substring(start, end + 1);
          }
          dp[start][end] = 1;
        }
      }
    }
    return res;
  }


  // @DEPRECATED DONOT REFERNECE THIS
  public static String longestPalindromeOLD(String s) {
    if (s == null || s.length() < 2) return s;
    int len = s.length();

    for (int i = 0; i < len - 1; i++) {
      extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
      extendPalindrome(s, i, i + 1); //assume even length.
    }
    return s.substring(start, start + maxLen);
  }

  private static void extendPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    if (maxLen < right - left - 1) {
      start = left + 1;
      maxLen = right - left - 1;
    }
  }


  public static void main(String[] args) {
//    String str = "edbabcdcbaba";
//    String str = "ccc";
//    String str = "abb";
//    String str = "aaaa";
//    String str = "bb";
//    String str = "asdasdabceecbaasdasdasd";
    String str = "cabababcbc";

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
