package darkRealm;

public class DecodeWays {

//  #91. Decode Ways  ::: Complexity - Time : O(n), Space : O(n+1)
//  A message containing letters from A-Z is being encoded to numbers using the following mapping:
//      'A' -> 1
//      'B' -> 2
//      ...
//      'Z' -> 26
//  Given an encoded message containing digits, determine the total number of ways to decode it.
//  For example,
//  Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//  The number of ways decoding "12" is 2.
//  Given encoded message "1225", it could be decoded as
//  1,2,2,5 -> ABBE
//  12,2,5 -> LBE
//  1,22,5 -> AVE
//  1,2,25 -> ABY
//  12,25 -> LY
//  The number of ways decoding "1225" is 5.

  public static int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    int n = s.length();
    int[] dp = new int[n + 1];
    // Intuition is, this problem is like climbing stairs problem, but instead of having no of steps here we have alpahbets
    // Now, the no of ways at dp[n], will depend on dp[n-1] and dp[n-2]
    // We have to take only this and previous char in consideration, if this char is < 10 and > 0 then we can decode it
    // into a alphabet, and if this and previous char together are bigger > 10 and  < 27 then we can use one alphabet to
    // decode it.

    dp[0] = 1; // this is required for i-1 & i - 2 of dp to work correctly
    // if the first char is not '0', then we have one way of decode it in to alphabets
    dp[1] = (s.charAt(0) != '0') ? 1 : 0;
    int oneDigit = 0, twoDigit = 0;
    for (int i = 2; i <= n; i++) {
      oneDigit = s.charAt(i - 1) - '0';
      if (oneDigit != 0) // oneDigit is not 0, then use previous result, else its 0, because we cannot encode '0' char
        dp[i] += dp[i - 1];
      twoDigit = Integer.parseInt(s.substring(i - 2, i));
      // if previous two char can be reprsented using ABC.., ie they are not bigger than 26 & we have > 10 check to handle
      // 0's in between the string
      if (twoDigit > 9 && twoDigit < 27)
        dp[i] += dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
//    String s = "0";
//    String s = "1";
//    String s = "12";
//    String s = "10";
//    String s = "11";
    String s = "1225";
    int c = numDecodings(s);
    System.out.println("S : " + s);
    System.out.println("c : " + c);
  }
}
