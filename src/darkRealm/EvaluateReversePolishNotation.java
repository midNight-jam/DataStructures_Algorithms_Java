package darkRealm;

import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {


//  150. Evaluate Reverse Polish Notation
//  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//  Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//      Note:
//
//  Division between two integers should truncate toward zero.
//  The given RPN expression is always valid. That means the expression would always evaluate to a result and there
//  won't be any divide by zero operation.
//  Example 1:
//
//  Input: ["2", "1", "+", "3", "*"]
//  Output: 9
//  Explanation: ((2 + 1) * 3) = 9
//  Example 2:
//
//  Input: ["4", "13", "5", "/", "+"]
//  Output: 6
//  Explanation: (4 + (13 / 5)) = 6
//  Example 3:
//
//  Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//  Output: 22
//  Explanation:
//      ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//      = ((10 * (6 / (12 * -11))) + 17) + 5
//      = ((10 * (6 / -132)) + 17) + 5
//      = ((10 * 0) + 17) + 5
//      = (0 + 17) + 5
//      = 17 + 5
//      = 22


  public static int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length < 1) return 0;

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if (isOp(tokens[i])) {
        int b = stack.pop();
        int a = stack.pop();
        int r = doOp(a, b, tokens[i]);
        stack.push(r);
      } else
        stack.push(Integer.parseInt(tokens[i]));
    }
    return stack.pop();
  }

  private static boolean isOp(String o) {
    return (o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/"));
  }

  private static int doOp(int a, int b, String op) {
    if (op.equals("+"))
      return a + b;
    else if (op.equals("-"))
      return a - b;
    else if (op.equals("*"))
      return a * b;
    else if (op.equals("/"))
      return a / b;
    else return 0;
  }

  public static void main(String[] args) {
    String[] tokens = new String[]{"1000000","0","/"};
//    String[] tokens = new String[]{"2", "1", "+", "3", "*"};
//    String[] tokens = new String[]{"4", "13", "5", "/", "+"};
//    String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    int res = evalRPN(tokens);
    System.out.println(Arrays.toString(tokens));
    System.out.println(res);
  }
}
