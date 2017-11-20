package darkRealm;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

//  #300. Longest Increasing Subsequence
//  Given an unsorted array of integers, find the length of longest increasing subsequence.
//  For example,
//  Given [10, 9, 2, 5, 3, 7, 101, 18],
//  The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than
//  one LIS combination, it is only necessary for you to return the length.
//  Your algorithm should run in O(n2) complexity.
//  Follow up: Could you improve it to O(n log n) time complexity?


  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] res = new int[nums.length];
    Arrays.fill(res, 1);
    int max = 1, longest = 1;
    for (int i = 1; i < nums.length; i++) {
      max = res[i];
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          max = Math.max(res[j] + 1, max);
        }
      }
      res[i] = max;
      longest = Math.max(max, longest);
    }
    return longest;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
    int[] nums = new int[]{0};
    int res = lengthOfLIS(nums);
    System.out.println("R : " + res);
  }
}
