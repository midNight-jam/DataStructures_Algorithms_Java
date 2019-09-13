package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

  //  210. Course Schedule II
//  There are a total of n courses you have to take, labeled from 0 to n-1.
//  Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
//  which is expressed as a pair: [0,1]
//
//  Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you
//  should take to finish all courses.
//
//  There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
//  courses, return an empty array.
//
//      Example 1:
//
//  Input: 2, [[1,0]]
//  Output: [0,1]
//  Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
//  course 0. So the correct course order is [0,1] .
//  Example 2:
//
//  Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//  Output: [0,1,2,3] or [0,2,1,3]
//  Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
//  courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//  So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//  Note:
//
//  The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a
//  graph is represented.
//  You may assume that there are no duplicate edges in the input prerequisites.


  static List<Integer> res;

  public static int[] findOrder(int N, int[][] preq) {
    if (preq == null || N < 0) return new int[0];

    List<List<Integer>> adjList = new ArrayList<>();
    res = new ArrayList<>();
    for (int i = 0; i < N; i++)
      adjList.add(new ArrayList<>());

    for (int[] p : preq)
      adjList.get(p[1]).add(p[0]);


    boolean[] recStack = new boolean[N];
    boolean[] processed = new boolean[N];
    boolean valid = true;
    for (int i = 0; i < N; i++) {
      if (processed[i]) continue;
      valid &= dfs(i, adjList, recStack, processed);
      if (!valid) return new int[0];
    }

    int[] seq = new int[N];
    int i = 0;

    for (int s : res)
      seq[i++] = s;

    return seq;
  }

  private static boolean dfs(int v, List<List<Integer>> adjList, boolean[] recStack, boolean[] processed) {
    if (recStack[v]) return false;
    recStack[v] = true;

    for (int n : adjList.get(v)) {
      if (processed[n]) continue;
      boolean valid = dfs(n, adjList, recStack, processed);
      if (!valid) return false;
    }

    recStack[v] = false;
    processed[v] = true;
    res.add(0, v);
    return true;
  }

  public static void main(String[] args) {
//    int N = 2;
//    int[][] courses = new int[][]{{0, 1}, {1, 0}};
//    int N = 2;
//    int[][] courses = new int[][]{{0, 1}};
    int N = 2;
    int[][] courses = new int[][]{{1, 0}};

    int[] res = findOrder(N, courses);
    System.out.println(Arrays.toString(res));
  }
}
