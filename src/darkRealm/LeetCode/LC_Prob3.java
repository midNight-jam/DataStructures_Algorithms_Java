package darkRealm.LeetCode;

import java.util.LinkedList;
import java.util.Stack;
/**
 * Created by Jayam on 2/22/2017.
 */
public class LC_Prob3 {
  /*  [Prob 517] Super Washing Machines
  *   You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
  *   For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine
  *   to one of its adjacent washing machines at the same time .
  *   Given an integer array representing the number of dresses in each washing machine from left to right on the line,
  *   you should find the minimum number of moves to make all the washing machines have the same number of dresses.
  *   If it is not possible to do it, return -1.
  *   Example1
  *   Input: [1,0,5]
  *   Output: 3
  *   Explanation:
  *   1st move:    1     0 <-- 5    =>    1     1     4
  *   2nd move:    1 <-- 1 <-- 4    =>    2     1     3
  *   3rd move:    2     1 <-- 3    =>    2     2     2
  * */
  public static int findMoves(int[] machines) {
    if (machines == null || machines.length == 0) return 0;
    int total = 0;
    for (int i = 0; i < machines.length; i++)
      total += machines[i];
    if (total % machines.length != 0) return -1;
    int bal = total / machines.length;
    int[] buckets = new int[machines.length];
    int maxDue = Integer.MIN_VALUE;
    for (int i = 0; i < machines.length; i++) {
      buckets[i] = machines[i] - bal;
      maxDue = Math.max(buckets[i], maxDue);
    }

    int maxShift = Integer.MIN_VALUE;

    for (int i = 1; i < machines.length; i++) {
      buckets[i] += buckets[i - 1];
      buckets[i - 1] = 0; // redundant not required
      maxShift = Math.max(Math.abs(buckets[i]), maxShift);
    }
    return Math.max(maxDue, maxShift);
  }

  public static int longestValidParanthesis(String str) {
    if (str == null || str.length() == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    int left = -1;
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') stack.push(i);
      else {
        if (stack.isEmpty()) left = i;
        else {
          stack.pop();
          if (stack.isEmpty())
            max = Math.max(max, i - left);
          else
            max = Math.max(max, i - stack.peek());
        }
      }
    }
    return max;
  }

  public static int[] slidingWindowMaximum(int[] arr, int k) {
    if (arr == null || arr.length == 0) return new int[]{};
    int max = Integer.MIN_VALUE, maxPrev = Integer.MIN_VALUE;
    int windows = arr.length - k + 1;
    int[] res = new int[windows];
    // stores the indexes
    LinkedList<Integer> deque = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      // couldnt get the real reason for this
      if (!deque.isEmpty() && deque.peek() == i - k) {
        deque.poll();
      }

      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
        deque.removeLast(); // why removing last, beause a new max has arrived & we cannot hold smaller elements now, so remove all smaller
      }

      deque.add(i);
      if (i + 1 >= k) {// means window has expanded
        res[i + 1 - k] = arr[deque.peek()];
      }
    }
    return res;
  }
}