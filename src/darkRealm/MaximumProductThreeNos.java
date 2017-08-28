package darkRealm;

import java.util.Arrays;

public class MaximumProductThreeNos {

//  Given an integer array, find three numbers whose product is maximum and output the maximum product.
//
// Example 1:
//  Input: [1,2,3]
//  Output: 6
//
// Example 2:
//  Input: [1,2,3,4]
//  Output: 24
//  Note:
//  The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
//  Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

  public static int maxProductThreeNos(int[] nums) {
    Arrays.sort(nums);
    int maxProd = nums[nums.length - 3] * nums[nums.length - 2];
    int minProd = nums[0] * nums[1];
    return Math.max(maxProd * nums[nums.length - 1], minProd * nums[nums.length - 1]);
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 2, 3};
//    int[] nums = new int[]{1, 555, -555, -555};
    int[] nums = new int[]{1, 555, 555, -555};
    int res = maxProductThreeNos(nums);
    System.out.println("Nos : " + Arrays.toString(nums));
    System.out.println("Max : " + res);
  }
}