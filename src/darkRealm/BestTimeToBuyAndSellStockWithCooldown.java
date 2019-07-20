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
    int N = prices.length;
    int [] resting = new int[N];
    int [] bought = new int[N];
    int [] sold = new int[N]; // or we can also name this array profit

    // Intuition is finite state machine with 3 states s0, s1 and s2, and rest, buy and sell being the transitions the we can make
    // Now, initially we start from s0, there are two transitions from s0, rest which doesnt changes the state, and buy
    // which takes us to state 2
    //      [restedge]            [restedge]
    //      (S0/restingState) <---------------------  (S2/soldStae)
    //          \                                 /
    //           \                               /
    //  [buyedge]  \                            /   [selledge]
    //   s0 to s1  \                          /   s1 to s2
    //               \                       /
    //                 \                    /
    //                    \              /
    //                     \           /
    //                    (S1/boughtState)
    //                      [restedge]
    //
    // then by observing the incoming edges we can see the cost for reaching that state
    //  for price[i]
    // to reach S0 == Max(S0[i-1], S2[i-1])
    // to reach S1 == Max(S0[i-1] - price[i], S1[i-1]) , why -prices[i], bcoz we are puchasing ans that requires spending money
    // to reach S2 == S1[i-1] + price[i], why +price[i], bcoz we sold stock so profit

    resting[0] = 0;
    bought[0] = resting[0] - prices[0]; // I bought so I am in -ve, as I spend money out of pocket
    sold[0] = Integer.MIN_VALUE; // initially no profit so we set to MIN & not 0 (we want to maximise profit)
    

    // NO COST FOR RESTING (edge)
    for(int i = 1; i < N; i++){
      //either we can reach resting state by selling, or just resting
      resting[i] = Math.max(sold[i-1], resting[i-1]);
      // wither we reach bought by buying or resting after a buy
      bought[i] = Math.max(bought[i-1], resting[i-1] - prices[i]);
      // we reach sold state only after selling
      sold[i] = prices[i] + bought[i-1]; // not -bought[i], because when I bought I am in -ve already, if I do -bought[i], -(-bought[i]) would becone +bought[i]
    }
    
    // when finished we can be either at resting state or sold state, so we take the max among these states
    //thus S0 & S1 are the valid states so we take the max profit from these states.
    return Math.max(sold[N-1], resting[N-1]);
  }

  public static void main(String[] args) {
    int[] prices = new int[]{1, 2, 3, 0, 2};
    int p = maxProfit(prices);
    System.out.println(Arrays.toString(prices));
    System.out.println("P : " + p);
  }
}
