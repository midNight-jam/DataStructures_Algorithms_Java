package darkRealm;

public class BurstBalloons {

//  #312. Burst Balloons  ::: Complexity - Time : O(n^3) , Space : O(n^2)
//  Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
//  You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
//  coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//  Find the maximum coins you can collect by bursting the balloons wisely.
//  Note:
//      (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
//      (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//  Example:
//  Given [3, 1, 5, 8]
//  Return 167
//  nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

  public static int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[][] dp = new int[nums.length][nums.length];
    //Explanation : https://www.youtube.com/watch?v=IFNibRVgFBo
    for (int len = 1; len <= nums.length; len++) {
      // Subaary of lens 1, then 2 ... n
      // for each subarray calculate the maxcoin
      for (int start = 0; start <= nums.length - len; start++) {
        int end = start + len - 1;
        // calculate MaxCoin for each ballon in this subarray assuming it burst at last, range here is the subarray
        for (int i = start; i <= end; i++) {
          int leftMaxCoinFromWithinRange = i != start ? dp[start][i - 1] : 0;
          int rightMaxCoinFromWithinRange = i != end ? dp[i + 1][end] : 0;
          int leftOutSideRange = start - 1;
          int rightOutSideRange = end + 1;
          int selfLastBurstSoMaxCoinLeftRightFromOutSideRange = getCoin(nums, leftOutSideRange) * nums[i] * getCoin(nums, rightOutSideRange);
          int maxCoins = selfLastBurstSoMaxCoinLeftRightFromOutSideRange + leftMaxCoinFromWithinRange + rightMaxCoinFromWithinRange;
          dp[start][end] = Math.max(maxCoins, dp[start][end]);
        }
      }
    }

    return dp[0][nums.length - 1]; // result is at top right
  }

  private static int getCoin(int[] nums, int i) {
    if (i < 0 || i >= nums.length) return 1;
    return nums[i];
  }

  public static void main(String[] args) {
    int[] ballons = new int[]{3, 1, 5, 8};
    int max = maxCoins(ballons);
    System.out.println("max : " + max);
  }
}