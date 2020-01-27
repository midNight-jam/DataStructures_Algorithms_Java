package darkRealm;

import java.util.Arrays;

public class NonDecreasingArray {

//  665. Non-decreasing Array
//  Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
//  We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
//  Example 1:
//  Input: [4,2,3]
//  Output: True
//  Explanation: You could modify the first
//  4
//  to
//  1
//  to get a non-decreasing array.
//  Example 2:
//  Input: [4,2,1]
//  Output: False
//  Explanation: You can't get a non-decreasing array by modify at most one element.
//  Note: The n belongs to [1, 10,000

  public static boolean checkPossibilityBASIC(int[] nums) {
    if (nums == null || nums.length < 3) return true;
    boolean modif = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] <= nums[i]) continue;
      if (modif) return false;
      modif = true;

      // if i is still 1 means first element is higher than second "OR" we have to adj the prev
      if (i < 2 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i]; // level prev with current
      else nums[i] = nums[i - 1]; //level current with prev
    }

    return true;
  }

  public static boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        count++;
        if (count > 1) return false; // already raised once

        if (i > 0) {
          if (nums[i - 1] < nums[i + 1]) // if this is a dip, level it by using prev element
            nums[i] = nums[i - 1];
          else  // if this is a high, raise the next element to same height
            nums[i + 1] = nums[i];
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{4, 2, 3};
//    int[] nums = new int[]{3, 4, 2, 3};
//    int[] nums = new int[]{-1, 4, 2, 3};
    int[] nums = new int[]{3, 2, 4, 3};
    boolean res = checkPossibility(nums);
    System.out.println("A: " + Arrays.toString(nums));
    System.out.println("R : " + res);
  }
}
