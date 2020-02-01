package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

//  46. Permutations
//  Given a collection of distinct integers, return all possible permutations.
//      Example:
//
//  Input: [1,2,3]
//  Output:
//      [
//      [1,2,3],
//      [1,3,2],
//      [2,1,3],
//      [2,3,1],
//      [3,1,2],
//      [3,2,1]
//      ]

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    helper(nums, new ArrayList<>(), res, used);
    return res;
  }

  private static void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    }
    // always start from 0, there is no concept of Start like in combinations
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue; // use every element only once
      temp.add(nums[i]);
      used[i] = true;
      helper(nums, temp, res, used);
      used[i] = false;
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3};
    int[] nums = new int[]{1, 2, 1};
    List<List<Integer>> res = permute(nums);
    for (List<Integer> l : res)
      System.out.println(l);
  }
}