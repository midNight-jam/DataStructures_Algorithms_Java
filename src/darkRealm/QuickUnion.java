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


  public void union(int p, int q) {
    if (!(p < size && q < size)) return;
    // As we are making QuickUnion, we are keeping union cost O(1)
    int rootOfQ = roots[q];
    // make Q the new root of P
    roots[p] = rootOfQ;
  }


  public boolean areConnected(int p, int q) {
    if (!(p < size && q < size)) return false;
    // As we made union cheaper O(1), now we will have to incur cost while finding O(n)
    int rootOfP = roots[p];
    int rootOfQ = roots[q];

    // till we reach a node which is the root of itself
    while (rootOfP != p) {
      rootOfP = roots[rootOfP];
      // update p also, else we will end infinite loop, if 5 is root of itself
      p = rootOfP;
    }

    return rootOfP == rootOfQ;
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
