package darkRealm;

import java.util.Arrays;

public class ValidTriangleNumber {

//  #611. Valid Triangle Number
//  Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the
//  array that can make triangles if we take them as side lengths of a triangle.
//  Example 1:
//  Input: [2,2,3,4]
//  Output: 3
//  Explanation:
//  Valid combinations are:
//      2,3,4 (using the first 2)
//      2,3,4 (using the second 2)
//      2,2,3
//  Note:
//  The length of the given array won't exceed 1000.
//  The integers in the given array are in the range of [0, 1000].

  public static int triangleNumber(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int count = 0, l= 0 , h = 0;
    Arrays.sort(nums);
    // Why we choose to iterate from back, because when taking from back we have already taken a bigger no for 2nd side
    // and adding small number 1st side to it will be easily greter than the 3rd side
    for(int i = nums.length - 1; i >= 1; i--) {
      l = 0;
      h = i - 1;
      while (l < h)
        if (nums[l] + nums[h] > nums[i]) { // till sum is low then current num
          count += h - l;
          h--;
        } else l++; // increment l becuse has went down
    }
    return count;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{2, 2, 3, 4};
    int[] nums = new int[]{2, 3, 3, 4, 4};
    int count = triangleNumber(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("C : " + count);
  }
}
