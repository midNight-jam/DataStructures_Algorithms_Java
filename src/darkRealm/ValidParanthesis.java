package darkRealm;

import java.util.Stack;

public class ValidParanthesis {

//  20. Valid Parentheses
//  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//  An input string is valid if:
//
//  Open brackets must be closed by the same type of brackets.
//  Open brackets must be closed in the correct order.
//  Note that an empty string is also considered valid.
//
//      Example 1:
//
//  Input: "()"
//  Output: true
//  Example 2:
//
//  Input: "()[]{}"
//  Output: true
//  Example 3:
//
//  Input: "(]"
//  Output: false
//  Example 4:
//
//  Input: "([)]"
//  Output: false
//  Example 5:
//
//  Input: "{[]}"
//  Output: true

  public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();
    char c;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else {
        if (stack.isEmpty() || stack.pop() != c)
          return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String str = "[]]";
    boolean res = isValid(str);
    System.out.println(" Str : " + str + "  valid : " + res);
  }
}
