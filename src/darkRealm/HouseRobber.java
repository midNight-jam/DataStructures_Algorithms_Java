package darkRealm;

import java.util.*;

public class HouseRobber {
//  198. House Robber
//  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
//  stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
//  connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
//  of money you can rob tonight without alerting the police.

  public static int houseRobber(int[] house) {
    // The problem is solved by DP, at every house we take the decision that if we rob this and the profit with ith- 2
    //  house the profit is max, or if we just rob the ith house then the profit is max.
    // The Rule is :: maxRob [i] = Math.max(maxRob[i-1], maxRob[i-2] + house[i])
    if (house == null || house.length == 0) return 0;
    int[] dp = new int[house.length];
    dp[0] = house[0];
    for (int i = 1; i < house.length; i++) {
      int twoBefore = i - 2 > -1 ? dp[i - 2] : 0;
      dp[i] = Math.max(dp[i - 1], twoBefore + house[i]);
    }
    return dp[house.length - 1];
  }

  public static void main(String[] args) {
//    int[] arr = new int[]{2, 1, 1, 2};
    int[] arr = new int[]{1, 1};
    int res = houseRobber(arr);
    System.out.println("Arr : " + Arrays.toString(arr));
    System.out.println("RES : " + res);
  }
}
