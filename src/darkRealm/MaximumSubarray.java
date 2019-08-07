package darkRealm;

public class MaximumSubarray {

//  53. Maximum Subarray
//  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
//  sum and return its sum.
//
//  Example:
//
//  Input: [-2,1,-3,4,-1,2,1,-5,4],
//  Output: 6
//  Explanation: [4,-1,2,1] has the largest sum = 6.
//  Follow up:
//
//  If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
//  which is more subtle.
  public int maxSubArray(int[] nums) {
    int res = Integer.MIN_VALUE;
    int sum = 0;
    // if at any time sum goes -ve, reset it
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      res = Math.max(res, sum);
      if (sum < 0)
        sum = 0;
    }

    return res;
  }

  public static void main(String[] args) {

  }

}
