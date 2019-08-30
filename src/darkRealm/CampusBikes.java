package darkRealm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CampusBikes {

//  1057. Campus Bikes
//  On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D
//  coordinate on this grid.
//
//  Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike)
//  pair with the shortest Manhattan distance between each other, and assign the bike to that worker.
//  (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the
//  smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index).
//  We repeat this process until there are no available workers.
//
//  The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//
//  Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
//
//
//      Example 1:
//
//
//
//  Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//  Output: [1,0]
//  Explanation:
//  Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
//  Example 2:
//
//
//
//  Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//  Output: [0,2,1]
//  Explanation:
//  Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned
//  to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
//
//
//  Note:
//
//      0 <= workers[i][j], bikes[i][j] < 1000
//  All worker and bike locations are distinct.
//1 <= workers.length <= bikes.length <= 1000


  /*
   * Rather than firing BFS & capturing bikes, we do reverse engineering, at the end we have to return the pairs of
   * worker & bike. Using this we form all the pairs of worker & bike, but we need more info for a pair to be meaningful
   * This is where the distance between the worker & bike comes in to action, using these 3 we can form a tuple
   * & keep them in a minHeap with key as distance, in this way when we reach a worker that doesnt has a bike and a bike
   * that is still avail we know that we have reached this pair in the minimum dist & we store the result
   * */
  public static int[] assignBikes(int[][] workers, int[][] bikes) {
    if (workers == null || workers.length < 1 || bikes == null || bikes.length < 1) return new int[0];
    // tuple will be dist, bike, worker
    int N = workers.length;
    int M = bikes.length;
    int[] res = new int[N];
    Arrays.fill(res, -1);
    int[] bavail = new int[M];
    Arrays.fill(bavail, -1);

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator() {
      public int compare(Object o1, Object o2) {
        int[] t1 = (int[]) o1;
        int[] t2 = (int[]) o2;
        int dist = t1[0] - t2[0];
        if (dist != 0) return dist; // first oreder by dist
        int wrkr = t1[1] - t2[1];
        if (wrkr != 0) return wrkr; // if dist is same then order by worker index
        return t1[2] - t2[2]; // lastly use bike index
      }
    });

    for (int wi = 0; wi < N; wi++) {
      for (int bi = 0; bi < M; bi++) {
        int d = Math.abs(workers[wi][0] - bikes[bi][0]) + Math.abs(workers[wi][1] - bikes[bi][1]);
        minHeap.offer(new int[]{d, wi, bi});
      }
    }

    while (minHeap.size() > 0) {
      int[] t = minHeap.poll();
      int wi = t[1];
      int bi = t[2];
      // if this worker has not been assigned a bike & this bike is still available, then make this assignment
      if (res[wi] == -1 && bavail[bi] == -1) {
        res[wi] = bi;
        bavail[bi] = wi;
      }
    }

    System.out.println("workers : " + Arrays.toString(res));
    System.out.println("bikes : " + Arrays.toString(bavail));
    
    return res;
  }

  public static void main(String[] args) {
    int[][] workers = new int[][]{
        {0, 0},
        {1, 1},
        {2, 0},
    };
    int[][] bikes = new int[][]{
        {1, 0},
        {2, 2},
        {2, 1},
    };

    int[] res = assignBikes(workers, bikes);
    System.out.println(Arrays.toString(res));
  }
}
