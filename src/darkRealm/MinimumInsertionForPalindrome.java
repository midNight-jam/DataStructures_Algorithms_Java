package darkRealm;

public class MinimumInsertionForPalindrome {


//  #Minimum insertions to form a palindrome    :::   Complexity  - Time :O(n^2),   Space : O(n^2)
//  Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
//  Before we go further, let us understand with few examples:
//  ab: Number of insertions required is 1. bab
//  aa: Number of insertions required is 0. aa
//  abcd: Number of insertions required is 3. dcbabcd
//  abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
//  abcde: Number of insertions required is 4. edcbabcde

  public static int minInsertionForPalindrome(String s) {
    if (s == null || s.length() == 0) return 0;
    // Trick is to get the Longest Common Subsequence of the string with its reverse, this gives - l
    // Now, min insertion required will be (length - l)
    int l = LongestCommonSubsequence.longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    int minInsertion = s.length() - l;
    return minInsertion;
  }

  public static void main(String[] args) {
    String s = "abcda"; //palindrome with least insertion will be - a'dc'bcda
    int res = minInsertionForPalindrome(s);
    System.out.println("S : " + s);
    System.out.println("R : " + res);
  }
}
