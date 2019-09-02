public class PalindromicSubStrings {

//647. Palindromic Substrings
//  Given a string, your task is to count how many palindromic substrings in this string.
//  The substrings with different start indexes or end indexes are counted as different substrings even they consist of
//  same characters.
//
//  Example 1:
//  Input: "abc"
//  Output: 3
//  Explanation: Three palindromic strings: "a", "b", "c".
//
//  Example 2:
//  Input: "aaa"
//  Output: 6
//  Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//  Note:
//  The input string length won't exceed 1000.

  public static int countSubstrings(String s) {
    int res = 0;
    if (s == null || s.length() < 1) return res;

    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int start = 0; start < s.length(); start++) {
      int end = start;
      dp[start][end] = true; // as each char is a palindrome by itself
    }

    // Initial state is each char is a plaindrome in itslef,  thats why above initiliasation
    // To acheieve the next state,  we add two chars (at the start & end) to the initial state &
    // check if then new state is also a palindrome, how do we check if the new state is also a
    // palindrome, firstly both start and enc chars should be same & secondly the substring among them (prev state)
    // should be a palindrome , the info of prev state comes from dp[start + 1] [end - 1] (from down left), thats why
    // we dont have to calculate isPalindrome on each substring. Also, is start & end are same & adjacent then they are \
    // already palidrone & we dont need to look at prev state.

    // we cover all states (substrings) of smaller len b4 going to higher len, because then only our knowledge of all
    // prev valid states will be complete, thats why outer loop defines end (or could be length, but then will start from 1)
    // and start is from 0, so that we cover all substring  0-0, 0-1, 0-2, 0-3, before calculating state of 0-4  (- = to)
    for (int end = 0; end < s.length(); end++) {
      for (int start = 0; start <= end; start++) {
        if (s.charAt(start) == s.charAt(end)) {
          boolean areAdjacent = end - start < 2;
          boolean inBound = start + 1 < s.length() && end - 1 >= 0;
          boolean isSubStringBetweenStartAndEndIsPalindrome = inBound ? dp[start + 1][end - 1] : false;
          if (areAdjacent || isSubStringBetweenStartAndEndIsPalindrome) {
            res++; // increase substring count as,
            dp[start][end] = true; // this substring is a palindrome
          }
        }
      }
    }
    return res;
  }
  
  
 // another variation with easy to understand loop 
 public int countSubstrings2(String s) {
    if(s == null || s.length() < 1) return 0;
    int n = s.length();
    boolean [][] dp = new boolean[n][n];
    int res = n; // each char will be a palindrome in itself
    
    for(int i = 0; i < dp.length; i++)
      dp[i][i] = true;
    
    // we start from bottom right & work our way up
    for(int row = n -1; row >=0; row--){
      int start = row;
      int end = row;
      while(end < n){
        if(s.charAt(start) == s.charAt(end)){
          boolean areAdjacent = start + 1 == end;
          boolean inBetweenIsInPalindrome= start + 1 < end ? dp[start+1][end-1] : false;
          if(areAdjacent || inBetweenIsInPalindrome){
            dp[start][end] = true;
            res++;
          }
        }
        end++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String s = "abba";
//    String s = "aaaa";
    int res = countSubstrings(s);
    System.out.println(s);
    System.out.println(res);
  }
}
