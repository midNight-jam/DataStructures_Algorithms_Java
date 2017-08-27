package darkRealm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

//  Given an array of size n, find the majority element. The majority element is the element that appears more than
// ⌊ n/2 ⌋ times.
//  You may assume that the array is non-empty and the majority element always exist in the array.

  public static int majorityElement(int[] nums) {
    if (null == nums || 0 == nums.length) return 0;
    int count = 0;
    int major = 0;
    // we dont need the exact count of the major number as it is more than n/2, thus below works
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        count++;
        major = nums[i];
      } else if (major == nums[i])
        count++;
      else
        count--;
    }
    return major;
  }

  public static int majorityElementOLD(int[] nums) {
    if (nums == null || 0 == nums.length) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int major = Integer.MIN_VALUE;
    int res = 0;
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
      int currentMajor = Math.max(major, map.get(n));
      if (currentMajor > major) {
        major = currentMajor;
        res = n;
      }
    }
    return res;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1};
    int[] nums = new int[]{6, 5, 5};
    int res = majorityElement(nums);
    System.out.println("Nums : " + Arrays.toString(nums));
    System.out.println("Maj  : " + res);
  }
}