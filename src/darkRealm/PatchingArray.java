package darkRealm;

import java.util.Arrays;

public class PatchingArray {

//   330. Patching Array
// Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in 
// range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
// Example 1:
// Input: nums = [1,3], n = 6
// Output: 1 
// Explanation:
// Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
// Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
// Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
// So we only need 1 patch.
// Example 2:
// Input: nums = [1,5,10], n = 20
// Output: 2
// Explanation: The two patches can be [2, 4].
// Example 3:

// Input: nums = [1,2,2], n = 5
  
  public static int minPatches(int[] nums, int n) {
    long sum_RightEndOfRangeInclusive = 0;  // as we are adding it may overflow
    int patches = 0;
    // sort the numbers we want to right to left in increasing order for our range
    Arrays.sort(nums);
    int i = 0;
    while (sum_RightEndOfRangeInclusive < n) {
      // if the current rightEndOfRange + 1 doesnt cover the current num, then we must expand our range by rightEndOfRangeInclusive + 1
      // first part of the condition if we have used all the nums given and still havent covered our target
      if (i >= nums.length || sum_RightEndOfRangeInclusive + 1 < nums[i]) {
        patches++;
        sum_RightEndOfRangeInclusive += sum_RightEndOfRangeInclusive + 1;
      } else {
        // if the rightEndOfRange already covers this num, then include this num in our range as we can expand our range using this num &
        // without requiring a patch, sum = 13 & next no is 12 then we can cover up to 25 using this num & not require a patch till 25
        sum_RightEndOfRangeInclusive += nums[i];
        i++;
      }
    }
    return patches;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3};
//    int n = 6;
//    int[] nums = new int[]{1, 5, 10};
//    int n = 20;
//    int[] nums = new int[]{1, 2, 2};
//    int n = 5;
//    int [] nums = new int[]{1, 2, 4, 13, 43};
//    int n = 100;
//    int[] nums = new int[]{};
//    int n = 7;

    int[] nums = new int[]{1, 2, 31, 33};
    int n = 2147483647;

    int res = minPatches(nums, n);
    System.out.println(res + " : res");
  }
}

