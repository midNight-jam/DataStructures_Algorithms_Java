package darkRealm;

public class BinarySearch {

//   704. Binary Search
//  Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search
//  target in nums. If target exists, then return its index, otherwise return -1.
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

  public static int search(int[] arr, int target) {
    if (arr == null || arr.length < 1) return -1;
    int low, high, mid;
    low = 0;
    high = arr.length - 1;
    //left<=right : bcoz if array is size 1, left == right & only then it will go in loop
    while (low <= high) {
      mid = low + (high - low) / 2;

      if (arr[mid] == target)
        return mid;

      if (arr[mid] < target)
        low = mid + 1; // because we have already analysed arr[mid] so no point in adjusting to it again

      else
        high = mid - 1; // because we have already analysed arr[mid] so no point in adjusting to it again
    }

    System.out.println(low); // this will be the insert position if the target is not present in the array
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5};
    int res = search(nums, 5);

  }
}
