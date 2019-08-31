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
    if (T == null || T.length < 1) return new int[0];
    if (T.length < 2) return new int[]{0};
    int[] res = new int[T.length];

    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{0, T[0]}); // tuple of index & temp
    for (int i = 1; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > stack.peek()[1]) {
        int[] tt = stack.pop();
        res[tt[0]] = i - tt[0];
      }
      stack.push(new int[]{i, T[i]});
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
