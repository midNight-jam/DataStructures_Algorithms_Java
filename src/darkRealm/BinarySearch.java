package darkRealm;

public class BinarySearch {

//  Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
//
//  Example 1:
//  Input: nums = [-1,0,3,5,9,12], target = 9
//  Output: 4
//  Explanation: 9 exists in nums and its index is 4
//
//  Example 2:
//  Input: nums = [-1,0,3,5,9,12], target = 2
//  Output: -1
//  Explanation: 2 does not exist in nums so return -1
//
//  Note:
//  You may assume that all elements in nums are unique.
//  n will be in the range [1, 10000].
//  The value of each element in nums will be in the range [-9999, 9999].

  public static int search(int[] nums, int target) {
    int index = -1;
    if (nums == null || nums.length < 1) return index;
    int left = 0;
    int right = nums.length - 1;
    int mid;
    //left<=right : bcoz if array is size 1, left == right & only then it will go in loop
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] > target)
        right = mid - 1; // mid - 1, not mid, it will get stuck in loop
      else if (nums[mid] < target)
        left = mid + 1; // mid + 1, not mid, it will get stuck in loop
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5};
    int res = search(nums, 5);

  }
}
