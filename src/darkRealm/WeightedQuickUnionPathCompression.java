package darkRealm;

import java.util.Arrays;

public class WeightedQuickUnionPathCompression {

  int size;
  int[] connectedComponents;
  int[] sizeOfTree;

  WeightedQuickUnionPathCompression(int N) {
    this.size = N;
    connectedComponents = new int[N];
    sizeOfTree = new int[N];
    Arrays.fill(sizeOfTree, 1); // each tree has single node so size is 1
    for (int i = 0; i < connectedComponents.length; i++)
      connectedComponents[i] = i;
  }

  private int pathCompresssionRoot(int node) {
    while (node != connectedComponents[node]) {
      //replace the parent with grandparent, this way we are halving the parent lookup & will result in logarithmic time
      connectedComponents[node] = connectedComponents[connectedComponents[node]];
      node = connectedComponents[node];
    }
    return node;
  }

  public boolean connected(int p, int q) {
    return pathCompresssionRoot(p) == pathCompresssionRoot(q);
  }

  public void unionUsingCompression(int p, int q) {
    int pRoot = pathCompresssionRoot(p);
    int qRoot = pathCompresssionRoot(q);

    if (pRoot == qRoot) return; // already connected

    int pRank = sizeOfTree[pRoot];
    int qRank = sizeOfTree[qRoot];

    // make the smaller rank point to higher rank (increase rank of higher rank)
    if (pRank > qRank) {
      connectedComponents[qRoot] = connectedComponents[pRoot];
      sizeOfTree[pRoot] += sizeOfTree[qRoot];
    } else {
      connectedComponents[pRoot] = connectedComponents[qRoot];
      sizeOfTree[qRoot] += sizeOfTree[pRoot];
    }
  }


  public static void main(String[] args) {
    WeightedQuickUnionPathCompression wqu = new WeightedQuickUnionPathCompression(7);
    System.out.println(Arrays.toString(wqu.connectedComponents));

    wqu.unionUsingCompression(4, 5);
    wqu.unionUsingCompression(0, 2);
    System.out.println(Arrays.toString(wqu.connectedComponents));

    wqu.unionUsingCompression(2, 4);
    System.out.println(Arrays.toString(wqu.connectedComponents));

    wqu.unionUsingCompression(1, 3);
    System.out.println(Arrays.toString(wqu.connectedComponents));

    wqu.unionUsingCompression(6, 5);
    System.out.println(Arrays.toString(wqu.connectedComponents));

    System.out.println("2 - 3 connceted --- " + wqu.connected(2, 3));
    System.out.println("1 - 5 connceted --- " + wqu.connected(1, 5));
    System.out.println("4 - 2 connceted --- " + wqu.connected(2, 4));
  }
}
