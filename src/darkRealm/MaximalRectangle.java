package darkRealm;

import java.util.Stack;

public class MaximalRectangle {


//  #85. Maximal Rectangle ::: Complexity - Time : O(n^2), Space : O(cols)
//  Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//  For example, given the following matrix:
//      1 0 1 0 0
//      1 0 1 1 1
//      1 1 1 1 1
//      1 0 0 1 0
//
//    Return 6.

  public static int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int max = 0;
    // Intuition is to proceed row by row from top, and create update the height array,
    // and after updating the height array for current row call the subroutine maxRectnagle in Histogram to get the max
    // area till now. One more point in order to save space, if rows>>>cols we cans transpose this problem and develop
    // histogram per col not by per row

    int[] heights = new int[matrix[0].length]; // an array for number of columns
    // for each row get update the heights array and get the max rectangle area
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        // if we encounter a '0' replace the heigth for that column with 0, else increment the height with 1
        if (matrix[i][j] == '0') heights[j] = 0;
        else heights[j]++;
      }
      // after updating heights for this row, get the maxArea for current heights
      max = Math.max(max, getMaxRectangleHistogram(heights));
    }
    return max;
  }

  private static int getMaxRectangleHistogram(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int maxRectArea = 0;
    Stack<Integer> stack = new Stack<>();
    // We will keep track of the indexes that are bigger than the current height
    // if the current height is greater than the heigth at stack top, push current height
    // else keep poping and calculating the area till we get a height that is smaller than the current height, because it
    // will be the edge at which the valid rectangle will end.
    int top = 0, left, h = 0;
    for (int i = 0; i <= nums.length; i++) {
      h = i == nums.length ? 0 : nums[i];
      if (stack.isEmpty() || h >= nums[stack.peek()])
        stack.push(i);
      else {
        top = stack.pop();
        left = stack.isEmpty() ? i : i - stack.peek() - 1; // equals to i deals with case when heights are same
        maxRectArea = Math.max(maxRectArea, nums[top] * left);
        i--;
      }
    }
    return maxRectArea;
  }

  public static void main(String[] args) {
    char[][] matrix = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'},
    };
    int res = maximalRectangle(matrix);
    System.out.println("M : " + res);
  }
}
