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
    for (int j = 3; j < nums.length - 2; j++) {
      Set<Integer> set = new HashSet<>();
      // First quarter and right quarter, sum of left quarter & right quarter should be equal
      // lets try to create a split at i
      for (int i = 1; i < j - 1; i++) {
        // sum of left === sum of right
        // why sums[i-1], because this will incclude sum of all elements from to i - 1, leaving 1 which is first quarter
        //why sums[j-1], because we need to exclude j, why - sums[i], becuase we have to exclude i as well
        if (sums[i - 1] == sums[j - 1] - sums[i])
          set.add(sums[i - 1]); // record this sum as sum are equal
      }
      // lets try to create a split at k
      for (int k = j + 2; k < nums.length - 1; k++) {
        // why last - sums[k], becuase this will give us sum of 4th quarter and excluding K from it so  - sums[k]
        // why sums[k-1] - sums[j]. because this will give us the sum of 3rd quarter
        if (sums[sums.length - 1] - sums[k] == sums[k - 1] - sums[j])
          if (set.contains(sums[k - 1] - sums[j])) return true;
        // if the quarters sum matches means we were able to spilt array
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
