package darkRealm;

public class RangeAddition2 {

//  Given an m * n matrix M initialized with all 0's and several update operations.
//
//  Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
//
//  You need to count and return the number of maximum integers in the matrix after performing all the operations.
//
//      Example 1:
//  Input:
//  m = 3, n = 3
//  operations = [[2,2],[3,3]]
//  Output: 4
//  Explanation:
//  Initially, M =
//      [[0, 0, 0],
//      [0, 0, 0],
//      [0, 0, 0]]
//
//  After performing [2,2], M =
//      [[1, 1, 0],
//      [1, 1, 0],
//      [0, 0, 0]]
//
//  After performing [3,3], M =
//      [[2, 2, 1],
//      [2, 2, 1],
//      [1, 1, 1]]
//
//  So the maximum integer in M is 2, and there are four of it in M. So return 4.

  public static int maxCount(int m, int n, int[][] ops) {
    // Gist is , the min rows & cols will always have the max number of increment, thus we just need to count the min
    // rows & cols and return the multiplication for getting the number of elements that have the max value.
    if (null == ops || 0 == ops.length) return m * n;
    int r = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
    for (int i = 0; i < ops.length; i++) {
      r = Math.min(r, ops[i][0]);
      c = Math.min(c, ops[i][1]);
    }
    return r * c;
  }

  //My Version
  public static int maxCountOLD(int m, int n, int[][] ops) {
    int[] rows = new int[m];
    int[] cols = new int[n];
    int max = 0;
    for (int i = 0; i < ops.length; i++) {
      int r = ops[i][0];
      int c = ops[i][1];
      for (int j = 0; j < r; j++)
        max = Math.max(max, ++rows[j]);
      for (int k = 0; k < c; k++)
        max = Math.max(max, ++cols[k]);
    }
    int rowCount = 0, colCount = 0;
    for (int i = 0; i < m; i++)
      if (rows[i] == max) rowCount++;
    for (int j = 0; j < n; j++)
      if (cols[j] == max) colCount++;

    return rowCount * colCount;
  }

  public static void main(String[] args) {
//    int m = 3;
//    int n = 3;
//    int[][] operations = new int[][]{{2, 2}, {3, 3}};
    int m = 4;
    int n = 4;
    int[][] operations = new int[][]{{3, 3}, {2, 2}, {4, 4}, {1, 1}};
    int res = maxCount(m, n, operations);
    System.out.println("Res :" + res);
  }
}