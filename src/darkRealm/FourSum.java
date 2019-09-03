package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

//  18. 4Sum
//  Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such
//  that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//      Note:
//
//  The solution set must not contain duplicate quadruplets.
//
//  Example:
//
//  Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//  A solution set is:
//      [
//      [-1,  0, 0, 1],
//      [-2, -1, 1, 2],
//      [-2,  0, 0, 2]
//      ]


  public static List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null) return new ArrayList<>();
    Arrays.sort(nums);
    return kSum(nums, target, 4, 0);
  }

  /* *
   * Below method supports TwoSum, ThreeSum, FourSum, .... KSum, where k >= 2
   * */
  private static List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
    List<List<Integer>> res = new ArrayList<>();
    if (index >= nums.length) return res;

    // k==2 is a base case
    if (k == 2) {
      int low = index, high = nums.length - 1;
      while (low < high) {
        //find a pair
        if (nums[low] + nums[high] < target)
          low++;
        else if (nums[low] + nums[high] > target)
          high--;
        else {  //(target == nums[low] + nums[high])
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[low]);
          temp.add(target - nums[low]);
          res.add(temp);
          //skip duplication
          while (low < high && nums[low] == nums[low + 1]) low++;
          while (low < high && nums[high - 1] == nums[high]) high--;
          low++;
          high--;
        }
      }
    } else {
      for (int i = index; i + k - 1 < nums.length; i++) {
        //use current number to reduce ksum into k-1sum
        List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);

        if (temp.size() < 1) continue; // no res for k - 1

        //add this number to all previous results
        for (List<Integer> t : temp)
          t.add(0, nums[i]);
        res.addAll(temp);

        //skip duplicated numbers
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 0, -1, 0, 2, -2};
    int target = 2;
    List<List<Integer>> res = fourSum(nums, target);
    System.out.println(res.size());
    for (List<Integer> l : res)
      System.out.println(l);
  }
}
