package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {


  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    backtrack(res, temp, nums);
    return res;
  }

  private static void backtrack(List<List<Integer>> resList, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) resList.add(new ArrayList<>(temp));
    // there is no concept of start index like super set here we always begin from 0
    for (int i = 0; i < nums.length; i++) {
      if (temp.contains(nums[i])) continue; // as all the numbers are distinct, we are using its presence in temp list
      // to determine that we have processed this element
      temp.add(nums[i]);
      backtrack(resList, temp, nums);
      temp.remove(temp.size() - 1);
    }
  }

  public static List<List<Integer>> permute_viaStr(int[] nums) {
    List<Integer> numList = new ArrayList<>();
    for (int i : nums)
      numList.add(i);

    List<List<Integer>> resList = new ArrayList<>();
    combine(resList, numList, new ArrayList<>());
    for (List<Integer> l : resList)
      System.out.println(l);
    return resList;
  }

  //Using the same logic as permutation of String ,
  // slow ::: beat 2.8%
  private static void combine(List<List<Integer>> res, List<Integer> numList, List<Integer> prefixList) {
    if (numList.size() == 0) res.add(new ArrayList<>(prefixList));
    for (int i = 0; i < numList.size(); i++) {
      int picked = numList.remove(i);
      prefixList.add(picked);
      combine(res, numList, prefixList);
      numList.add(i, picked);
      prefixList.remove(prefixList.size() - 1);
    }
  }

  public static List<List<Integer>> zzpermute(int  [] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean [] used = new boolean[nums.length];
    zzbacktrack(res, temp, nums,used);
    return res;
  }

  private static void zzbacktrack(List<List<Integer>> res, List<Integer> temp, int [] nums, boolean [] used){
    if(temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for(int  i = 0; i < nums.length; i++){
      if(used[i]) continue;
      used[i] = true;
      temp.add(nums[i]);
      zzbacktrack(res,temp,nums, used);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }

  public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3};
    int[] nums = new int[]{1, 2, 1};
//    List<List<Integer>> res = permute(nums);
    List<List<Integer>> res = zzpermute(nums);
    for (List<Integer> l : res)
      System.out.println(l);
  }
}