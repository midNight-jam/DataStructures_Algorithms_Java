package darkRealm;

import java.util.*;

public class MinimumSpanningTreeKruskals {

  //In Kruskal’s algorithm, most time consuming operation O(ElogV) is sorting because the total complexity of the Disjoint-Set operations will be
  // O(N), thus overall Time Complexity of the algorithm is O(ElogV). E = edges, V = vertex
  private static class Edge {
    int cost;
    int from;
    int to;

    Edge(int c, int f, int t) {
      cost = c;
      from = f;
      to = t;
    }
  }

  
  // Idea is to sort the edges based on weight, & then pick each edge & add them to minimumSpaningTree only if adding this
  // edge doesnt creates a cycle, This is where the QuickUnion subroutine comes into play
  public static List<int[]> minimumSpaningTreeKrusKals(int[][] adjList) {
    List<int[]> res = new ArrayList<>();
    int vertices = adjList.length;
    List<Edge> list = new ArrayList<>();
    for (int i = 0; i < adjList.length; i++)
      for (int j = 0; j < adjList.length; j++) {
        if (adjList[i][j] == 0) continue;
        list.add(new Edge(adjList[i][j], i, j));
      }

    Collections.sort(list, new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        if (o1.cost < o2.cost) return -1;
        if (o1.cost > o2.cost) return 1;
        return 0;
      }
    });

    int[] roots = new int[vertices];
    for (int i = 0; i < roots.length; i++)
      roots[i] = i;

    int minCost = 0;
    for (int i = 0; i < list.size(); i++) {
      Edge e = list.get(i);
      // if both vertices belong to same connected components, unioning them will make a cycle, which is not allowed in Tree
      if (connected(roots, e.from, e.to)) continue;
      res.add(new int[]{e.from, e.to});
      union(roots, e.from, e.to);
      minCost += e.cost;
    }
    System.out.println(minCost);
    return res;
  }

  private static boolean connected(int[] roots, int from, int to) {
    int fromRoot = getRoot(roots, from);
    int toRoot = getRoot(roots, to);
    // are both vertices belong to same connected components
    return fromRoot == toRoot;
  }

  private static int getRoot(int[] roots, int root) {
    // a connected components ends at the vertex which is the root of itself, i.e doesnt has any root
    while (roots[root] != root)
      root = roots[root];
    return root;
  }

  private static void union(int[] roots, int from, int to) {
    // fetch the root of both the connected components & make one a root of another
    int fromRoot = getRoot(roots, from);
    int toRoot = getRoot(roots, to);
    if (fromRoot == toRoot) return; // already connected
    roots[fromRoot] = toRoot;
  }


  private static int[][] trasformToUpperHalif(int[][] mat) {
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++) {
        int val = mat[i][j] + mat[j][i];
        mat[i][j] = val;
        if (j <= i) mat[i][j] = 0;
      }
    return mat;
  }

  public static void main(String[] args) {
    // bidrectional graph
//    int[][] adjList = new int[][]{
//        {0, 7, 0, 0, 1},
//        {0, 0, 6, 0, 5},
//        {0, 0, 0, 2, 3},
//        {0, 0, 0, 0, 4},
//        {0, 0, 0, 0, 0},
//    };

//    int[][] adjList = new int[][]{
//        {0, 1, 3, 4},
//        {0, 0, 2, 0},
//        {0, 0, 0, 5},
//        {0, 0, 0, 0},
//    };


    Scanner s = new Scanner(System.in);
    String input = s.nextLine();
    String[] arr = input.split(" ");
    int vertices = Integer.parseInt(arr[0]);
    int edges = Integer.parseInt(arr[1]);
    int[][] adj = new int[vertices][vertices];

    while (edges-- > 0) {
      input = s.nextLine().trim();
      arr = input.split(" ");
      int from = Integer.parseInt(arr[0]);
      int to = Integer.parseInt(arr[1]);
      int weight = Integer.parseInt(arr[2]);
      adj[from - 1][to - 1] = weight;
    }

//    for (int[] a : adj)
//      System.out.println(Arrays.toString(a));

    int[][] mat = trasformToUpperHalif(adj);


//    for (int[] a : mat)
//      System.out.println(Arrays.toString(a));

    List<int[]> res = minimumSpaningTreeKrusKals(mat);
    for (int[] r : res)
      System.out.println(Arrays.toString(r));

  }
}
