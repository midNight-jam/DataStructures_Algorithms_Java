package darkRealm;

import java.util.*;

public class MinimumHeightTrees {

//  310. Minimum Height
//  For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then
//  a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
//  Given such a graph, write a function to find all the MHTs and return a list of their root labels.
//
//  Format
//  The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
//  undirected edges (each edge is a pair of labels).
//
//  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as
//  [1, 0] and thus will not appear together in edges.
//
//  Example 1 :
//
//  Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//      0
//      |
//      1
//      / \
//      2   3
//
//  Output: [1]
//  Example 2 :
//
//  Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//      0  1  2
//      \ | /
//      3
//      |
//      4
//      |
//      5
//
//  Output: [3, 4]
//  Note:
//
//  According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are
//  connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
//  The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

  /*
   * Intuition is to start BFS from the leaf nodes & remove the leaf nodes, due to this removal the indegree of the parent
   * node of the leaf node will reduce, if after all such removals the parent node also becomes a leaf node then consider
   * it for processing & repeat. As it is a undirected graph, each edge will create an indegree on both the vertices, thus
   * the indegree of the leaf nodes is 1. At the end the nodes that are present in the que will be the nodes that are left
   * in the middle of the graph. Because we are doing bfs from the leaf nodes & shrinking the graph inwards by removing
   * a single level/leaves, the nodes in the graph at the end that can't shrinked further will be the nodes that have the
   * minimum dist to all the leaves MHT.
   * */
  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> res = new ArrayList<>();
    if (edges == null || edges.length < 1) {
      res.add(0);
      return res;
    }

    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adjList.add(new ArrayList<>());

    int[] degrees = new int[n];

    for (int[] e : edges) {
      adjList.get(e[0]).add(e[1]);
      adjList.get(e[1]).add(e[0]);
      degrees[e[0]]++;
      degrees[e[1]]++;
    }


    Queue<Integer> que = new LinkedList<>();
    for (int i = 0; i < n; i++)
      if (degrees[i] == 1)
        que.offer(i); // start BFS from the leaf nodes

    while (que.size() > 0) {
      int p = que.size();
      res = new ArrayList<>();
      while (p-- > 0) {
        int c = que.poll();
        res.add(c);
        for (int par : adjList.get(c)) {
          degrees[par]--;
          if (degrees[par] == 1)  // add the new leafs that are formed after removal of a edge
            que.offer(par);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    List<Integer> res = findMinHeightTrees(n, edges);
    System.out.println(res);
  }
}
