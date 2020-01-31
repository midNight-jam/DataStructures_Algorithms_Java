package darkRealm;

import java.util.Arrays;

public class MaximumAverageSubarrayI {

//  643 -  Maximum Average Subarray I
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
    if (nums == null || k <= 0 || k > nums.length) return 0.0;
    double sum = 0;
    double avg = 0.0;

    for (int i = 0; i < k; i++)
      sum += nums[i];

    avg = sum / k;
    double max = avg;

    for (int i = k; i < nums.length; i++) {
      sum -= nums[i - k];
      sum += nums[i];
      avg = sum / k;
      max = Math.max(avg, max);
    }
    return max;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{1, 12, -5, -6, 50, 3};
//    int k = 4;
    int[] nums = new int[]{-1};
    int k = 1;
    double res = findMaxAverage(nums, k);
    System.out.println("N : " + Arrays.toString(nums) + "\nK: " + k + "\nR: " + res);
  }
}