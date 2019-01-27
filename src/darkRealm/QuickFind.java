package darkRealm;

public class QuickFind {

  private int[] components;
  private int size;

  QuickFind(int N) {
    components = new int[N];
    this.size = N;
    // Each node in the graph is initially connected to itself
    for(int i = 0 ; i < N; i++){
      components[i] = i;
    }
  }


  public void union(int p, int q) {
    if (!(p < size && q < size)) return;
    int componentOfP = components[p];
    int componentOfQ = components[q];
    // As we are making quickFind, we are keeping union costly O(n)
    for (int i = 0; i < size; i++) {
      // make all the components of Q into p, as they are both getting connected
      if (components[i] == componentOfQ)
        components[i] = componentOfP;
    }
  }


  public boolean areConnected(int p, int q) {
    if (!(p < size && q < size)) return false;
    // As we made union costly, now we can leverage that and return connected in O(1)
    return components[p] == components[q];
  }

  public void currentAdjacencyGraph() {
    StringBuilder vertices = new StringBuilder();
    StringBuilder subcomponents = new StringBuilder();
    for (int i = 0; i < components.length; i++) {
      vertices.append(i + " ");
      subcomponents.append(components[i] + " ");
    }

    System.out.println("Vertices    : " + vertices.toString());
    System.out.println("Components  : " + subcomponents.toString());
    System.out.println();
  }


  public static void main(String[] args) {
    QuickFind qf = new QuickFind(7);
    qf.union(4,5);
    qf.union(0,2);
    System.out.println("4 - > 2 connected : " + qf.areConnected(4,2));
    qf.currentAdjacencyGraph();
    qf.union(2,4);
    System.out.println("4 - > 2 connected : " + qf.areConnected(4,2));
    qf.union(1,3);
    qf.currentAdjacencyGraph();
    qf.union(6,5);
    System.out.println("0 - > 6 connected : " + qf.areConnected(0,6));
    qf.currentAdjacencyGraph();
  }
}
