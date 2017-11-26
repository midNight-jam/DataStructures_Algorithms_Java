package darkRealm;

import java.util.Arrays;

public class HouseRobberII {

//  #213. House Robber II
//  After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
//  not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house
//  is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the
//  previous street.
//  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
//  of money you can rob tonight without alerting the police.

  public static int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    //Same intuition as HouseRobberI but now as the houses are in circle, we cannot rob last house if we rob first
    // and we cannot rob first if we rob last, so we solve this problem twice once with 0 to n-2 and next from 1 to n-1
    int startingFirstHouse = helper(nums, 0, nums.length - 2);
    int endingLastHouse = helper(nums, 1, nums.length - 1);
    return Math.max(startingFirstHouse, endingLastHouse);
  }

  private static int helper(int[] nums, int start, int end) {
    int[] dp = new int[nums.length - 1];
    dp[0] = nums[start];
    for (int i = 1; i < dp.length; i++) {
      int twoBefore = i - 2 > -1 ? dp[i - 2] : 0;
      dp[i] = Math.max(dp[i - 1], twoBefore + nums[start + i]);
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 1, 2};
//    int[] arr = new int[]{1, 2, 1, 1};
    int[] arr = new int[]{1, 1, 1, 2};
//    int[] arr = new int[]{1, 1};
    int res = rob(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(res);
  }
}
