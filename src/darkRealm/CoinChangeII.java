package darkRealm;

import java.util.Arrays;

public class CoinChangeII {

//518. Coin Change 2
//  You are given coins of different denominations and a total amount of money. Write a function to compute the number of
//  combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
//
//      Example 1:
//
//  Input: amount = 5, coins = [1, 2, 5]
//  Output: 4
//  Explanation: there are four ways to make up the amount:
//      5=5
//      5=2+2+1
//      5=2+1+1+1
//      5=1+1+1+1+1
//  Example 2:
//
//  Input: amount = 3, coins = [2]
//  Output: 0
//  Explanation: the amount of 3 cannot be made up just with coins of 2.
//  Example 3:
//
//  Input: amount = 10, coins = [10]
//  Output: 1

  public static int change(int amount, int[] coins) {
    if (amount < 0 || coins == null) return 0;
    int[] dp = new int[amount + 1];
    Arrays.sort(coins);
    dp[0] = 1;
    // The idea is to reach every amount you can reach their by using only the denominations of the coins available
    // so we sum up all the ways from where we can reach this amount, thats why we lookback  = amount - ithCoin
    // Notice we have the amount loop inside of the coins loop, because we want to mark all amounts that we can reach
    // using a single coin denomination & as all are sum we at the end recieve the answer. If we do it other way we
    // get permutations count, where as we just want the combinations count. so if the loops were reversed
    // input: amount = 5, coins = [1, 2, 5], it counts [2, 2, 1] and [2, 1, 2] as two different combinations,
    // so it will return 9 rather than 5.

    for (int ci = 0; ci < coins.length; ci++) {
      for (int amt = 1; amt <= amount; amt++) {
        if (amt - coins[ci] >= 0)
          dp[amt] += dp[amt - coins[ci]];
      }
    }
    return dp[amount];
  }


  public static void main(String[] args) {
//    int amt = 5;
//    int[] coins = new int[]{2, 5, 1};
//    int amt = 10;
//    int[] coins = new int[]{10};
    int amt = 0;
    int[] coins = new int[]{};
    int res = change(amt, coins);
    System.out.println(amt);
    System.out.println(Arrays.toString(coins));
    System.out.println(res);
  }
}
