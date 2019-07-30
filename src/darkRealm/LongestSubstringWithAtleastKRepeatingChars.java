package darkRealm;

public class LongestSubstringWithAtleastKRepeatingChars {

  /*
  #395. Longest Substring with At Least K Repeating Characters
  Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
  Example 1:
  Input:
  s = "aaabb", k = 3
  Output:
      3
  The longest substring is "aaa", as 'a' is repeated 3 times.
      Example 2:
  Input:
  s = "ababbc", k = 2
  Output:
      5
  The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
  */

  public static int longestSubstring(String s, int k) {
    if(s == null || s.length() < 1 || k < 0) return 0;
    int res;
    char [] arr = s.toCharArray();
    res = helper(0, arr.length  -1, k, arr);
    return res;
  }
  
  // Split the input array in 2 halves whenever we find a char whose frequency is < k
  // Solve recursively for both the halves & return the max 
  // If we dont find any char that is < k  frequent then the current portion that we are looking at
  // satisfies the criteria completely, thus return its length (end - start + 1)
  private static int helper(int start, int end, int k, char [] arr){
    if(end - start + 1 < k) return 0;
    int[] map = new int[26];
    for(int i = start; i <= end; i++)
      map[arr[i] - 'a']++;
    
    
    for(int i = start; i<= end; i++)
      if(map[arr[i] - 'a'] < k){
        int leftPart = helper(start, i - 1, k, arr);
        int rightPart = helper(i + 1, end, k, arr);
        return  Math.max(leftPart, rightPart);
      }
    
    return end - start + 1;
  }

  public static void main(String[] args) {
    String s = "aaabb";
    int k = 3;
    int res = longestSubstring(s, k);
    System.out.println(res);
  }
}
