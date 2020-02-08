
package darkRealm;

import java.util.*;

public class CheapestFlightsWithinKStops {

//  787. Cheapest Flights Within K Stops
//  There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
//
//  Now given all the cities and flights, together with starting city src and the destination dst, your task is to
//  find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
//
//  Example 1:
//  Input:
//  n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//  src = 0, dst = 2, k = 1
//  Output: 200
//  Explanation:
//  The graph looks like this:
//
//  The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
//  Example 2:
//  Input:
//  n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//  src = 0, dst = 2, k = 0
//  Output: 500
//  Explanation:
//  The graph looks like this:
//
//  The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
//  Note:
//
//  The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
//  The size of flights will be in range [0, n * (n - 1) / 2].
//  The format of each flight will be (src, dst, price).
//  The price of each flight will be in the range [1, 10000].
//  k is in the range of [0, n - 1].
//  There will not be any duplicated flights or self cycles.

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if (flights == null || flights.length < 1) return -1;

    // The idea is to use a minHeap with flights cost &  also keep the rtrack of no of stops left to take
    // we take the next flight iff we have capacity

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      public int compare(int[] f1, int[] f2) {
        return f1[0] - f2[0];
      }
    });

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] f : flights) {
      int from = f[0];
      int to = f[1];
      int price = f[2];
      if (!map.containsKey(from))
        map.put(from, new HashMap<>());
      map.get(from).put(to, price);
    }

    pq.offer(new int[]{0, src, K + 1});

    while (pq.size() > 0) {
      int[] trip = pq.poll();
      int cost = trip[0];
      int city = trip[1];
      int stop = trip[2];
      // if we have reached the destination return the cosr
      if (city == dst) return cost;
      // take another flight if we have the capacity
      if (stop > 0) {
        Map<Integer, Integer> nextStations = new HashMap<>();
        if (map.containsKey(city))
          nextStations = map.get(city);
        // add all the next stations
        for (int next : nextStations.keySet()) {
          int nextCost = cost + nextStations.get(next);
          pq.offer(new int[]{nextCost, next, stop - 1});
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] flights = new int[][]{
        {0, 1, 100},
        {1, 2, 100},
        {0, 2, 500},
    };

    int s = 0;
    int d = 2;
    int k = 1;
//    int k = 0;


//    int n = 4;
//    int[][] flights = new int[][]{
//        {0, 1, 1},
//        {0, 2, 5},
//        {1, 2, 1},
//        {2, 3, 1}
//    };
//    int s = 0;
//    int d = 3;
//    int k = 1;

    int res = findCheapestPrice(n, flights, s, d, k);
    System.out.println(res);
  }
}
