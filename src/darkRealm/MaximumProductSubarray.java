package darkRealm;

import java.util.Arrays;

public class MaximumProductSubarray {

//  #152. Maximum Product Subarray ::: Complexity - Time : O(n), Space : O(2n)
//  Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//  For example, given the array [2,3,-2,4],
//  the contiguous subarray [2,3] has the largest product = 6.

  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums == null || nums.length == 0) return 0;
    // Intuition is to take two arrays for keeping the max and min Product till that element,
    // this product can be coming by multiplying of previous numbers or it can be a fresh stat(number itself)
    int[] minP = new int[nums.length];
    int[] maxP = new int[nums.length];
    minP[0] = maxP[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // why we swap when we get a -ve number, bcoz the lowest min till now * -ve number will give us a +ve big number
      // that can be a maxProdct, thus swap!
      if (nums[i] < 0) {
        int t = maxP[i - 1];
        maxP[i - 1] = minP[i - 1];
        minP[i - 1] = t;
      }
      minP[i] = Math.min(nums[i] * minP[i - 1], nums[i]);
      maxP[i] = Math.max(nums[i] * maxP[i - 1], nums[i]);
      max = Math.max(max, Math.max(maxP[i], minP[i]));

    }
    // return which ever holds the max Product
    return max;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{0, 2};
    int[] nums = new int[]{-4, -3, -2};
//    int[] nums = new int[]{2, 3, -2, 4};
//    int[] nums = new int[]{ -3, 2, -4};
//    int[] nums = new int[]{ -2};
//    int[] nums = new int[]{ -2, 0, -1};
//    int[] nums = new int[]{ -2, 0, -1, -4};
//    int[] nums = new int[]{ 2, 0, 1, 4};
    int m = maxProduct(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("M : " + m);
  }
}
