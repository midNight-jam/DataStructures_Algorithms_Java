package darkRealm;

import java.util.Arrays;

public class RedundantConnection {

//  684. Redundant Connection
//  In this problem, a tree is an undirected graph that is connected and has no cycles.
//  The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one
//  additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that
//  already existed.
//
//  The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that
//  represents an undirected edge connecting nodes u and v.
//
//  Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers,
//  return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format,
//  with u < v.
//
//  Example 1:
//  Input: [[1,2], [1,3], [2,3]]
//  Output: [2,3]
//  Explanation: The given undirected graph will be like this:
//      1
//      / \
//      2 - 3
//
//  Example 2:
//  Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//  Output: [1,4]
//  Explanation: The given undirected graph will be like this:
//      5 - 1 - 2
//      |   |
//      4 - 3
//  Note:
//  The size of the input 2D-array will be between 3 and 1000.
//  Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
//
//  Update (2017-09-26):
//  We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph.
//  For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.

  public static int[] findRedundantConnection(int[][] edges) {
    if (edges == null || edges.length < 1 || edges[0].length < 1) return new int[2];
    // the idea is to prevent connecting 2 nodes if they are already in the same component,
    // thus any edge that is going to connect two nodes that are already in the same component
    // is the edge that we have to return as the result.

    int[] component = new int[edges.length + 1];
    for (int i = 0; i < component.length; i++)
      component[i] = i; // each is a seperate component;

    int[] sizeOfComponent = new int[edges.length + 1];
    Arrays.fill(sizeOfComponent, 1); // each component is initially of size 1, due to onlyone node in the component

    for (int[] e : edges) {
      int p = e[0];
      int q = e[1];

      int pRoot = getRoot(component, p);
      int qRoot = getRoot(component, q);
      if (pRoot == qRoot)
        return e;

      // rank based union, lower rank component gets attached to higher rank component
      if (sizeOfComponent[pRoot] > sizeOfComponent[qRoot]) {
        component[qRoot] = pRoot;
        sizeOfComponent[pRoot] += sizeOfComponent[qRoot];
      } else {
        component[pRoot] = qRoot;
        sizeOfComponent[qRoot] += sizeOfComponent[pRoot];
      }
    }

    return new int[2];

  }

  private static int getRoot(int[] component, int x) {
    // usual path compression
    while (x != component[x]) {
      // replacing prante with grand parent
      component[x] = component[component[x]];
      x = component[x];
    }
    return x;
  }

  public static void main(String[] args) {
    int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
    int[] res = findRedundantConnection(edges);
    System.out.println(Arrays.toString(res));
  }
}
