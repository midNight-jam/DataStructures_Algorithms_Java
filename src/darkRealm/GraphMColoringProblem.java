package darkRealm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no
* two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of
* colors to all vertices.
* Input:
* 1) A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation
  of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
* 2) An integer m which is the maximum number of colors that can be used.
* Output:
* An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex.
* The code should also return false if the graph cannot be colored with m colors.
* Following is an example of graph that can be colored with 3 different colors.
* https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
* */
public class GraphMColoringProblem {

  public static int[] mColorGraph(int N, int[][] mat, int M) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < N + 1; i++)
      adjList.add(new ArrayList<>());

    for (int[] r : mat) {
      int from = r[0];
      int to = r[1];
      adjList.get(from).add(to);
      adjList.get(to).add(from);
    }


    int vertices = adjList.size();
    int[] assignedColors = new int[vertices];
    Arrays.fill(assignedColors, -1);
    dfsHelper(assignedColors, adjList, 1, M);
    return assignedColors;
  }

  private static boolean dfsHelper(int[] assignedColors, List<List<Integer>> adjList, int vertex, int M) {
    // if we have colored all the vertices return
    if (vertex == assignedColors.length) return true;
    for (int c = 1; c <= M; c++) {
      if (!isSafeToAssignColor(vertex, c, adjList, assignedColors)) continue;
      assignedColors[vertex] = c;
      boolean nextColor = dfsHelper(assignedColors, adjList, vertex + 1, M);
      if (nextColor) return true; // dfs succeded & we were able to color all vertices so return true
      assignedColors[vertex] = -1;// reset the color, & try the next color
    }
    // if after dfs we were not able to M color graph return false
    return false;
  }

  private static boolean isSafeToAssignColor(int vertex, int color, List<List<Integer>> adjecacenyList, int[] assignedColors) {
    // if any nieghbor is assigned a same color then this color assignment is not safe
    List<Integer> neighbors = adjecacenyList.get(vertex);
    for (int n : neighbors)
      if (color == assignedColors[n])
        return false;
    return true;
  }

  public static void main(String[] args) {
    /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */


    // below graph from  : https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
    int N = 10;
    int[][] arr = new int[][]{
        {1, 2}, {1, 6}, {1, 5}, {2, 7}, {2, 3}, {5, 10}, {3, 8}, {3, 4},
        {7, 9}, {7, 10}, {4, 9}, {4, 5}, {8, 6}, {8, 10}, {9, 6}
    };

    int M = 3;
    long start = System.currentTimeMillis();
    int[] res = mColorGraph(N, arr, M);
    long elapsedTimeMillis = System.currentTimeMillis() - start;
    System.out.println(elapsedTimeMillis);

//    int M = 2;
//    int[] res = mColorGraph(adjacencyList, M);

    System.out.println(Arrays.toString(res));
  }
}
