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

  public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if(candidates == null || candidates.length < 1 || target < 0)
      return res;
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(candidates);
    helper(res, temp, 0,0, target, candidates);
    return res;
  }
  
  private  static void helper(List<List<Integer>> res, List<Integer> temp, int start, int sum, int target, int [] arr){
    if(sum > target) return;
    if(sum == target){
      res.add(new ArrayList<>(temp));
      return;
    }
    
    for(int i = start; i < arr.length; i++){
      temp.add(arr[i]);
      sum += arr[i];
      helper(res, temp, i, sum, target, arr);
      sum -= arr[i];
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
