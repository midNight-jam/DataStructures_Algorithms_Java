package darkRealm;

import java.util.Arrays;

public class WiggleSortII {

//  324. Wiggle Sort II
//  Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//  Example 1:
//  Input: nums = [1, 5, 1, 1, 6, 4]
//  Output: One possible answer is [1, 4, 1, 5, 1, 6].
//  Example 2:
//
//  Input: nums = [1, 3, 2, 2, 3, 1]
//  Output: One possible answer is [2, 3, 1, 3, 1, 2].
//  Note:
//  You may assume all input has valid answer.
//
//  Follow Up:
//  Can you do it in O(n) time and/or in-place with O(1) extra space?

  public static void wiggleSort(int[] nums) {
    if (nums == null || nums.length < 1) return;
    int[] temp = nums.clone();
    Arrays.sort(temp);
    // intuition is to use the first & second half to fill the array in wiggle order
    // we consume both the halves from behind
    int index = nums.length - 1;
    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = temp[index--];
    }
    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = temp[index--];
    }

  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 5, 1, 1, 6, 4};
    wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
