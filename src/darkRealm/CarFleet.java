package darkRealm;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {

//  853. Car Fleet
//  N cars are going to the same destination along a one lane road.  The destination is target miles away.
//  Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the
//  target along the road.
//  A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
//  The distance between these two cars is ignored - they are assumed to have the same position.
//  A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is
//  also a car fleet.
//  If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
//
//  How many car fleets will arrive at the destination?
//  Example 1:
//
//  Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//  Output: 3
//  Explanation:
//  The cars starting at 10 and 8 become a fleet, meeting each other at 12.
//  The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
//  The cars starting at 5 and 3 become a fleet, meeting each other at 6.
//  Note that no other cars meet these fleets before the destination, so the answer is 3.
//
//  Note:
//
//      0 <= N <= 10 ^ 4
//      0 < target <= 10 ^ 6
//      0 < speed[i] <= 10 ^ 6
//      0 <= position[i] < target
//  All initial positions are different.

  public static int carFleet(int target, int[] pos, int[] speed) {
    int N = pos.length, res = 0;
    double[][] cars = new double[N][2];
    /*
     * Sort the cars by their starting position in increasing order.
     * Take the time taken for each car from their starting position to reach target using their speed
     * all slow cars (taking more time) can catch the fast cars (taking less time)
     * traverse the times to find such increases.
     * */

    for (int i = 0; i < N; ++i)
      cars[i] = new double[]{pos[i], (double) (target - pos[i]) / speed[i]};
    Arrays.sort(cars, new Comparator<double[]>() {
      @Override
      public int compare(double[] o1, double[] o2) {
        return Double.compare(o1[0], o2[0]);
      }
    });

    // 12, 3, 7, 1, 1  ::: there will be three increases, thus 3 fleets
    double cur = 0;
    for (int i = N - 1; i >= 0; --i)
      if (cars[i][1] > cur) {
        cur = cars[i][1];
        res++;
      }

    return res;
  }

  public static void main(String[] args) {
//    int[] positions = new int[]{10, 8, 0, 5, 3};
//    int[] speed = new int[]{2, 4, 1, 1, 3};
//    int target = 12;
//    int res = carFleet(target, positions, speed);
//    System.out.println(res);
//    System.out.println(res == 3 ? "Pass" : "fail");

//    int[] positions = new int[]{10, 8, 0, 5, 3};
//    int[] speed = new int[]{200, 400, 100, 100000, 300000};
//    int target = 120000;
//    int res = carFleet(target, positions, speed);
//    System.out.println(res);
//    System.out.println(res == 2 ? "Pass" : "fail");

//    int target = 10;
//    int[] positions = new int[]{8, 3, 7, 4, 6, 5};
//    int[] speed = new int[]{4, 4, 4, 4, 4, 4};
//    int res = carFleet(target, positions, speed);
//    System.out.println(res);
//    System.out.println(res == 6 ? "Pass" : "fail");

    int target = 31;
    int[] positions = new int[]{5, 26, 18, 25, 29, 21, 22, 12, 19, 6};
    int[] speed = new int[]{7, 6, 6, 4, 3, 4, 9, 7, 6, 4};
    int res = carFleet(target, positions, speed);
    System.out.println(res);
    System.out.println(res == 6 ? "Pass" : "fail");
  }
}
