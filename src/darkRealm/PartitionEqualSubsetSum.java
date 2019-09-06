package darkRealm;

public class PartitionEqualSubsetSum {

//  416. Partition Equal Subset Sum
//  Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
//  such that the sum of elements in both subsets is equal.
//
//      Note:
//  Each of the array element will not exceed 100.
//  The array size will not exceed 200.
//
//
//  Example 1:
//  Input: [1, 5, 11, 5]
//
//  Output: true
//  Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
//  Example 2:
//  Input: [1, 2, 3, 5]
//
//  Output: false
//  Explanation: The array cannot be partitioned into equal sum subsets.


  public static boolean canPartition(int[] nums) {
    /*
     * Similar to knapsack 0/1 problem, if we can reach the half sum using some coins than its determined that the array
     * can be divided in to 2 sets of same sum
     * */
    if (nums == null || nums.length < 1) return false;
    int totalSum = 0;
    for (int n : nums)
      totalSum += n;

    // cant split a odd sum
    if ((totalSum & 1) == 1) return false;

    int halfSum = totalSum / 2;
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][halfSum + 1];

    // sum of 0 without using any coins is always possible
    for (int i = 0; i < dp.length; i++)
      dp[i][0] = true;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        // either we achieve this sum without using this coin
        dp[i][j] = dp[i - 1][j];
        // or we achieve this sum  with using this coin only if thisSum - prevCoin amount is achievable
        if (j - nums[i - 1] >= 0)
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
      }
    }

    return dp[n][halfSum];
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2, 5};
//    boolean res = canPartition(nums);
//    System.out.println(res);
//    System.out.println(!res ? "Pass" : "False");

    int[] nums = new int[]{5, 1, 11, 5};
    boolean res = canPartition(nums);
    System.out.println(res);
    System.out.println(res ? "Pass" : "False");

  }
}
