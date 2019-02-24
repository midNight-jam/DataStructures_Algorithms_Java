package darkRealm;

import java.util.*;

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


  public static List<List<Integer>> subsetWithdup(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(nums); // we sort the array, this helps in skipping duplicates later
    backtrack(res, temp, nums, 0);
    return new ArrayList<>(res);
  }

  private static void backtrack(Set<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
    res.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      //  if for the given starting index we have already included this element then skip
      if (i > start && nums[i] == nums[i - 1]) continue;
      temp.add(nums[i]);
      backtrack(res, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public static List<List<Integer>> subsetDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 1) return res;
    zzHelper(res, new ArrayList<>(), nums, 0);
    return res;
  }

  private static void zzHelper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
    res.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      if(i > start && nums[i] == nums[i-1]) continue;
      temp.add(nums[i]);
      zzHelper(res, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 2, 2};
//        int[] nums = new int[]{4, 1, 4};
//        int[] nums = new int[]{4, 4, 4, 1, 4};
//    List<List<Integer>> res = subsetWithdup(nums);
    List<List<Integer>> res = subsetDup(nums);
    System.out.println(res);
    for (List<Integer> set : res)
      System.out.println(set);
  }
}
