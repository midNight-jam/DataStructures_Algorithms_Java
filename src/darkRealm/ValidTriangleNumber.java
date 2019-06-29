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
      if(nums == null || nums.length < 1) return 0;
    Arrays.sort(nums);
    int res = 0, low = 0, high;
    
    // The rule for a triangle is that sum ot two sides is greater than the 3rd side
    for(int i = 2; i < nums.length; i++){
      low = 0;
      high = i - 1;
      while(low < high){
        if(nums[low] + nums[high] > nums[i]){
          // as the array is sorted, & if this condition is true, we know that the elements in this section will always keep the sum of 2 sides > 3rd one,
          // because it will have elements atleast greater or equal to nums[low], thus its safe to take the len of this section, which equal to the no of windows 
          // of len 2 (pairs) which keep the sum > 3rd side
          res += high - low;
          high--; // reduce high, so that we can search for another section
        }
        else
          low++; // as the sum has dropped or equalled to 3rd side, raise the smallest side
      }
    }
    
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 3, 4};
//    int[] nums = new int[]{2, 3, 3, 4, 4};
    int count = triangleNumber(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("C : " + count);
  }
}
