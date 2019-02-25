package darkRealm;

import java.util.Arrays;

public class MinimumNumberOfRefuelingStops {

//  871. Minimum Number of Refueling Stops
//  A car travels from a starting position to a destination which is target miles east of the starting position.
//  Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east
//  of the starting position, and has station[i][1] liters of gas.
//
//  The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter
//  of gas per 1 mile that it drives.
//
//  When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
//
//  What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot
//  reach the destination, return -1.
//
//  Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches
//  the destination with 0 fuel left, it is still considered to have arrived.
//
//  Example 1:
//
//  Input: target = 1, startFuel = 1, stations = []
//  Output: 0
//  Explanation: We can reach the target without refueling.
//      Example 2:
//
//  Input: target = 100, startFuel = 1, stations = [[10,100]]
//  Output: -1
//  Explanation: We can't reach the target (or even the first gas station).
//  Example 3:
//
//  Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//  Output: 2
//  Explanation:
//  We start with 10 liters of fuel.
//  We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
//      Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//  and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
//  We made 2 refueling stops along the way, so we return 2.


  public static int minRefuelStops(int target, int startFuel, int[][] stations) {
    long[] dp = new long[stations.length + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = startFuel;
    for (int i = 0; i < stations.length; i++) {
      //dp[ithStop] is the maxdist we can cover after making the ithStop, & if while covering this maxDist we can refuel
      // then this refuel will give us more dist, this maxDist will the be the dist we can cover if we make this stop,
      // thats why [ithStop + 1]
      for (int ithStop = i; ithStop > -1 && dp[ithStop] >= stations[i][0]; ithStop--) {
        dp[ithStop + 1] = Math.max(dp[ithStop + 1], stations[i][1] + dp[ithStop]);
      }
    }

    System.out.println(Arrays.toString(dp));
    for (int ithStop = 0; ithStop < dp.length; ithStop++)
      if (dp[ithStop] >= target) return ithStop;
    return -1;
  }

  public static void main(String[] args) {
//    int target = 1;
//    int startFuel = 1;
//    int[][] stations = new int[][]{};

//    int target = 1000;
//    int startFuel = 299;
//    int[][] stations = new int[][]{{13, 21}, {6, 115}, {100, 47}, {225, 99}, {299, 141}, {444, 198}, {608, 190}, {636, 157}, {647, 255}, {841, 123}};

//    int target = 100;
//    int startFuel = 10;
//    int[][] stations = {{10, 100}};
//    int target = 100;
//    int startFuel = 10;
//    int[][] stations = {{5, 90}, {10, 60}, {20, 30}, {30, 30}, {60, 40}};
//    int[][] stations = {{10, 49}, {20, 30}, {30, 30}, {60, 40}};

//    int target = 100;
//    int startFuel = 25;
//    int[][] stations = {{25, 25}, {50, 25}, {75, 25}};

    int target = 999;
    int startFuel = 1000;
    int[][] stations = {{5,100},{997,100},{998,100}};


    int res = minRefuelStops(target, startFuel, stations);
    System.out.println(res);
  }
}
