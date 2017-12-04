package darkRealm;

import java.util.Arrays;

public class ThreeSumClosest {

/*  #16 3SumClosest
  * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
  * Return the sum of the three integers. You may assume that each input would have exactly one solution.
  * For example, given array S = {-1 2 1 -4}, and target = 1.
  * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  * */

  public static int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    int minSum = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int low = i + 1;
      int high = arr.length - 1;
      int a = arr[i];

      while (low < high) {
        int b = arr[low];
        int c = arr[high];
        int sum = a + b + c;
        int diff = Math.abs(target - (sum));
        if (diff < minDiff) {
          minDiff = diff;
          minSum = sum;
          if (minDiff == 0) {
            return minSum;
          }
        }
        if (sum < target) {
          low++;
        }
        if (sum > target) {
          high--;
        }
      }
    }
    return minSum;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{11, -11, -12, -2, -13, -10, -8, -4, -5, -6, -9, 14, 14, -9, 14, 6, -11, 6, -4, -14, 2, -11, 13, -5, -13, 1, -10, 5, 3, -1,
        -11, -5, -2, -10, -6, -5, -13, 8, 2, -6, -8, -9, 3, 13, 3, -14, -12, -8, -13, -2, 8, 0, 11, 14, -3, -15, -15, -4, -13, -4, 0, -2, 12, -9, 13, -5, -7,
        6, -9, 13, 14, 3, -11, -13, 6, -13, -5, 10, 1, -6, 0, -5, 5, 14, -10, 1, -13, -9, 1, 14, -6, 9, -12, 8, 8, -7, -13, -8, 11, 3, 9, 1, 6, -2, -9, -2, -5,
        6, -7, 0, -15, -1};
    int target = -12;
    int res = threeSumClosest(arr, target);
    System.out.println("res : " + res + " Arr : " + Arrays.toString(arr));
  }
}
