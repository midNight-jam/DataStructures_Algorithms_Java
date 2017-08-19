package darkRealm;

import java.util.Arrays;

public class ArrayPartitionI {
    /*
    * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
    * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    * Example 1:
    * Input: [1,4,3,2]
    * Output: 4
    * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
    * Note:
    * n is a positive integer, which is in the range of [1, 10000].
    * All the integers in the array will be in the range of [-10000, 10000].
    * */

    public static int arrayPairSum(int[] nums) {
        if (null == nums) return 0;
        int maxSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2)
            maxSum += Math.min(nums[i], nums[i + 1]);

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        int res = arrayPairSum(arr);
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Res : " + res);
    }
}