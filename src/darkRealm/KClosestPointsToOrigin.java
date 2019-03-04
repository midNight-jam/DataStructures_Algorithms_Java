package darkRealm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

//  973. K Closest Points to Origin
//  We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//      (Here, the distance between two points on a plane is the Euclidean distance.)
//  You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
//
//
//  Example 1:
//  Input: points = [[1,3],[-2,2]], K = 1
//  Output: [[-2,2]]
//  Explanation:
//  The distance between (1, 3) and the origin is sqrt(10).
//  The distance between (-2, 2) and the origin is sqrt(8).
//  Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//  We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
//
//  Example 2:
//  Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//  Output: [[3,3],[-2,4]]
//      (The answer [[-2,4],[3,3]] would also be accepted.)


  public static int[][] kClosest(int[][] points, int K) {
    if (points == null || points.length < 1 || points[0].length < 1) return points;

    //first value is the dist from origin, second val is the index of the point in points array
    PriorityQueue<long[]> maxHeap = new PriorityQueue<>(new Comparator<long[]>() {
      @Override
      public int compare(long[] o1, long[] o2) {
        int r = 0;
        if (o1[0] > o2[0]) r = -1;
        else if (o1[0] < o2[0]) r = 1;
        return r;
      }
    });

    int[] p;
    long d;
    for (int i = 0; i < points.length; i++) {
      p = points[i];
      // dist from origin 0,0.  Reducing x2-0, y2-0 will not make any change so just returning the square,
      // also not taking sqrt
      d = p[0] * p[0] + p[1] * p[1];
      maxHeap.offer(new long[]{d, i});
      if (maxHeap.size() > K)
        maxHeap.poll();
    }

    int[][] res = new int[K][2];
    int i = 0;
    while (maxHeap.size() > 0)
      res[i++] = points[(int) maxHeap.poll()[1]];

    return res;
  }

  public static void main(String[] args) {
    int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
    int k = 2;
    int[][] res = kClosest(points, k);
    for (int[] r : res)
      System.out.println(Arrays.toString(r));
  }
}
