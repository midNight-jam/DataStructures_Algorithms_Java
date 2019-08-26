package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

//  22. Generate Parentheses
//  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//  For example, given n = 3, a solution set is:
//
//      [
//      "((()))",
//      "(()())",
//      "(())()",
//      "()(())",
//      "()()()"
//      ]

  static List<String> res;

  
//   The total number of valid parentheses is a Catalan number,
//  Nth catalan number = 2n! / ((n+1)! * n!)
// So time complexity should be O(C(2n,n)/(n+1)).

  public static List<String> generateParenthesis(int n) {
    res = new ArrayList<>();
    if (n < 1) return res;
    char[] arr = new char[2 * n];
    helper(n, n, arr, 0);
    return res;
  }

  private static void helper(int left, int right, char[] arr, int index) {
    if (left + right == 0) {
      res.add(new String(arr));
      return;
    }
    if (left > 0) {
      arr[index] = '(';
      helper(left - 1, right, arr, index + 1);
    }
    if (right > left) {
      arr[index] = ')';
      helper(left, right - 1, arr, index + 1);
    }
  }

  public static void main(String[] args) {
    int n = 4;
    List<String> res = generateParenthesis(n);
    System.out.println(n);
    System.out.println(res);
  }
}
