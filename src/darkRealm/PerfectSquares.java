package darkRealm;


public class PerfectSquares {

//  #279. Perfect Squares ::: Complexity - Time : O(n^3/2), Space : O(n+1)
//  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which
//  sum to n.
//  For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

  public static int numSquares(int n) {

    // for this problem we will have to use math which is
    // for each number we look backfor minimum from 1 to sqrt(n) and do + 1
    // Visualization
    //    dp[0] = 0
    //    dp[1] = dp[0]+1 = 1
    //    dp[2] = dp[1]+1 = 2
    //    dp[3] = dp[2]+1 = 3
    //    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
    //      = Min{ dp[3]+1, dp[0]+1 }
    //      = 1
    //    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
    //      = Min{ dp[4]+1, dp[1]+1 }
    //      = 2
    //						.
    //						.
    //    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
    //       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
    //       = 2
    //						.
    //						.
    //    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

    int[] dp = new int[n + 1];
    dp[0] = 0;
    int high, min;
    for (int i = 1; i <= n; i++) {
      // for each number
      high = (int) Math.sqrt(i); // look back in dp till its square root
      min = Integer.MAX_VALUE;
      for (int j = 1; j <= high; j++)
        if (dp[i - j * j] < min)
          min = dp[i - j * j];
      dp[i] = min + 1;  // ad +1 to the min
    }
    return dp[n];
  }

  public static void main(String[] args) {
//    int n = 12;
    int n = 49;
//    int n = 5;
//    int n = 13;
    int res = numSquares(n);
    System.out.println("N : " + n);
    System.out.println("R : " + res);
  }
}
