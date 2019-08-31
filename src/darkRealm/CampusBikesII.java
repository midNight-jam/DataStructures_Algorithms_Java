package darkRealm;

public class CampusBikesII {

// 1066.
//  On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D
//  coordinate on this grid.
//  We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their
//  assigned bike is minimized.
//  The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//  Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
//
//      Example 1:
//
//  Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//  Output: 6
//  Explanation:
//  We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.
//  Example 2:
//
//
//
//  Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//  Output: 4
//  Explanation:
//  We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1.
//  Both assignments lead to sum of the Manhattan distances as 4.
//
//
//  Note:
//
//      0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
//  All worker and bike locations are distinct.
//1 <= workers.length <= bikes.length <= 10


  // Time Complexy: O(n * m !) n : workers, m : bikes
  static int minD;

  public static int assignBikes(int[][] ws, int[][] bs) {
    if (ws == null || ws.length < 1 || bs == null || bs.length < 1) return 0;
    boolean[] used = new boolean[bs.length];
    minD = Integer.MAX_VALUE;
    helper(ws, bs, 0, used, 0);
    return minD;
  }

  public static void helper(int[][] workers, int[][] bikes, int wi, boolean[] used, int td) {
    if (wi >= workers.length) { // if we reached the end try updating minD
      minD = Math.min(minD, td);
      return;
    }

    if (td > minD) return; // prune the dfs if we are about to exceed the minD

    for (int bi = 0; bi < used.length; bi++) {
      if (used[bi]) continue;
      int bwd = Math.abs(workers[wi][0] - bikes[bi][0]) + Math.abs(workers[wi][1] - bikes[bi][1]);
      used[bi] = true; // mark this bike used
      helper(workers, bikes, wi + 1, used, td + bwd);
      used[bi] = false; // backtrack the above decision
    }
  }

  public static void main(String[] args) {
//    int[][] workers = new int[][]{
//        {0, 0},
//        {1, 1},
//        {2, 0},
//    };
//    int[][] bikes = new int[][]{
//        {1, 0},
//        {2, 2},
//        {2, 1},
//    };


//    int[][] workers = new int[][]{
//        {0, 0},
//        {2, 1},
//    };
//    int[][] bikes = new int[][]{
//        {1, 2},
//        {3, 3},
//    };

    int[][] workers = new int[][]{
        {0, 0},
        {1, 0},
        {2, 0},
        {3, 0},
        {4, 0},
        {5, 0},
        {6, 0}
    };

    int[][] bikes = new int[][]{
        {0, 999},
        {1, 999},
        {2, 999},
        {3, 999},
        {4, 999},
        {5, 999},
        {6, 999},
        {7, 999},
        {8, 999}
    };

    int res = assignBikes(workers, bikes);
    System.out.println(res);
  }

}
