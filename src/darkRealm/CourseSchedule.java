package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {


//  207. Course Schedule
//  There are a total of n courses you have to take, labeled from 0 to n-1.
//
//  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
//  expressed as a pair: [0,1]
//
//  Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//  Example 1:
//
//  Input: 2, [[1,0]]
//  Output: true
//  Explanation: There are a total of 2 courses to take.
//  To take course 1 you should have finished course 0. So it is possible.
//  Example 2:
//
//  Input: 2, [[1,0],[0,1]]
//  Output: false
//  Explanation: There are a total of 2 courses to take.
//  To take course 1 you should have finished course 0, and to take course 0 you should
//  also have finished course 1. So it is impossible.
//  Note:
//
//  The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
//  Read more about how a graph is represented.
//  You may assume that there are no duplicate edges in the input prerequisites.

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length < 1)
      return true;

    int N = numCourses;
    List<Integer>[] adjList = new List[N];
    for (int i = 0; i < N; i++)
      adjList[i] = new ArrayList<>();

    for (int[] e : prerequisites) {
      int from = e[1];
      int to = e[0];
      adjList[from].add(to);
    }

    boolean[] visited = new boolean[N];
    boolean[] recursionStack = new boolean[N];

    for (int i = 0; i < visited.length; i++) {
      if (visited[i]) continue; // already visited
      if (!isDAG(i, adjList, visited, recursionStack))
        return false;
    }
    return true;
  }

  private static boolean isDAG(int v, List<Integer>[] adjList, boolean[] visited, boolean[] recursionStack) {
    if (recursionStack[v]) // as node is already under process
      return false;

    recursionStack[v] = true; // add this node to recursion stack
    boolean isDAG = true;
    List<Integer> neighbours = adjList[v];
    for (int i = 0; i < neighbours.size(); i++) {
      int neighbour = neighbours.get(i);
      if (visited[neighbour]) continue;
      isDAG &= isDAG(neighbour, adjList, visited, recursionStack);
      if (!isDAG)
        return false;
    }

    recursionStack[v] = false; // pop the node from the stack
    visited[v] = true; // mark this node as done
    return true;
  }

  public static void main(String[] args) {
    int N = 2;
    int[][] courses = new int[][]{{0, 1}, {1, 0}};
//    int N = 2;
//    int[][] courses = new int[][]{{0, 1}};
//    int N = 3;
//    int[][] courses = new int[][]{{1, 0}};

    boolean res = canFinish(N, courses);
    System.out.println(res);
  }
}