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
    int max3, max2, max1;
    int min1, min2;
    max3 = max2 = max1 = Integer.MIN_VALUE;
    min1 = min2 = Integer.MAX_VALUE;
    for(int n : nums){
      if(n > max3){
        max1 = max2;
        max2 = max3;
        max3 = n;
      }
      else if(n > max2){
        max1 = max2;
        max2 = n;
      }
      else if(n > max1)
        max1 = n;

      if(n < min2){
        min1 = min2;
        min2 = n;
      }
      else if(n < min1)
        min1 = n;
    }

    return Math.max(max3 * max2 * max1, max3 * min2 * min1);
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