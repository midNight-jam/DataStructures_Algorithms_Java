package darkRealm;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

//  #153. Find Minimum in Rotated Sorted Array
//  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//  Find the minimum element.
//  You may assume no duplicate exists in the array.

  public static int findMin(int[] nums) {
    if (nums == null || nums.length == 0) return -1;

    int low = 0, high = nums.length - 1, mid;

    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] < nums[high]) high = mid;
      else low = mid + 1;
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{4, 5, 6, 1, 2, 3};
    int res = findMin(nums);
    System.out.println("N : "+Arrays.toString(nums));
    System.out.println("M : " + res);
  }
}
