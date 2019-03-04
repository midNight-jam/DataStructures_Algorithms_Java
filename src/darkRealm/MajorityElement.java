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
    int major = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == major)
        count++;
      if (nums[i] != major)
        count--;
      if (count == 0) {
        major = nums[i];
        count = 1;
      }
    }
    return major;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1};
    int[] nums = new int[]{6, 5, 5};
    int res = majorityElement(nums);
    System.out.println("Nums : " + Arrays.toString(nums));
    System.out.println("Maj  : " + res);
  }
}