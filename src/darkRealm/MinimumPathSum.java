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
   if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
    int row = grid.length;
    int col = grid[0].length;
    int [][]dp = new int[row][col];
    int top, left;
    
    // first row, only way to come in to first row is by moving right thus add all the cost
    for(int i = 0, sum = 0; i < row; i++){
      sum += grid[i][0];
      dp[i][0] = sum;
    }

    // first col, only way to come in to first cols is by moving down thus add all the cost
    for(int j = 0, sum = 0; j < col; j++){
      sum += grid[0][j];
      dp[0][j] = sum;
    }
    
    for(int i = 1; i < row; i++){
      for(int j = 1; j < col; j++){
        // there are only two ways to enter this cell
        // either from top or from left, thus take min cost of it and add current cost
        top = dp[i-1][j];
        left = dp[i][j-1];
        dp[i][j] = Math.min(left, top) + grid[i][j];
      }
    }
    
    return dp[row-1][col-1];
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
