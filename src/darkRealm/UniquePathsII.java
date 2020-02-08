package darkRealm;

public class UniquePathsII {

//  63. Unique Paths II
//  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
//  corner of the grid (marked 'Finish' in the diagram below).
//
//  Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//  An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//  Note: m and n will be at most 100.
//
//  Example 1:
//
//  Input:
//      [
//      [0,0,0],
//      [0,1,0],
//      [0,0,0]
//      ]
//  Output: 2
//  Explanation:
//  There is one obstacle in the middle of the 3x3 grid above.
//  There are two ways to reach the bottom-right corner:
//      1. Right -> Right -> Down -> Down
//      2. Down -> Down -> Right -> Right

  private static int uniquePathsWithObstacles(int[][] grid) {
    if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
    int [][] dp = new int[grid.length][grid[0].length];
    int val = 1;
    for(int i = 0; i < dp.length; i++){
      if(grid[i][0] == 1)
        val = 0;
      dp[i][0] = val;
    }
    val = 1;
    for(int i = 0; i < dp[0].length; i++){
      if(grid[0][i] == 1)
        val = 0;
      dp[0][i] = val;
    }

    for(int i = 1; i < dp.length; i++){
      for(int j = 1; j < dp[0].length; j++){
        dp[i][j] += dp[i-1][j] + dp[i][j-1];
        if(grid[i][j] == 1)
          dp[i][j] = 0;
      }
    }

    return dp[dp.length-1][dp[0].length-1];
  }
}
