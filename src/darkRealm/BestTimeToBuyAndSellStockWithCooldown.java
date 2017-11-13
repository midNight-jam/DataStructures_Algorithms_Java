package darkRealm;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

//  #309. Best Time to Buy and Sell Stock with Cooldown ::: Complexity - Time : O(n), Space : O(3n)
//  Say you have an array for which the ith element is the price of a given stock on day i.
//  Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
//  sell one share of the stock multiple times) with the following restrictions:
//  You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//  After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//  Example:
//  prices = [1, 2, 3, 0, 2]
//  maxProfit = 3
//  transactions = [buy, sell, cooldown, buy, sell]

  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int[] s0 = new int[prices.length];
    int[] s1 = new int[prices.length];
    int[] s2 = new int[prices.length];

    // Intuition is finite state machine with 3 states s0, s1 and s2, and rest, buy and sell being the transitions the we can make
    // Now, initially we start from s0, there are two transitions from s0, rest which doesnt changes the state, and buy
    // which takes us to state 2
    //      [rest]       [rest]
    //      (s0) <----------------  (s2)
    //         \                  /
    //          \               /
    //    [buy]  \            /   [sell]
    //   s0 to s1  \        /   s1 to s2
    //               \    /
    //              (s1)
    //              [rest]
    //
    // then by observing the incoming edges we can see the cost for reaching that state
    //  for price[i]
    // to reach S0 == Max(S0[i-1], S2[i-1])
    // to reach S1 == Max(S0[i-1] - price[i], S1[i-1]) , why -prices[i], bcoz we are puchasing ans that requires spending money
    // to reach S2 == S1[i-1] + price[i], why +price[i], bcoz we sold stock so profit

    s0[0] = 0;  //only resting
    s1[0] = -prices[0];    // intially we purchased the stock to reach state s1
    s2[0] = Integer.MIN_VALUE;  //as we cannot reach S2 without selling so we set it to min

    for (int i = 1; i < prices.length; i++) {
      s0[i] = Math.max(s0[i - 1], s2[i - 1]);
      s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
      s2[i] = s1[i - 1] + prices[i];
    }
    // We can return only from S0 and S2, becuase when we are at S1 ,we are in middle of a trade as we have not sold what
    // we bought, thus S0 & S1 are the valid states so we take the max profit from these states.
    return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
  }

  public static void main(String[] args) {
    int[] prices = new int[]{1, 2, 3, 0, 2};
    int p = maxProfit(prices);
    System.out.println(Arrays.toString(prices));
    System.out.println("P : " + p);
  }
}
