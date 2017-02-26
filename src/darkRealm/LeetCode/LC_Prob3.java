package darkRealm.LeetCode;

import darkRealm.CTCI.Trees_and_Graphs.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

  public static int kthLargestElement(int[] nums, int k) {
    if (k < 1 || nums == null) {
      return 0;
    }

    return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
  }

  public static int getKth(int k, int[] nums, int start, int end) {

    int pivot = nums[end];

    int left = start;
    int right = end;

    while (true) {

      while (nums[left] < pivot && left < right) {
        left++;
      }

      while (nums[right] >= pivot && right > left) {
        right--;
      }

      if (left == right) {
        break;
      }

      swap(nums, left, right);
    }

    swap(nums, left, end);

    if (k == left + 1) {
      return pivot;
    } else if (k < left + 1) {
      return getKth(k, nums, start, left - 1);
    } else {
      return getKth(k, nums, left + 1, end);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static List<TNode> uniqueBinarySearchTrees(int n) {
    if (n < 1) return new ArrayList<>();
    return createTree(1, n);
  }

  private static List<TNode> createTree(int start, int end) {
    List<TNode> treeList = new ArrayList<>();
    if (start > end) {
      treeList.add(null);
      return treeList;
    }
    if (start == end) {
      List<TNode> list = new ArrayList<>();
      list.add(new TNode(start));
      return list;
    }
    for (int i = start; i <= end; i++) {
      List<TNode> left = createTree(start, i - 1);
      List<TNode> right = createTree(i + 1, end);
      // cartesian Product
      for (TNode lnode : left) {
        for (TNode rnode : right) {
          TNode node = new TNode(i);
          node.left = lnode;
          node.right = rnode;
          treeList.add(node);
        }
      }
    }
    return treeList;
  }
}