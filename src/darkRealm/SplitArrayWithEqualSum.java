package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SplitArrayWithEqualSum {

//  #548. Split Array with Equal Sum
//  Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following
//  conditions:
//  0 < i, i + 1 < j, j + 1 < k < n - 1
//  Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
//  where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L
//  to the element indexed R.
//  Example:
//  Input: [1,2,1,2,1,2,1]
//  Output: True
//  Explanation:
//  i = 1, j = 3, k = 5.
//  sum(0, i - 1) = sum(0, 0) = 1
//  sum(i + 1, j - 1) = sum(2, 2) = 1
//  sum(j + 1, k - 1) = sum(4, 4) = 1
//  sum(k + 1, n - 1) = sum(6, 6) = 1
//  Note:
//  1 <= n <= 2000.
//  Elements in the given array will be in range [-1,000,000, 1,000,000].

  public static boolean splitArray(int[] nums) {
    if (nums == null || nums.length < 7) return false;
    int[] sums = new int[nums.length];
    int s = 0;
    for (int i = 0; i < nums.length; i++) {
      s += nums[i];
      sums[i] = s;
    }
    //Intuition is to find 4 quarters in the array that have the same sum, we begin by dividing array in to 3 parts
    // we start with j for mid and then adjust i and j for left and right
    // lets try to create a split at j
    // starting j = 3 because we need 3 segments to left of j
    // (0, i - 1), (i), (i + 1, j - 1)
    // each seg can be of min len 1 , thus 0,1,2 are gone & we start from 3
    for (int j = 3; j < nums.length - 2; j++) {
      Set<Integer> set = new HashSet<>();
      // First quarter and right quarter, sum of left quarter & right quarter should be equal
      // lets try to create a split at i
      // leave spaces for 2 segments left & right of i, as each seg can be of min len 1
      // thus 0 & j-1 are spared
      for (int i = 1; i <= j - 2; i++) {
        // sum from 0 to i - 1
        int li = sums[i - 1];
        // sum from i + 1 to j -1
        int ri = sums[j - 1] - sums[i];
        if (li == ri)
          set.add(li); // keep the sum to track if we find an equal
      }
      // leave spaces for 2 segments left & right of k, as each seg can be of min len 1
      // thus j + 1 & last(len -1) are spared
      for (int k = j + 2; k < nums.length - 1; k++) {
        // sum from j + 1 to k - 1
        int lk = sums[k - 1] - sums[j];
        // sum from k + 1 to end
        int rk = sums[sums.length - 1] - sums[k];
        if (lk == rk) {
          if (set.contains(lk))
            return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2, 1, 2, 1, 2, 2};
    int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1};
//    int[] nums = new int[]{0, 1, 0, 0, 2, 0, 1, 0, 0, 2, 0, 1, 0, 2, 0, 1, 0};
    boolean res = splitArray(nums);

    System.out.println(Arrays.toString(nums));
    System.out.println("S : " + res);
  }
}
