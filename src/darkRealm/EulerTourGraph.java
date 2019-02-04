package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EulerTourGraph {

  List<List<Integer>> adjList;
  int V;
  int[] visited;
  int index;

  EulerTourGraph(int v) {
    V = v;
    adjList = new ArrayList();
    for (int i = 0; i < V; i++)
      adjList.add(new ArrayList<>());
    visited = new int[V];
    Arrays.fill(visited, -1);
  }

  public void add(int u, int v) {
    // vertex out of range
    if (u < 0 || v < 0 || u >= V || v >= V) return;

    adjList.get(u).add(v);
    adjList.get(v).add(u);
  }

  public int[] eulerTour() {
    // euler tour length is always odd, nth odd no
    int[] eulerTour = new int[2 * V - 1];
    Arrays.fill(eulerTour, -1);
    Integer index = 0;// Integer as it will work on pass by reference
    dfsEuler(0, eulerTour);
    return eulerTour;
  }

  private void dfsEuler(int v, int[] eulerTour) {
    eulerTour[index++] = v;
    visited[v] = 1;
    for (int adjV : adjList.get(v)) {
      if (visited[adjV] != 1) {
        dfsEuler(adjV, eulerTour);
        eulerTour[index++] = v;
      }
    }
  }

  public static void main(String[] args) {
    EulerTourGraph etg = new EulerTourGraph(13);
//    etg.add(0, 4);
//    etg.add(4, 3);
//    etg.add(3, 1);
//    etg.add(3, 2);

    etg.add(0, 1);
    etg.add(0, 2);
    etg.add(0, 3);

    etg.add(2, 4);
    etg.add(2, 5);
    etg.add(2, 6);

    etg.add(5, 7);
    etg.add(5, 8);

    etg.add(6, 9);
    etg.add(6, 10);

    etg.add(9, 11);
    etg.add(9, 12);


    int[] res = etg.eulerTour();

    System.out.println("EulerTour");
    System.out.println(Arrays.toString(res));
  }
}
