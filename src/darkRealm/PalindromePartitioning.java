package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

//  131. Palindrome Partitioning
//  Given a string s, partition s such that every substring of the partition is a palindrome.
//  Return all possible palindrome partitioning of s.
//      Example:
//  Input: "aab"
//  Output:
//      [
//      ["aa","b"],
//      ["a","a","b"]
//      ]
//

  public static List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s == null || s.length() < 1) return res;
    helper(res, new ArrayList<>(), s, 0);
    return res;
  }

  // Idea : try to generate palindrome starting from each index of length 1 to end, if you have one such palindrome
  // substring add it to result and try to achieve more palindrome strings from the rest of the string.
  // Remove this palindrome substring from the result when backtracking.
  private static void helper(List<List<String>> res, List<String> temp, String s, int start) {
    if (start == s.length()) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (isPalindrome(s, start, i)) {
        temp.add(s.substring(start, i + 1));
        helper(res, temp, s, i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private static boolean isPalindrome(String s, int low, int high) {
    char[] arr = s.toCharArray();
    while (low < high && arr[low] == arr[high]) {
      low++;
      high--;
    }
    return low >= high;
  }

  public static void main(String[] args) {
    String s = "abbab";
    List<List<String>> res = partition(s);
    System.out.println(s);
    System.out.println(res);
  }
}
