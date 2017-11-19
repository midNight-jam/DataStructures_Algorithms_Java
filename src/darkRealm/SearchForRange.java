package darkRealm;

import java.util.Arrays;

public class SearchForRange {

//  #34. Search for a Range   :::   Complexity  - Time : O(logN), for both halves , Space : O(1)
//  Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//  Your algorithm's runtime complexity must be in the order of O(log n).
//  If the target is not found in the array, return [-1, -1].
//  For example,
//  Given [5, 7, 7, 8, 8, 10] and target value 8,
//  return [3, 4].

  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};
    int low = 0, high = nums.length, mid = 0; // notice high is not nums.length - 1, it is equal to size
    // First we seach for the left start of the target, this will appear to the left of the mid, when mid == target,
    // So wour search reduces to finding low and high to the left of the mid, thats why we are doing high = mid, when mid == target,
    // means we are skipping all the elements to the right of the target in order to find the start of the range, we do
    // this till low < high, on breaking of this loop we have to verify one more thing, whether the target was in the
    // array or not.
    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] >= target) high = mid;
      else low = mid + 1;
    }
    // target is not in the array, thus return [-1, -1]
    if (low == nums.length || nums[low] != target)
      return new int[]{-1, -1};

    int left = low;
    low = 0;
    high = nums.length;

    // Now Search for the end of the range in the right part of the array from the mid, here as the right part begins
    // from mid, we are sure that arr[mid] == target, and as we are searching for the right end of the range, we can skip
    // all the elements that are equal to target and when it is not , we reduce the high to find the right end of range.
    while (low < high) {
      mid = low + (high - low) / 2;
      if (nums[mid] > target) high = mid;
      else low = mid + 1;
    }
    int right = low - 1;
    return new int[]{left, right};
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2, 5, 5, 5, 9};
//    int target = 5;

//    int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//    int target = 8;
//
//    int[] nums = new int[]{5, 7, 8};
//    int target = 8;

    int[] nums = new int[]{2, 2};
    int target = 2;

//    int[] nums = new int[]{5, 7, 8};
//    int target = 9;

    int[] res = searchRange(nums, target);
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(res));
    System.out.println(target);
  }
}
