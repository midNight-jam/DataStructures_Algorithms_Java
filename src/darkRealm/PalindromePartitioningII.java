package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {

//  132. Palindrome Partitioning II
//  Given a string s, partition s such that every substring of the partition is a palindrome.
//  Return the minimum cuts needed for a palindrome partitioning of s.
//
//  Example:
//  Input: "aab"
//  Output: 1
//  Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.


  public static int minCut(String s) {
    if (s == null || s.length() < 1) return 0;
    boolean[][] dp = new boolean[s.length()][s.length()];

    int res = s.length();

    int[] cut = new int[s.length()];
    char[] arr = s.toCharArray();
    // all the chars in themselves are palindromes
    for (int start = s.length() - 1; start >= 0; start--)
      for (int end = s.length() - 1; end >= start; end--)
        if (start == end)
          dp[start][end] = true;


    for (int end = 0; end < s.length(); end++) {
      cut[end] = end; // as the max no of partitions will be equal to length till here - 1
      for (int start = 0; start <= end; start++) {
        // ----------------------------------------------- lookup from bottom left
        if (arr[start] == arr[end] && (end - start <= 2 || dp[start + 1][end - 1])) {
          if (start > 0) {
          // if start to end is palin, take min among current cut[end] & the no of cuts b4 this palin.
            // i.e. [start - 1] + 1 (for this palin)
            cut[end] = Math.min(cut[end], cut[start - 1] + 1);
          } else
            cut[end] = 0;
          dp[start][end] = true;
        }
      }
    }

    return cut[s.length() - 1];
  }

  public static void main(String[] args) {
//    String str = "aab";
//    String str = "dabcba";
//    String str = "edbabcdcbaba";
//    String str = "ccc";
//    String str = "bb";
//    String str = "asdasdabceecbaasdasdasd";
//    String str = "asdasdasdbbaabbasdasdasdasdasdasdasdasdsafiwenrfblw ebrfbwjhrfb";
//    String str = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
//    String str = "aaaaaaaaaaaaaaaaaabbbbbbbbbbbb";
//   String str = "bppbasooos";
//    String str = "dabcba";

    String str = "cabababcbc";
    int res = minCut(str);
    System.out.println(str);
    System.out.println(res);
  }
}
