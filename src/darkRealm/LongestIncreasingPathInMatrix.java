package darkRealm;

public class LongestIncreasingPathInMatrix {

//  #329. Longest Increasing Path in a Matrix   ::: Complexity - O(?)
//  Given an integer matrix, find the length of the longest increasing path.
//  From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or
//  move outside of the boundary (i.e. wrap-around is not allowed).
//  Example 1:
//  nums = [
//      [9,9,4],
//      [6,6,8],
//      [2,1,1]
//      ]
//  Return 4
//  The longest increasing path is [1, 2, 6, 9].
//  Example 2:
//  nums = [
//      [3,4,5],
//      [3,2,6],
//      [2,2,1]
//      ]
//  Return 4
//  The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

  public static int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int[][] cache = new int[matrix.length][matrix[0].length];
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        res = Math.max(dfs_helper(matrix, i, j, cache), res);
      }
    }
    return res;
  }

  public static int dfs_helper(int[][] matrix, int i, int j, int[][] cache) {
    if (cache[i][j] != 0) return cache[i][j];
    int[] horizontal = new int[]{0, 1, 0, -1};
    int[] vertical = new int[]{1, 0, -1, 0};
    int max = 1;
    for (int v = 0; v < 4; v++) {
      int r = i + horizontal[v];
      int c = j + vertical[v];
      if (isValid(matrix, r, c, matrix[i][j])) {
        int len = 1 + dfs_helper(matrix, r, c, cache);
        max = Math.max(len, max);
      }
    }
    cache[i][j] = max;
    return max;
  }

  private static boolean isValid(int[][] matrix, int i, int j, int prev) {
    return i > -1 && i < matrix.length && j > -1 && j < matrix[0].length && matrix[i][j] > prev;
  }

  public static void main(String[] args) {
    int[][] nums = new int[][]{
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1},
    };
    int count = longestIncreasingPath(nums);
    System.out.println("C : " + count);
  }
}
