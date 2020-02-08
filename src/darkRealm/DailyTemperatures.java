package darkRealm;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

//  739. Daily Temperatures
//  Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days
//  you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//
//  For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
//  your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//  Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer
//  in the range [30, 100].

  public static int[] dailyTemperatures(int[] T) {
    if (T == null || T.length < 1) return T;
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[T.length];

    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        int prev = stack.pop();
        res[prev] = i - prev;
      }
      stack.push(i);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    int[] res = dailyTemperatures(T);
    System.out.println(Arrays.toString(T));
    System.out.println(Arrays.toString(res));
  }
}
