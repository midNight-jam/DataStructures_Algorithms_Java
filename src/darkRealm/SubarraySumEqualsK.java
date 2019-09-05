package darkRealm;

import java.util.*;

public class SubarraySumEqualsK {

//  560. Subarray Sum Equals K
//  Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
//  equals to k.
//
//      Example 1:
//  Input:nums = [1,1,1], k = 2
//  Output: 2
//  Note:
//  The length of the array is in range [1, 20,000].
//  The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

  public static int subarraySum(int[] nums, int k) {
    if (nums == null) return 0;
    // map of sum, List<indexes>
    Map<Integer, List<Integer>> map = new HashMap<>();
    int sum = 0;
    int res = 0;

    // intial sum of 0 is always possible even for an empty array
    map.put(0, new ArrayList<>(Arrays.asList(new Integer[]{-1})));

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // if we have the diff of K present, just grab all the indexes from where its possible
      if (map.containsKey(sum - k))
        res += map.get(sum - k).size();

      if (!map.containsKey(sum))
        map.put(sum, new ArrayList<>());
      map.get(sum).add(i);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 0, 1, 0, 1};
    int k = 2;
    int res = subarraySum(arr, k);
    System.out.println(res);
    System.out.println(res == 4 ? "Pass" : "Fail");
  }
}
