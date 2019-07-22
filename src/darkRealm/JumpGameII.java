package darkRealm;

import java.util.Arrays;

public class JumpGameII {

//  45. Jump Game II
//  Given an array of non-negative integers, you are initially positioned at the first index of the array.
//  Each element in the array represents your maximum jump length at that position.
//
//  Your goal is to reach the last index in the minimum number of jumps.
//  Example:
//
//  Input: [2,3,1,1,4]
//  Output: 2
//  Explanation: The minimum number of jumps to reach the last index is 2.
//  Jump 1 step from index 0 to 1, then 3 steps to the last index.
//      Note:
//
//  You can assume that you can always reach the last index.

  public static int jump(int[] nums) {
    if (nums == null || nums.length < 1) return 0;
    int[] mins = new int[nums.length];
    // Idea is very similar to JumpGameI
    Arrays.fill(mins, Integer.MAX_VALUE);
    mins[0] = 0;
    int max = nums[0];
    int N = mins.length;
    for (int i = 0; i < N && i <= max; i++) {
      int dist = nums[i];
      // calculate + update min jump for all the indexes that we can reach from here
      for (int j = i + 1; j < N && dist > 0; j++, dist--) {
        if (mins[i] + 1 < mins[j])
          mins[j] = mins[i] + 1;
      }
      if (i + nums[i] > max) {
        max = i + nums[i];
      }
    }
    System.out.println(Arrays.toString(mins));
    return mins[N - 1];
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{2, 3, 1, 1, 4};
    int[] nums = new int[]{1, 1, 2, 1, 4};
    int res = jump(nums);
    System.out.println(res);
  }
}
