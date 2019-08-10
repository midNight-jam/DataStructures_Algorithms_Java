package darkRealm;

public class QuickUnion {
  private int[] roots;
  private int size;

  QuickUnion(int N) {
    roots = new int[N];
    this.size = N;
    // Each node in the graph is initially root of itself
    for (int i = 0; i < N; i++)
      roots[i] = i;
  }


  public void union(int f, int t) {
    int froot = root(f);
    int troot = root(t);
    if (froot == troot) return;
    roots[froot] = troot; // make one component root of another
  }
  
  private int root(int r) {
    while (r != roots[r]) {
      r = roots[r];
    }
    return r;
  }


  public boolean areConnected(int f, int t) {
    int fr = root(f);
    int tr = root(t);
    return fr == tr; // are both belonging to same component
  }

  public void currentAdjacencyGraph() {
    StringBuilder vertices = new StringBuilder();
    StringBuilder subcomponents = new StringBuilder();
    for (int i = 0; i < roots.length; i++) {
      vertices.append(i + " ");
      subcomponents.append(roots[i] + " ");
    }

    System.out.println("Vertices    : " + vertices.toString());
    System.out.println("Components  : " + subcomponents.toString());
    System.out.println();
  }


  public static void main(String[] args) {
    QuickUnion qu = new QuickUnion(7);
    qu.union(4, 5);
    qu.union(0, 2);
    System.out.println("4 - > 2 connected : " + qu.areConnected(4, 2));
    qu.currentAdjacencyGraph();
    qu.union(2, 4);
    System.out.println("4 - > 2 connected : " + qu.areConnected(4, 2));
    qu.union(1, 3);
    qu.currentAdjacencyGraph();
    qu.union(6, 5);
    System.out.println("0 - > 6 connected : " + qu.areConnected(0, 6));
    qu.currentAdjacencyGraph();
  }
}
