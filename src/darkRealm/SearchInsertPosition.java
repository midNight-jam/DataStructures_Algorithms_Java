package darkRealm;

import java.util.Arrays;

public class SearchInsertPosition {

//  Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
//  would be if it were inserted in order.
//  You may assume no duplicates in the array.
//  Here are few examples.
//      [1,3,5,6], 5 → 2
//      [1,3,5,6], 2 → 1
//      [1,3,5,6], 7 → 4
//      [1,3,5,6], 0 → 0


  //I wanted to remove this, but I decided to keep it as an example of how shitty code I can write & still get away with
  // it. Compared to the below version, not old is very neat. Learning : when you find ur self pushing these many conditions, you
  // have either not understood the problem or solving a diff problem.
  /*public static int searchInsertPositionOLD(int[] arr, int n) {
    int low = 0, high = arr.length - 1;
    int mid = (high - low) / 2;

    if (null == arr || arr.length == 0) return 0;
    if (n <= arr[0]) return 0;
    else if (n == arr[arr.length - 1]) return arr.length - 1;
    else if (n > arr[arr.length - 1]) return arr.length;
    else {
      while (low <= high) {
        mid = (high + low) / 2;
        if (arr[mid] > n)
          high = mid - 1;
        else if (arr[mid] < n)
          low = mid + 1;
        else return mid;
      }
    }
    return low;
  }*/

  public static int searchInsertPosition(int[] nums, int target) {
    if (nums == null || nums.length < 1) return 0;
    int left = 0;
    int right = nums.length - 1;
    int mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] < target)
        left = mid + 1;
      else if (nums[mid] > target)
        right = mid - 1;
      else
        return mid;
    }
    // Why return left, well debug on paper with a pen, you will have ur answer
    return left;
  }

  public static void main(String[] args) {
//    int [] arr = new int []{1,3,5,6};
//    int n = 5;

    int[] arr = new int[]{1, 3, 5, 6};
    int n = 5;

    int pos = searchInsertPosition(arr, n);
    System.out.println("Arr: " + Arrays.toString(arr));
    System.out.println("Pos : " + pos);
  }
}
