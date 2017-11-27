package darkRealm;

import java.util.Arrays;

public class JumpGame {

//  #55. Jump Game  ::: Complexity  - Time : O(n) ,   Space : O(n)
//  Given an array of non-negative integers, you are initially positioned at the first index of the array.
//  Each element in the array represents your maximum jump length at that position.
//  Determine if you are able to reach the last index.
//  For example:
//  A = [2,3,1,1,4], return true.
//
//  A = [3,2,1,0,4], return false.


  public static boolean canJump(int[] nums) {
    int max = nums[0];  // at first we can max reach nums[0]
    for(int i = 0; i < nums.length; i++){
      if(i > max) return false; // for any i we cannot reach return false
      max = Math.max(max, i + nums[i]);
    }
    return true;
  }
//  It is a must to go through this explaination I learned a lot!
//  https://leetcode.com/problems/jump-game/solution/#nodebb-comments
  public static boolean canJump_OLD(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    boolean[] goodPosition = new boolean[nums.length];
    int lastGoodPosition = nums.length - 1;
    goodPosition[lastGoodPosition] = true;
    for (int i = nums.length - 2; i >= 0; i--)
      if (i + nums[i] >= lastGoodPosition) {
        goodPosition[i] = true;
        lastGoodPosition = i;
      }

    return goodPosition[0];
  }

  // This is brute force approach with memoized, gets TLE
  private static boolean helper_jump(int[] nums) {
    int[] memo = new int[nums.length];
    memo[nums.length - 1] = 1;
    for (int start = nums.length - 2; start >= 0; start--) {
      int maxJump = Math.min(start + nums[start], nums.length - 1);
      for (int nextJump = start + 1; nextJump <= maxJump; nextJump++) {
        if (memo[nextJump] == 1) {
          memo[start] = 1;
          break;
        }
      }
    }
    return memo[0] == 1;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{2, 3, 1, 4, 4};
//    int[] nums = new int[]{2, 0};
//    int[] nums = new int[]{2, 3, 1, 1, 4};
//    int[] nums = new int[]{3, 2, 1, 0, 4};
//    int[] nums = new int[]{1, 2, 3};
    int[] nums = new int[]{9, 4, 2, 1, 0, 2, 0};
    boolean res = canJump(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("R : " + res);
  }
}
