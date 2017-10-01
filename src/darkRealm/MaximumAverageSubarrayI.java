package darkRealm;

import java.util.Arrays;

public class MaximumAverageSubarrayI {
// #643 -  Maximum Average Subarray I
//  Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum
//  average value. And you need to output the maximum average value.
//      Example 1:
//  Input: [1,12,-5,-6,50,3], k = 4
//  Output: 12.75
//  Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//  Note:
//      1 <= k <= n <= 30,000.
//  Elements of the given array will be in the range [-10,000, 10,000].


  public static double findMaxAverage(int[] nums, int k) {
    if (k > nums.length) return Double.MIN_VALUE;
    double maxAverage = Double.MIN_VALUE, sum = 0.0;
    int start = 0, end = 0;
    while (end < k) {
      sum += nums[end];
      end++;
    }
    maxAverage = sum / k;

    while (end < nums.length) {
      sum -= nums[start];
      start++;
      sum += nums[end];
      end++;
      maxAverage = Math.max(maxAverage, sum / k);
    }
    return maxAverage;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 12, -5, -6, 50, 3};
    int k = 4;
    double res = findMaxAverage(nums, k);
    System.out.println("N : " + Arrays.toString(nums) + "\nK: " + k + "\nR: " + res);
  }
}