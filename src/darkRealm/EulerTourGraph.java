package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * In graph theory, an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly
 * once (allowing for revisiting vertices). Similarly, an Eulerian circuit or Eulerian cycle is an Eulerian trail that
 * starts and ends on the same vertex. They were first discussed by Leonhard Euler while solving the famous Seven
 * Bridges of Königsberg problem in 1736. The problem can be stated mathematically like this:
 * Given the graph in the image, is it possible to construct a path (or a cycle, i.e. a path starting and ending on
 * the same vertex) that visits each edge exactly once?
 * */

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
