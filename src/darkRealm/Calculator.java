package darkRealm;

import java.util.Stack;

/**
 * Created by Jayam on 3/31/2017.
 */
public class Calculator {

  public static int calculate(String expression) {
    if (expression == null || expression.length() == 0)
      return 0;
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';

    for (int i = 0; i < expression.length(); i++) {
      if (Character.isDigit(expression.charAt(i)))
        num = num * 10 + expression.charAt(i) - '0';

      // if not a space * not a digit then it is a operator
      if ((expression.charAt(i) != ' ' && !Character.isDigit(expression.charAt(i))) || i == expression.length() - 1) {
        if (sign == '+')
          stack.push(num);
        else if (sign == '-')
          stack.push(-num);
        else if (sign == '*')
          stack.push(stack.pop() * num);
        else if (sign == '/')
          stack.push(stack.pop() / num);

        sign = expression.charAt(i);
        num = 0;
      }
    }
    int result = 0;
    for (int i : stack)
      result += i;
    return result;
  }

  public static void main(String[] args) {
    String exp = " 2 + 3 * 4";
    int res = calculate(exp);
    System.out.println(exp + "  =  " + res);
  }
}
