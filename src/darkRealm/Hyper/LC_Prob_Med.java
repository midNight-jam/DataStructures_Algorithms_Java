package darkRealm.Hyper;

import ADT.LinkedList;
import ADT.LLNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jayam on 1/27/2017.
 */
public class LC_Prob_Med {



  /*
  * */
  public static int singleNumber(int[] arr) {
    int xorResult = 0;
    if (arr.length > 0) {
      xorResult = arr[0];
      for (int i = 1; i < arr.length; i++) {
        xorResult ^= arr[i];
      }
    }
    return xorResult;
  }

  public static int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    int minSum = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int low = i + 1;
      int high = arr.length - 1;
      int a = arr[i];

      while (low < high) {
        int b = arr[low];
        int c = arr[high];
        int sum = a + b + c;
        int diff = Math.abs(target - (sum));
        if (diff < minDiff) {
          minDiff = diff;
          minSum = sum;
          System.out.println("~DL~ a: " + a + " b: " + b + " c: " + c + " mindiff : " + minDiff);
          if (minDiff == 0) {
            return minSum;
          }
        }
        if (sum < target) {
          low++;
        }
        if (sum > target) {
          high--;
        }
      }
    }
    return minSum;
  }


  /*  [Prob 121] Best Time to Buy and Sell Stock
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *  You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    *  However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    *  -2, 2, 4, 1, 2, 3, 5, 6  MaxP = 11 -2 to 4 + 1 to 6
    *  */
  public static int maxProfitII(int[] prices) {
    if (prices == null || prices.length < 2) return 0;
    int maxP = 0;
    // this is the explanation
    // a<= b <= c <= d;
    // d - a = (b - a) + (c - b) + (d - c)
    // d - a = b -a + c -b + d -c
    // d - a = d - a
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        maxP += prices[i] - prices[i - 1];
    return maxP;
  }



  public static int maxProfitIII(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int buy1, sell1, buy2, sell2;
    buy1 = buy2 = Integer.MIN_VALUE;
    sell1 = sell2 = 0;
    for (int i = 0; i < prices.length; i++) {
      sell2 = Math.max(sell2, buy2 + prices[i]);
      buy2 = Math.max(buy2, sell1 - prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy1 = Math.max(buy1, -prices[i]);
    }
    return sell2;
  }

  public static int maxProfitFinal(int[] prices, int k) {
    if (prices == null || prices.length == 0) return 0;
    int[][] DP = new int[k + 1][prices.length];
    if (k >= prices.length / 2) return quickProfit(prices);
    int maxDiff = 0;
    /*  DP Rule is
    *   T[i,j] = Max of{ T[i, j-1] --> not transacting
    *                   OR
    *                   Price[j] + maxDiff
    *                 maxDiff = max(maxDiff, T[i-1][j] - price[j])
    * */
    for (int i = 1; i < DP.length; i++) {
      maxDiff = -prices[0];
      for (int j = 1; j < DP[0].length; j++) {
        DP[i][j] = Math.max(DP[i][j - 1], prices[j] + maxDiff);
        maxDiff = Math.max(maxDiff, DP[i - 1][j] - prices[j]);
      }
    }
    return DP[k][prices.length - 1];
  }

  private static int quickProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++)
      if (prices[i] > prices[i - 1])
        max += prices[i] - prices[i - 1];
    return max;
  }
}