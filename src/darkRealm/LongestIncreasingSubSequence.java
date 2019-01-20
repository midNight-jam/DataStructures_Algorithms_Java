package darkRealm;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

//  #300. Longest Increasing Subsequence
//  Given an unsorted array of integers, find the length of longest increasing subsequence.
//  For example,
//  Given [10, 9, 2, 5, 3, 7, 101, 18],
//  The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than
//  one LIS combination, it is only necessary for you to return the length.
//  Your algorithm should run in O(n2) complexity.
//  Follow up: Could you improve it to O(n log n) time complexity?


  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] res = new int[nums.length];
    Arrays.fill(res, 1);
    int max = 1, longest = 1;
    for (int i = 1; i < nums.length; i++) {
      max = res[i];
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          max = Math.max(res[j] + 1, max);
        }
      }
      res[i] = max;
      longest = Math.max(max, longest);
    }
    return longest;
  }

  public static int lengthOfLIS_NLogN(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int []  dp = new int[nums.length];

    //Fill the array with MAX
    Arrays.fill(dp, Integer.MAX_VALUE);

    // Arrays.binarySearch() returns the index, below from docs
    // index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
    // The insertion point is defined as the point at which the key would be inserted into the array: the index of the
    // first element greater than the key, or a.length if all elements in the array are less than the specified key.
    // Note that this guarantees that the return value will be >= 0 if and only if the key is found.

    // Why Binary Search will work, as the name suggests LIS itself is a ascending order sequence, we just have to create
    // such longest sequence using the numbers in the array, For this we can exploit/utlise an ability of binarySearch
    // Binary Search as stated above not only finds the index of target, but alos return a -ve index (will return -3 if
    // element has to be inserted at 2) suggesting that what
    // will be the correct position for this number in the "SORTED ARRAY", this sorted array is our LIS.
    // Thats why we fill the dp array with MAx_VALUE and then use binary search for each number in array to get their
    // position in the sorted array, Below is the instep view of array after inserting each number in their
    // respective positions
    // for the array below of 8 integer,  M = MAX_VALUE
    //
    //    10, 9, 2, 5, 3, 7, 101, 18
    //                                                   (index of len + 1)
    //    10, M, M, M, M, M, M, M, M            LIS len 1(0+1)
    //    9, M, M, M, M, M, M, M, M             LIS len 1(0+1)
    //    2, M, M, M, M, M, M, M, M             LIS len 1(0+1)
    //    2, 5, M, M, M, M, M, M, M, M          LIS len 2(1+1)
    //    2, 3, M, M, M, M, M, M, M, M           LIS len 2(1+1)
    //    2, 3, 7, M, M, M, M, M, M, M, M         LIS len 3(2+1)
    //    2, 3, 7, 101, M, M, M, M, M, M, M, M     LIS len 4(3+1)
    //    2, 3, 7, 18, M, M, M, M, M, M, M, M      LIS len 4(3+1)

    int pos_to_be_inserted = 0;

    for(int i = 0; i < nums.length; i++){
      pos_to_be_inserted = Arrays.binarySearch(dp, nums[i]);

      // Create the +ve index if num[i] not already in the array, by adding + 1 back & negating again.
      if(pos_to_be_inserted < 0)
        pos_to_be_inserted = -(pos_to_be_inserted + 1);

      // This assignment just overrides the max_value so that we can now that a LIS of this len(index + 1) is possible
      dp[pos_to_be_inserted] = nums[i];
    }

    // read the DP array from behind and find the first index which is set to not max.
    for(int i = nums.length - 1; i>=0; i--)
      if(dp[i] != Integer.MAX_VALUE)
        return i + 1; // as index are from 0, so at i = 2, the LIS is 3

    return 0;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//    int[] nums = new int[]{0};
    int res = lengthOfLIS(nums);
    System.out.println("R : " + res);
    res = lengthOfLIS_NLogN(nums);
    System.out.println("R : " + res);
  }
}
