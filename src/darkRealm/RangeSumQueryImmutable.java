package darkRealm;

import java.util.Arrays;

public class RangeSumQueryImmutable {

//  #303. Range Sum Query - Immutable
//  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//  Example:
//  Given nums = [-2, 0, 3, -5, 2, -1]
//  sumRange(0, 2) -> 1
//  sumRange(2, 5) -> -1
//  sumRange(0, 5) -> -3
//  Note:
//  You may assume that the array does not change.
//  There are many calls to sumRange function.


  static class NumArray {

    // Intuitions is to keep track of running sum
    // and for any query i,j range subtract the sum before the range starts, that is the left edge
    // if range query start from 0 then dont subtract else subtract the sum[i - 1]

    int[] sums;

    public NumArray(int[] nums) {
      sums = new int[nums.length];
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        sums[i] = sum;
      }
    }

    public int sumRange(int i, int j) {
      int leftEdge = i > 0 ? sums[i - 1] : 0;
      return sums[j] - leftEdge;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
    int sum = 0;
    NumArray nr = new NumArray(nums);
    sum = nr.sumRange(0, 2);
//    sum = nr.sumRange(2, 5);
//    sum = nr.sumRange(0, 5);
    System.out.println(Arrays.toString(nums));
    System.out.println(sum);
  }
}





