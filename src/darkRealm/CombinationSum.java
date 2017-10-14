package darkRealm;

import java.util.*;

public class CombinationSum {

//  #39. Combination Sum
//  Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
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
    Set<List<Integer>> res = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(res, temp, candidates, target, 0);
    return new ArrayList<>(res);
  }


  private static void backtrack(Set<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start) {
    if (remain < 0) return;
    if (remain == 0)
      res.add(new ArrayList<>(temp));
    for (int i = start; i < candidates.length; i++) {
      temp.add(candidates[i]);
      backtrack(res, temp, candidates, remain - candidates[i], i); // using i , as we can use same numbers as many times
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