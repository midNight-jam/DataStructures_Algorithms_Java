package darkRealm;

public class UniquePaths {

//  #62 Unique Paths
//  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//  How many possible unique paths are there?
//  Above is a 3 x 7 grid. How many possible unique paths are there?
//  Note: m and n will be at most 100.

  public static int uniquePaths(int m, int n) {
    if (m < 1 || n < 1) return 0;
    int[][] dp = new int[m][n];
    int i = 0;
    while (i < m || i < n) {
      if (i < m) dp[i][0] = 1;
      if (i < n) dp[0][i] = 1;
      i++;
    }
    for (i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    return dp[m - 1][n - 1];
  }

  //NOT WORKING WIP
  public static int uniquePathsMath(int m, int n) {
    int sum = 1;
    m--;
    n--;
    int l = m + n;
    int s = 0;
    if (n < m) s = n;
    else s = m; // will iterate till the smaller number
    for (int i = 1; i <= s; i++)
      sum = sum * (l - s + i) / i; // l-s remove the smaller number & use the left over number
    return sum;
  }

  public static void main(String[] args) {
//    int m = 1, n = 2;
    int m = 4, n = 4;
    int res = uniquePathsMath(m, n);
    System.out.println("M : " + m + " N : " + n + "\nR : " + res);
  }
}