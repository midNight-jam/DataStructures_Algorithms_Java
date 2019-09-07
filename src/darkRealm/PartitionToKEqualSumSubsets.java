package darkRealm;

public class PartitionToKEqualSumSubsets {

//  TIME COMPLEXITY : O(K x 2^N)
//  698. Partition to K Equal Sum Subsets
//  Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into
//  k non-empty subsets whose sums are all equal.
//
//  Example 1:
//  Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//  Output: True
//  Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//
//  Note:
//      1 <= k <= len(nums) <= 16.
//      0 < nums[i] < 10000.

  /*
   *we dont necessarily need to create the buckets & fill them with nums bcoz the order of filled buckets doesnt
   * matter, just if all of them are filled that matters
   * */

  static int bucketCapacity;

  public static boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length < k) return false;
    int total = 0;
    for (int n : nums)
      total += n;

    double bMax = total * 1.0 / k;
    if (bMax % 1 != 0) return false;
    bucketCapacity = (int) bMax;

    boolean[] visited = new boolean[nums.length];
    return helper(0, 0, k, nums, visited);
  }

  private static boolean helper(int start, int sum, int k, int[] nums, boolean[] visited) {
    if (k == 0) {
      System.out.println("We have filled all the buckets with MaxCapacity");
      return true;
    }

    if (sum > bucketCapacity) return false;

    if (sum == bucketCapacity) {
      // Start again the same problem for k - 1
      return helper(0, 0, k - 1, nums, visited);
    }

    for (int i = start; i < nums.length; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      boolean valid = helper(i + 1, sum + nums[i], k, nums, visited);
      if (valid) return true;
      visited[i] = false;
    }

    return false;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 1, 1};
//    int k = 2;
//    boolean res = canPartitionKSubsets(nums, k);
//    System.out.println(res);
//    System.out.println(!res ? "Pass" : "Fail");

    int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
    int k = 4;
    boolean res = canPartitionKSubsets(nums, k);
    System.out.println(res);
    System.out.println(res ? "Pass" : "Fail");
  }
}
