package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

//    #47. Permutations II
//    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//    For example,
//    [1,1,2] have the following unique permutations:
//            [
//            [1,1,2],
//            [1,2,1],
//            [2,1,1]
//            ]


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        backtrack(res, temp, nums, used);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean [] used) {
        if(temp.size() == nums.length){
          res.add(new ArrayList<>(temp));
          return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && used[i-1] == false) continue;
            // why have we used used[i-1] ==false ..??
            // when a number has the same value with its previous, we can use this number only if his previous is used
            // taking example of [1, 1, 2], when in the iteration where we begin with 2nd 1 and we have (1, 2) is permutation,
            // if we add the first 1 again, this will repeat the (1, 2, 1) permutation
            used[i] = true;
            temp.add(nums[i]);
            backtrack(res, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> l : res)
            System.out.println(l);
    }
}
