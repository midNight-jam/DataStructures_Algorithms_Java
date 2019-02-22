package darkRealm;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

//  921. Minimum Add to Make Parentheses Valid
//  Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any
//  positions ) so that the resulting parentheses string is valid.
//
//  Formally, a parentheses string is valid if and only if:
//  It is the empty string, or
//  It can be written as AB (A concatenated with B), where A and B are valid strings, or
//  It can be written as (A), where A is a valid string.
//  Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
//
//  Example 1:
//
//  Input: "())"
//  Output: 1
//  Example 2:
//
//  Input: "((("
//  Output: 3
//  Example 3:
//
//  Input: "()"
//  Output: 0
//  Example 4:
//
//  Input: "()))(("
//  Output: 4

  public static int minAddToMakeValid(String S) {
    if (S == null || S.length() < 1) return 0;
    Stack<Character> stack = new Stack<>();
    stack.push('#');

    for (char c : S.toCharArray()) {
      if (c == ')' && stack.peek() == '(') {
        stack.pop();
        continue;
      } else
        stack.push(c);
    }

    return stack.size() - 1;
  }

  public static void main(String[] args) {
    String s = "(())";
    int res = minAddToMakeValid(s);
    System.out.println(s);
    System.out.println(res);
  }
}
