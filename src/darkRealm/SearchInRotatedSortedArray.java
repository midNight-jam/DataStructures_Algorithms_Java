package darkRealm;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

//  #33. Search in Rotated Sorted Array
//  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//      (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//  You are given a target value to search. If found in the array return its index, otherwise return -1.
//  You may assume no duplicate exists in the array.

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int low = 0, high = nums.length - 1, mid = 0;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] < nums[high]) high = mid;
      else low = mid + 1;
    }
    // Use same binary search this time accounted for the rotation
    int res = -1;
    int rot = low;
    low = 0;
    high = nums.length - 1;
    int realMid = 0;
    while (low <= high) {
      mid = low + (high - low) / 2;
      realMid = (mid + rot) % nums.length;
      if (nums[realMid] == target) return realMid;
      if (nums[realMid] < target) low = mid + 1;
      else high = mid - 1;
    }
    return -1;
  }

  public static int search_findRotationAndSearchInTwoArrays(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int low = 0, high = nums.length - 1, mid = 0;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] < nums[high]) high = mid;
      else low = mid + 1;
    }
    int res = -1;
    if (low > 0) {
      res = Arrays.binarySearch(nums, 0, low, target);
      res = res < 0 ? Arrays.binarySearch(nums, low, nums.length, target) : res;
    } else res = Arrays.binarySearch(nums, 0, nums.length, target);

    return res < 0 ? -1 : res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1};
//    int res = search(nums, 2);
    int res = Arrays.binarySearch(nums, 0, nums.length, 2);
  }
}
