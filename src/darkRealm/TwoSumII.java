package darkRealm;

import java.util.Arrays;

public class TwoSumII {

  /*
  #167 Two Sum II - Input array is sorted
  Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
  specific target number.
  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
  be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution and you may not use the same element twice.
  Input: numbers={2, 7, 11, 15}, target=9
  Output: index1=1, index2=2
  */
  public int[] twoSum(int[] nums, int target) {
    if(nums == null || nums.length < 1) return new int[0];
    int left = 0;
    int right = nums.length - 1;
    while(left <= right && nums[left] + nums[right] != target){
      if(nums[left] + nums[right] < target)
        left++;
      else
        right--;
    }
    if(left < right)
      return new int[]{left + 1, right + 1};
    return new int[0];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}
