package darkRealm;

import java.util.Stack;

public class ValidParanthesis {

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
