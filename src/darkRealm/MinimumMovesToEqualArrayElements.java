package darkRealm;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {

//  Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
//  equal, where a move is incrementing n - 1 elements by 1.
//  Example:
//  Input:
//      [1,2,3]
//  Output:
//      3
//  Explanation:
//  Only three moves are needed (remember each move increments two elements):
//      [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

  public static int minMoves(int[] nums) {
    if (null == nums || 2 > nums.length) return 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int n : nums) {
      sum += n;
      min = Math.min(min, n);
    }
    // using the formula
    // min = min among the nums
    // sum = sum of all present elements
    // m = no of moves required
    // x = After m moves all the elements will reach x
    // x is min + m moves increment
    // sum + m (n-1) = n * x
    // sum + mn - m = n * (min + m)
    // sum + mn - m = n*min + mn
    // sum - m = n * min
    // m = sum - n * min
    int moves = sum - nums.length * min;
    return moves;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    int res = minMoves(nums);
    System.out.println("Nums : " + Arrays.toString(nums));
    System.out.println("Res  : " + res);
  }
}
