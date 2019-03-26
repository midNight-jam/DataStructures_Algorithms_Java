package darkRealm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

//  323. Number of Connected Components in an Undirected Graph
//  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a
//  function to find the number of connected components in an undirected graph.
//
//  Example 1:
//  Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
//
//      0          3
//      |          |
//      1 --- 2    4
//
//  Output: 2
//
//  Example 2:
//  Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//      0           4
//      |           |
//      1 --- 2 --- 3
//
//  Output:  1
//  Note:
//  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
//  as [1, 0] and thus will not appear together in edges.

  public static int countComponents(int n, int[][] edges) {
    if (null == edges || 1 > edges.length || 1 > edges[0].length) return n; // no edges so components == nodes
    int[] component = new int[n];
    for (int i = 0; i < n; i++)
      component[i] = i;

    for (int[] e : edges) {
      int start = e[0];
      int end = e[1];
      int cs = component[start];
      int ce = component[end];

      for (int i = 0; i < n; i++)
        if (component[i] == cs)
          component[i] = ce;
    }

    System.out.println(Arrays.toString(component));

    Set<Integer> set = new HashSet<>();
    for (int i : component)
      set.add(i);

    return set.size();
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {4, 3}, {2, 4}};
    int res = countComponents(n, edges);
    System.out.println(n);
    System.out.println(res);
  }
}
