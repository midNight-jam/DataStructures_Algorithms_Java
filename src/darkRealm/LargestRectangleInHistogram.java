package darkRealm;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

//  #84. Largest Rectangle in Histogram ::: Complexity : Time - O(n), Space - O(n)
//  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//  Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//  The largest rectangle is shown in the shaded area, which has area = 10 unit.
//  For example,
//  Given heights = [2,1,5,6,2,3],
//  return 10.

  public static int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    int max = 0;
    // Intuition is to use stack, pop every time we get a smaller bar against the top of stack and calculate the area
    Stack<Integer> stack = new Stack<>();
    int left = 0, top = 0, area = 0, h = 0;
    for (int i = 0; i <= heights.length; i++) {
      h = i == heights.length ? 0 : heights[i];
      // if its the first bar, of it is greater than the previous bar in the stack push and move ahead
      if (stack.isEmpty() || h >= heights[stack.peek()])
        stack.push(i);
        // pop from the stack till we find a bar whose height is lesser than the current bar, this bar will give us the
        // left edge till where we have a proper rectangle, we determine the left edge if the stack is empty then we take
        // the left edge as the current index itself as there is no point in searching towards left, and if the stack is
        // not empty means we have found a bar on left side which is smaller than the current bar, thus get the range from
        // current index to before we get the smaller bar on left, which is current - stac.peek() - 1
        // for example [2,1,5,6,2], for 2 left edge will be 5 , because 1 is the first bar smaller than the current bar
        // and minus 1, bcoz this bar is smaller so it will not take part in rectangle
      else {
        top = stack.pop();
        left = stack.isEmpty() ? i : i - stack.peek() - 1;
        area = heights[top] * left;
        max = Math.max(area, max);
        i--; // this is applied so that i == length condition can be met which will cause the stack to become empty once
        // we have reached the end of array, as then it will assign height as 0, which will cause the pops
      }
    }
    return max;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{2, 1, 5, 6, 2, 3};
    int[] nums = new int[]{1};
    int res = largestRectangleArea(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("M ; " + res);
  }
}
