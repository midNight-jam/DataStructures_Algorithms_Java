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
    int [] minJump = new int[nums.length];

    // Idea is very similar to JumpGameI
    Arrays.fill(minJump, Integer.MAX_VALUE);
    minJump[0] = 0;
    for(int i = 0; i < nums.length; i++){
      int next = nums[i];
      // calculate + update min jump for all the indexes that we can reach from here
      for(int j = 1; j <= next && j + i < nums.length; j++){
        minJump[i+j] = Math.min(minJump[i+j], minJump[i] + 1);
      }
    }

    System.out.println(Arrays.toString(minJump));
    return minJump[nums.length - 1];
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{2, 3, 1, 1, 4};
    int[] nums = new int[]{1, 1, 2, 1, 4};
    int res = jump(nums);
    System.out.println(res);
  }
}
