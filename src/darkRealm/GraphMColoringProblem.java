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

  static int MColor;

  public static int [] mColorGraph(int N, int[][] dislikes, int m) {
    if(N < 0) return new int[0];
    MColor = m;
    List<Integer> [] adjList = new List[N+1];
    for(int i = 0; i <= N; i++)
      adjList[i] = new ArrayList<>();

    for(int i = 0; i < dislikes.length; i++){
      adjList[dislikes[i][0]].add(dislikes[i][1]);
      adjList[dislikes[i][1]].add(dislikes[i][0]);
    }

    int [] assignedColors = new int[N+1];
    for(int i = 1; i<= N; i++){
      if(assignedColors[i] != 0) continue;
      if(!dfsColorGraph(adjList, i, 0, assignedColors))
        return new int[0];
    }
    return assignedColors;
  }

  private static boolean dfsColorGraph(List<Integer> [] adjList, int v, int color, int [] assignedColors){
    if(assignedColors[v] != 0)
      return assignedColors[v] == color;

    assignedColors[v] = color;
    List<Integer> nbors = adjList[v];

    // We choose the next Color by incremneting & mod by the allowed colors
    for(int n : nbors){
      if(!dfsColorGraph(adjList, n, (color + 1) % MColor, assignedColors))
        return false;
    }

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

    int M = 2;
    int N = 4;
    int[][] arr = new int[][]{{1,2},{1,3},{2,4}};

    long start = System.currentTimeMillis();
    int[] res = mColorGraph(N, arr, M);
    long elapsedTimeMillis = System.currentTimeMillis() - start;
    System.out.println(elapsedTimeMillis);

//    int M = 2;
//    int[] res = mColorGraph(adjacencyList, M);

    System.out.println(Arrays.toString(res));
  }
}
