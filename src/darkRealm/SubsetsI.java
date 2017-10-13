package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

//  #78. Subsets
//  Given a set of distinct integers, nums, return all possible subsets_bit.
//  Note: The solution set must not contain duplicate subsets_bit.

    //bit solution ::: 22% beat
    public static List<List<Integer>> subsets_bit(int[] nums) {
        int setSize = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < setSize; i++) {
            int j = i;
            List<Integer> set = new ArrayList<>();
            int count = 0;
            while (j != 0) {
                int k = j & 1;
                if (k == 1)
                    set.add(nums[count]);
                count++;
                j = j >> 1;
            }
            res.add(set);
        }
        return res;
    }

    public static List<List<Integer>> subsets_recursion(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(res, temp, nums, 0);
        return res;
    }

    // Create two lists, one is the final result, another is place holder, we clone this temp list before adding to the
    // result list, clone because if we add directly, its by reference and will not retain values as temp get modified.
    // Logic :: Take the current element add it to list, send this list for recursion, after returning from recursion
    // removed the last added element(current element) and iterate again for next element, we initialize i by start so
    // that we add an item only once in the ongoing combination.
    // beat ::: 22%
    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
//        List<List<Integer>> res = subsets_bit(nums);
        List<List<Integer>> res = subsets_recursion(nums);
        for (List<Integer> set : res)
            System.out.println(set);
    }
}