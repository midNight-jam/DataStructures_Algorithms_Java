package darkRealm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferentWaysToAddParentheses {


//  241. Different Ways to Add Parentheses
//  Given a string of numbers and operators, return all possible results from computing all the different possible
//  ways to group numbers and operators. The valid operators are +, - and *.
//
//  Example 1:
//
//  Input: "2-1-1"
//  Output: [0, 2]
//  Explanation:
//      ((2-1)-1) = 0
//      (2-(1-1)) = 2
//  Example 2:
//
//  Input: "2*3-4*5"
//  Output: [-34, -14, -10, -10, 10]
//  Explanation:
//      (2*(3-(4*5))) = -34
//      ((2*3)-(4*5)) = -14
//      ((2*(3-4))*5) = -10
//      (2*((3-4)*5)) = -10
//      (((2*3)-4)*5) = 10


  public static List<Integer> diffWaysToCompute(String s) {
    if (s == null || s.length() < 1) return new ArrayList<>();

    List<String> ops = new ArrayList<>();

    // first parse the input to seperate out the numbers & operators
    for (int i = 0; i < s.length(); i++) {
      int j = i;
      // capture the integer
      while (j < s.length() && Character.isDigit(s.charAt(j)))
        j++;
      String num = s.substring(i, j);
      ops.add(num);
      // capture the operator
      if (j != s.length())
        ops.add(s.charAt(j) + "");
      i = j;
    }

    List<Integer> res = helper(ops, 0, ops.size() - 1);
    Collections.sort(res);
    return res;
  }

  private static List<Integer> helper(List<String> ops, int start, int end) {
    List<Integer> list = new ArrayList<>();
    // base case parse the Integer
    if (start == end) {
      int l = Integer.parseInt(ops.get(start));
      list.add(l);
      return list;
    }

    // operators will be on alternate indexes ["123", "+", "34", "*", "567", "-", "89"]
    for (int i = start + 1; i <= end - 1; i += 2) {
      String op = ops.get(i);
      List<Integer> left = helper(ops, start, i - 1);
      List<Integer> right = helper(ops, i + 1, end);
      // cartesian product (similar to creating all the possible trees)
      for (Integer l : left) {
        for (Integer r : right) {
          if (op.equals("+")) {
            list.add(l + r);
          } else if (op.equals("-")) {
            list.add(l - r);
          } else if (op.equals("*")) {
            list.add(l * r);
          }
        }
      }
    }

    return list;
  }

  public static void main(String[] args) {
    String ops = "2*3-4*5";
    List<Integer> res = diffWaysToCompute(ops);
    System.out.println(res);
  }
}
