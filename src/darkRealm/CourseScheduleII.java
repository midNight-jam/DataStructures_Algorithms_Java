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

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites.length < 1) return new int[]{};

    int N = numCourses;
    List<Integer>[] adjList = new List[N];
    for (int i = 0; i < N; i++)
      adjList[i] = new ArrayList<>();


    for (int[] e : prerequisites) {
      int from = e[1];
      int to = e[0];
      adjList[from].add(to);
    }

    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[N];
    boolean[] underProcessing = new boolean[N];

    for (int i = 0; i < N; i++) {
      if (visited[i]) continue;
      if (!dfs(adjList, i, stack, visited, underProcessing))
        return new int[]{};
    }

    int[] res = new int[stack.size()];
    for (int i = 0; stack.size() > 0; i++)
      res[i] = stack.pop();

    return res;
  }

  private static boolean dfs(List<Integer>[] adjList, int v, Stack<Integer> stack, boolean[] visited, boolean[] underProcessing) {
    if (underProcessing[v]) return false;

    underProcessing[v] = true;

    List<Integer> neighbours = adjList[v];
    for (int i = 0; i < neighbours.size(); i++) {
      int neighbour = neighbours.get(i);
      if (visited[neighbour]) continue;
      if (!dfs(adjList, neighbour, stack, visited, underProcessing))
        return false;
    }

    underProcessing[v] = false;
    visited[v] = true;
    stack.add(v); // we always add the node after processing all of its neighbours
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
