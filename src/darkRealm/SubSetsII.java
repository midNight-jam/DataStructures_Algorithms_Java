package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {

//    #90. Subsets II
//    Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//    Note: The solution set must not contain duplicate subsets.
//    For example,
//    If nums = [1,2,2], a solution is:
//            [
//            [2],
//            [1],
//            [1,2,2],
//            [2,2],
//            [1,2],
//            []
//            ]


  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 1) return res;
    List<Integer> temp = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    helper(nums, 0, temp, res, used);
    return res;
  }

  private static void helper(int[] nums, int start, List<Integer> temp, List<List<Integer>> res, boolean[] used) {
    res.add(new ArrayList<>(temp));
    if (start >= nums.length) return;
    for (int i = start; i < nums.length; i++) {
      //if prev element is same & prev element is not used, then skip else we will create duplicate combinations
      if (i > start && nums[i - 1] == nums[i] && !used[i - 1]) continue;
      temp.add(nums[i]);
      used[i] = true;
      helper(nums, i + 1, temp, res, used);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 2, 2};
//        int[] nums = new int[]{4, 1, 4};
//        int[] nums = new int[]{4, 4, 4, 1, 4};
//    List<List<Integer>> res = subsetWithdup(nums);
    List<List<Integer>> res = subsetsWithDup(nums);
    System.out.println(res);
    for (List<Integer> set : res)
      System.out.println(set);
  }
}
