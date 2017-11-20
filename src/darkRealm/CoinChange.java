package darkRealm;

import java.util.Arrays;

public class CoinChange {


//  #322. Coin Change   :: Complexity - Time O(amount ^ coins) , Space : O(amount + 1)
//  You are given coins of different denominations and a total amount of money amount. Write a function to compute the
//  fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
//  combination of the coins, return -1.
//  Example 1:
//  coins = [1, 2, 5], amount = 11
//      return 3 (11 = 5 + 5 + 1)
//  Example 2:
//  coins = [2], amount = 3
//      return -1.
//  Note:
//  You may assume that you have an infinite number of each kind of coin.

  public static int coinChange(int[] coins, int amount) {
    int[] res = new int[amount + 1];
    Arrays.fill(res, -1); // mark all amounts as invalid initially
    res[0] = 0; // base case, we can always reach 0, if all coins with out using any coin
    //here amount 0 is our base case, against this base case we see if for given amount and reducing each coin can we
    // reach 0 or any valid amount, if yes we add + 1 to it, we do this for all coins and keep track of min.
    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for (int c = 0; c < coins.length; c++) {
        // Why coins[c] > i ::: lets say we have coins 5,7 & 9etc, now we can never reach amount 1-4 with these coins
        // Why res[i - coins[c]] ::: lets say coins are 3, 5 now for amount 4, res[4 - 1] (i - coins[0]) is -1, as our
        // base case itself is invalid we can never reach this amount with given coins
        if (coins[c] > i || res[i - coins[c]] == -1) continue;
        min = Math.min(res[i - coins[c]] + 1, min);
      }
      res[i] = min == Integer.MAX_VALUE ? -1 : min;
    }
    System.out.println(Arrays.toString(res));
    return res[amount];
  }


  public static int coinChange_OLD(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 0) return 0;
    int[] dp = new int[amount + 1];
    int sum = 0, min = -1, coin, temp;
    // INtuition is to get min coin count for each sum from 0 - Amount, and reuse the preiviously calculated result via dp
    // if the amount is greater than the current coin then go back for same magnitude as of current coin in dp array
    // and pick the number, if its not -1 means the current amount can be composed using this coin, then add + 1 to it
    // if the number by going back is -1 means the current amount cannot be composed using this coin.
    // for ex : coins [1,2,3] and amout is 5, then by the iteration at which amout is 4 dp array looks like
    // [-1, 1, 1, 1, 2, _ ] now for 5 amount and coin 1 we go 1 back & get 2 add 1to it so min  = 3, same for coin 2, we go back
    // 2 and get 1 add 1 to it so min is now 2, means we can get 5 amout using coin 3 & 2 which is min
    // https://www.youtube.com/watch?v=Y0ZqKpToTic
    while (++sum <= amount) {
      min = -1;
      for (int i = 0; i < coins.length; i++) {
        coin = coins[i];
        if (sum >= coin && dp[sum - coin] != -1) {
          temp = dp[sum - coin] + 1;
          min = min < 0 ? temp : (temp < min ? temp : min);
        }
      }
      dp[sum] = min;
    }
    return dp[amount];
  }


  public static void main(String[] args) {
//    int[] coins = new int[]{1, 2, 5};
//    int amount = 11;
//    int[] coins = new int[]{2};
//    int amount = 3;
//    int[] coins = new int[]{1};
//    int amount = 2;
    int[] coins = new int[]{186, 419, 83, 408};
    int amount = 6249; // 20

    int count = coinChange(coins, amount);
    System.out.println("C : " + count);
  }
}
