package darkRealm;

import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String str) {
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
}
