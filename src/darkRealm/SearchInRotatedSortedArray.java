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
    int low, high, mid;
    low = 0;
    high = arr.length - 1;
    int res;
    while(low <= high){
      mid = low + (high - low) / 2;
      
      if(arr[low] <= arr[mid]){
        // if target is within this range, perform usuals binarySearch
        if(target >= arr[low] && target <= arr[mid]){
          res = binarySearch(arr, low, mid, target);
          return res < 0 ? -1 : res;
        }
        
        else
          low = mid + 1; // this half is sorted so skip this part
      }
      
      else{
        // if target is within this range, perform usuals binarySearch
        if(target >= arr[mid] && target <= arr[high]){
          res = binarySearch(arr, mid, high, target);
          return res < 0 ? -1 : res;
        }
          
        else 
          high = mid - 1; // this half is sorted so skip this part
      }
    }
    
    return -1;
  }
  
  // normal binary Search
  private int binarySearch(int [] arr, int low, int high, int target){
    int mid;
    while(low <= high){
      mid = low + (high - low) / 2;
      if(target == arr[mid])
        return mid;
      if(arr[mid] < target)
        low = mid + 1;
      else
        high = mid - 1;
    }
    
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1};
//    int res = search(nums, 2);
    int res = Arrays.binarySearch(nums, 0, nums.length, 2);
  }
}
