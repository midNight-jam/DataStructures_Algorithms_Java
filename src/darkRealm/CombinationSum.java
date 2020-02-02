package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

//  #39. Combination Sum
//  Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in
//  C where the candidate numbers sums to T.
//
//  The same repeated number may be chosen from C unlimited number of times.
//
//      Note:
//
//  All numbers (including target) will be positive integers.
//  The solution set must not contain duplicate combinations.
//
//  For example, given candidate set [2, 3, 6, 7] and target 7,
//  A solution set is:
//
//      [
//      [7],
//      [2, 2, 3]
//      ]

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, target, 0, new ArrayList<>(), res);
    return res;
  }

  private static void helper(int[] nums, int tar, int start, List<Integer> temp, List<List<Integer>> res) {
    if (tar < 0) return;
    if (tar == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i < nums.length && nums[i] <= tar; i++) {
      temp.add(nums[i]);
      helper(nums, tar - nums[i], i, temp, res);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> res = combinationSum(nums, target);
    for (List<Integer> l : res)
      System.out.println("-- > " + l);
  }
}
