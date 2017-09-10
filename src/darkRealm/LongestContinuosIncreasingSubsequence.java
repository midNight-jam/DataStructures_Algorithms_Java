package darkRealm;

import java.util.Arrays;

public class LongestContinuosIncreasingSubsequence {

//  Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
//  Example 1:
//  Input: [1,3,5,4,7]
//  Output: 3
//  Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
//  Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
//  Example 2:
//  Input: [2,2,2,2,2]
//  Output: 1
//  Explanation: The longest continuous increasing subsequence is [2], its length is 1.
//  Note: Length of the array will not exceed 10,000.

  public static int findLengthOfLCIS(int[] nums) {
    int max = 0;
    if (nums == null || nums.length == 0) return max;
    max = 1;
    int len = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        len++;
        max = Math.max(len, max);
      } else len = 1;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 5, 4, 7};
    int res = findLengthOfLCIS(arr);
    System.out.println("Arr  : " + Arrays.toString(arr));
    System.out.println("LCIS : " + res);
  }
}