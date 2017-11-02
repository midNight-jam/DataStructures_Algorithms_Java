package darkRealm;

import java.util.Arrays;

public class RangeAddition {

//  #370. Range Addition -  Complexity : O(n + k) - n size of array, k size of updates
//  Assume you have an array of length n initialized with all 0's and are given k update operations.
//  Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
//  Return the modified array after all k operations were executed.//
//  Example:
//  Given:
//  length = 5,
//  updates = [
//      [1,  3,  2],
//      [2,  4,  3],
//      [0,  2, -2]
//      ]
//  Output:
//      [-2, 0, 3, 5, 3]
//  Explanation:
//  Initial state:
//      [ 0, 0, 0, 0, 0 ]
//  After applying operation [1, 3, 2]:
//      [ 0, 2, 2, 2, 0 ]
//  After applying operation [2, 4, 3]:
//      [ 0, 2, 5, 5, 3 ]
//  After applying operation [0, 2, -2]:
//      [-2, 0, 3, 5, 3 ]

  public static int[] getModifiedArray(int length, int[][] updates) {
    int[] res = new int[length];
    // Intuition is, for every range update mark the increment in the result array against the start and end. And then
    // do a single pass over the result array to apply increments. For each range we mark the increment for the start
    // but as soon as the range gets over we have to remove its effect also for this at the end + 1 index we mark the
    // negative of the update value, in this way we remove the effect of the update for range.
    for (int[] upd : updates) {
      int start = upd[0], end = upd[1], val = upd[2];
      res[start] += val;
      if (end < res.length - 1) res[end + 1] += -val; // why negative beacuse we would be removing the effect of this
      // update as its range is over
    }
    int sum = res[0];
    for (int i = 1; i < res.length; i++) {
      res[i] += sum;
      sum = res[i];
    }
    return res;
  }

  /// Naive approach - for each range go to array & apply increment, accepted but only 20%
  public static int[] getModifiedArray_OLD(int length, int[][] updates) {
    int[] res = new int[length];
    for (int i = 0; i < updates.length; i++)
      for (int j = updates[i][0]; j <= updates[i][1]; j++)
        res[j] += updates[i][2];
    return res;
  }

  public static void main(String[] args) {
    int[][] updates = new int[][]{
        {1, 3, 2},
        {2, 4, 3},
        {0, 2, -2}
    };
    int length = 5;
    int[] res = getModifiedArray(length, updates);
    for (int[] upd : updates)
      System.out.println(Arrays.toString(upd));
    System.out.println("-------------------------------------------");
    System.out.println(Arrays.toString(res));
  }
}