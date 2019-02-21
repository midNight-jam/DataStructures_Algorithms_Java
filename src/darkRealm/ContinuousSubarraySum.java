package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

  //  523. Continuous Subarray Sum
//  Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
//  continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also
//  an integer.
//
//  Example 1:
//  Input: [23, 2, 4, 6, 7],  k=6
//  Output: True
//  Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//  Example 2:
//  Input: [23, 2, 6, 4, 7],  k=6
//  Output: True
//  Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
//  Note:
//  The length of the array won't exceed 10,000.
//  You may assume the sum of all the numbers is in the range of a signed 32-bit integer.


  public static boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length < 1) return false;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // base without any nums we have 0 sum at -1 index
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (k != 0)
        sum = sum % k;
      Integer prev = map.get(sum);
      if (prev != null) { // if already present dont update the value
        // why i - prev > 1 : bcoz if its only one element say [2] & k also is 2, then i - prev == 0 - (-1) == 1, which
        // by question should not be true as we require at least 2 elements
        if (i - prev > 1)
          return true;
      } else map.put(sum, i);
    }
    return false;
  }


  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2};
//    int k = 3;
    int[] nums = new int[]{0, 0};
    int k = 0;
//    int[] nums = new int[]{23, 2, 6, 4, 7};
//    int k = 6;
    boolean res = checkSubarraySum(nums, k);
    System.out.println(res);
  }
}
