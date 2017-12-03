package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {

   /*  #239 Sliding Window Maximum
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
    very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].
    Note:
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
    Follow up:
    Could you solve it in linear time?
   */

  public static int[] slidingWindowMaximum(int[] arr, int k) {
    if (arr == null || arr.length == 0) return new int[]{};
    int windows = arr.length - k + 1; // these many number of windows
    int[] res = new int[windows];
    // stores the indexes
    LinkedList<Integer> deque = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      // means current head will now move out of the window [ k = i - headIndex], then remove the head
      if (!deque.isEmpty() && deque.peek() == i - k)
        deque.poll();

      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i])
        deque.removeLast(); // why removing last, because a new max has arrived & we cannot hold smaller elements now,
      // so remove all smaller

      deque.add(i);
      if (i + 1 >= k) // means window has expanded
        res[i + 1 - k] = arr[deque.peek()];

    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] res = slidingWindowMaximum(nums, k);
    System.out.println(Arrays.toString(res));
  }
}
