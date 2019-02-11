package darkRealm;

import java.util.Arrays;

public class ReversePairs {

//  493. Reverse Pairs
//
//  Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
//  You need to return the number of important reverse pairs in the given array.
//
//  Example1:
//  Input: [1,3,2,3,1]
//  Output: 2
//
//  Example2:
//  Input: [2,4,3,5,1]
//  Output: 3
//
//  Note:
//  The length of the given array will not exceed 50,000.
//  All the numbers in the input array are in the range of 32-bit integer.

  public static int reversePairs(int[] nums) {
    int res = 0;
    if (nums == null || nums.length < 1) return res;

    int[] sortedCopy = nums.clone();
    Arrays.sort(sortedCopy);  // this will be used to get the correct index of nums for bitTree

    // The idea is to use bit, read input from behind as per the questiion,
    // Idea is when we query, we look for a value that is less than the half,
    // And when we update we update the correct value,
    // As bit works on indexes, the value in above statement refer to
    int[] bit = new int[nums.length + 1];
    for (int i = nums.length - 1; i > -1; i--) {
      int n = nums[i];
      double nby2 = n / 2.0; // as the nums are all int, 1 < 1.5 that's why double

      int indexOfNumSmallerThanHalf = binSearchIndex(nby2, sortedCopy);
      res += query(indexOfNumSmallerThanHalf, bit);

      int indexOfNum = Arrays.binarySearch(sortedCopy, n);
      update(indexOfNum + 1, bit); // indexOfNum + 1 as in bit we dont go for 0 its root
    }
    return res;
  }

  private static int binSearchIndex(double val, int[] copySorted) {
    int left, right;
    left = 0;
    // This right initialization is the gist of this problem, I dont know why its intialized with length & not length - 1.
    right = copySorted.length;
    int mid = 0;
    while (left < right) {
      mid = left + (right - left) / 2;
      // as we are interested in first index smaller then the queriedNo
      if (copySorted[mid] >= val)
        right = mid;
      else
        left = mid + 1;
    }
    return left;
  }

  public static void update(int index, int[] bit) {
    while (index < bit.length) {
      bit[index]++;
      index += (index & -index);
    }
  }

  public static int query(int index, int[] bit) {
    int count = 0;
    while (index > 0) {
      count += bit[index];
      index -= (index & -index);
    }
    return count;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 3, 2, 3, 1};
//    int[] nums = new int[]{2, 4, 3, 5, 1};
//    int[] nums = new int[]{-5, -5};
    int[] nums = new int[]{-7, -4};

//    int[] nums = new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
//    int res = reversePairs(nums);
    int res = binSearchIndex(-8.0, nums);
    System.out.println(Arrays.toString(nums));
    System.out.println("res" + res);
  }
}
