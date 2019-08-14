package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelayTime {

//  743. Network Delay Time
//  There are N network nodes, labelled 1 to N.
//
//  Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the
//  target node, and w is the time it takes for a signal to travel from source to target.
//
//  Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it
//  is impossible, return -1.
//
//  Example 1:
//  Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//  Output: 2
//
//  Note:
//
//  N will be in the range [1, 100].
//  K will be in the range [1, N].
//  The length of times will be in the range [1, 6000].
//  All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

  // Using Dijkstras shortest path algorithm
  public static int networkDelayTime(int[][] times, int N, int K) {
    if (times == null || times.length < 1) return -1;
    int[][] adjMat = new int[N + 1][N + 1];

    for (int[] a : adjMat)
      Arrays.fill(a, Integer.MAX_VALUE);

    for (int[] t : times)
      adjMat[t[0]][t[1]] = t[2];

    int[] minDist = new int[N + 1];
    Arrays.fill(minDist, Integer.MAX_VALUE);
    minDist[K] = 0;
    Queue<Integer> que = new LinkedList<>();
    que.offer(K);

    while (que.size() > 0) {
      int s = que.size();
      while (s-- > 0) {
        int v = que.poll();
        for (int i = 0; i < adjMat.length; i++) {
          if (adjMat[v][i] != Integer.MAX_VALUE) { // if there is an edge
            if (minDist[i] > minDist[v] + adjMat[v][i]) { // using this edge we can reach neighbor in lower cost
              minDist[i] = minDist[v] + adjMat[v][i];
              que.offer(i); // add this neighbor as the next to process
            }
          }
        }
      }
    }

    int res = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      int d = minDist[i];
      // if there is a node that cant be reached signal will not flow
      if (d == Integer.MAX_VALUE) return -1;
      res = Math.max(res, d); // the max cost to reach a node will be the time in which all the nodes will recieve the signal
    }

    System.out.println(Arrays.toString(minDist));
    return res;
  }

  public static void main(String[] args) {
    int[][] times = new int[][]{
        {2, 1, 1},
        {2, 3, 1},
        {3, 4, 1},
    };
    int N = 4;
    int K = 2;

    int res = networkDelayTime(times, N, K);
    System.out.println(res);
  }
}
