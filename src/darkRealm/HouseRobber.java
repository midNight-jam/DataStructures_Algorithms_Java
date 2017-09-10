package darkRealm;

import java.util.*;

public class HouseRobber {

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
    if (house == null || 0 == house.length) return 0;
    if (house.length == 1) return house[0];
    int[] maxRob = new int[house.length];
    maxRob[0] = house[0];
    maxRob[1] = Math.max(house[0], house[1]);

    for (int i = 2; i < maxRob.length; i++)
      maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + house[i]);
    return maxRob[maxRob.length - 1];
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 1, 2};
    int res = houseRobber(arr);
    System.out.println("Arr : " + Arrays.toString(arr));
    System.out.println("RES : " + res);
  }
}