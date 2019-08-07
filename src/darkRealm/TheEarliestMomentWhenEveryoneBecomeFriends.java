package darkRealm;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

//  1101. The Earliest Moment When Everyone Become Friends
//  In a social group, there are N people, with unique integer ids from 0 to N-1.
//
//  We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp,
//  and the ids of two different people.
//
//  Each log represents the time in which two different people became friends.  Friendship is symmetric: if A is friends
//  with B, then B is friends with A.
//
//  Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted
//  with B.
//
//  Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no
//  such earliest time.
//
//
//
//  Example 1:
//
//  Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],
//  [20190312,1,2],[20190322,4,5]], N = 6
//  Output: 20190301
//  Explanation:
//  The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship
//  groups [0,1], [2], [3], [4], [5].
//  The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship
//  groups [0,1], [2], [3,4], [5].
//  The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship
//  groups [0,1], [2,3,4], [5].
//  The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship
//  groups [0,1,5], [2,3,4].
//  The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
//  The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.
//
//  Note:
//      1 <= N <= 100
//      1 <= logs.length <= 10^4
//      0 <= logs[i][0] <= 10^9
//      0 <= logs[i][1], logs[i][2] <= N - 1
//  It's guaranteed that all timestamps in logs[i][0] are different.
//  Logs are not necessarily ordered by some criteria.
//  logs[i][1] != logs[i][2

  public static int earliestAcq(int[][] logs, int N) {
    if (logs == null || N < 0) return -1;


    // The idea is to do minimumSpanningTree(MST), i.e add a friendship edge & connect two friend groups, such that we are
    // always conecting two seperate components/friend groups, at the earlies time when we have the MST is when we have
    // connected all the friends
    Arrays.sort(logs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) return -1;
        if (o1[0] > o2[0]) return 1;
        return 0;
      }
    });
    int[] comps = new int[N];
    for (int i = 0; i < N; i++)
      comps[i] = i;

    int total = N - 1;
    for (int i = 0; i < logs.length; i++) {
      int from = logs[i][1];
      int to = logs[i][2];
      int time = logs[i][0];
      if (connected(comps, from, to)) continue;
      total--;
      if (total == 0) return time;
      union(comps, from, to);
    }

    return -1;
  }

  private static boolean connected(int[] comps, int f, int t) {
    int fr = root(comps, f);
    int tr = root(comps, t);
    return fr == tr;
  }

  private static int root(int[] comps, int r) {
    while (r != comps[r]) {
      r = comps[r];
    }
    return r;
  }

  private static void union(int[] comps, int f, int t) {
    int froot = root(comps, f);
    int troot = root(comps, t);
    if (froot == troot) return;
    comps[froot] = troot;
  }

  public static void main(String[] args) {
//    int[][] logs = new int[][]{
//        {20190101, 0, 1},
//        {20190104, 3, 4},
//        {20190107, 2, 3},
//        {20190211, 1, 5},
//        {20190224, 2, 4},
//        {20190301, 0, 3},
//        {20190312, 1, 2},
//        {20190322, 4, 5}
//    };
//    int N = 6;

    int[][] logs = new int[][]{
        {20190101, 0, 1}
    };
    int N = 1;
    int res = earliestAcq(logs, N);
    System.out.println(res);
  }
}
