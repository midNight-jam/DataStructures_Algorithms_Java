package darkRealm;

import java.util.Arrays;

public class MinimumPathSum {

//  #64. Minimum Path Sum
//  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
//  sum of all numbers along its path.
//  Note: You can only move either down or right at any point in time.
//      Example 1:
//      [[1,3,1],
//      [1,5,1],
//      [4,2,1]]
//  Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

  public static int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) // first col, only way to come in to first cols is by moving down thus add all the cost
      dp[i][0] = dp[i - 1][0] + grid[i][0];

    for (int j = 1; j < n; j++) // first row, only way to come in to first row is by moving right thus add all the cost
      dp[0][j] = dp[0][j - 1] + grid[0][j];


    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // there are only two ways to enter this cell
        // either from top or from left, thus take min cost of it and add current cost
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
    };
    int min = minPathSum(grid);
    for (int[] r : grid)
      System.out.println(Arrays.toString(r));
    System.out.println("M : " + min);
  }
}
