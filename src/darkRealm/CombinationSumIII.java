package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

//  216. Combination Sum III
//  Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
//  used and each combination should be a unique set of numbers.
//
//      Note:
//  All numbers will be positive integers.
//  The solution set must not contain duplicate combinations.
//  Example 1:
//
//  Input: k = 3, n = 7
//  Output: [[1,2,4]]
//  Example 2:
//
//  Input: k = 3, n = 9
//  Output: [[1,2,6], [1,3,5], [2,3,4]]

  public static List<List<Integer>> combinationSum3(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    helper(res, new ArrayList<>(), nums, 0, n, k, 0);
    return res;
  }

  private static void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start, int target, int nos, int sum) {
    if (sum == target && temp.size() == nos) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (sum > target || temp.size() >= nos) return;

    for (int i = start; i < nums.length; i++) {
      sum += nums[i];
      temp.add(nums[i]);
      helper(res, temp, nums, i + 1, target, nos, sum);
      sum -= nums[i];
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
//    int n = 7;
//    int k = 3;
    int n = 9;
    int k = 3;
    List<List<Integer>> res = combinationSum3(n, k);

    System.out.println("n : " + n + "  k : " + k);
    System.out.println(res);
  }

}
