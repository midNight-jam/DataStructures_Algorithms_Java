package ADT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// simple adjacency list representation of graph
public class GraphSimple {

  int N; // vertices;
  List<Integer>[] adjacencylist;

  GraphSimple(int vertices) {
    N = vertices; // becoz i dont want to get in 0 index stuff
    adjacencylist = new List[N];
    for (int i = 0; i < N; i++)
      adjacencylist[i] = new ArrayList<>();
  }

  public void addEdge(int u, int v) {
    adjacencylist[u].add(v);
  }

  private void topologicalHelper(int v, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;  // mark this node as visited
    List<Integer> adjVertices = adjacencylist[v];
    for (int i = 0; i < adjVertices.size(); i++) {
      int nextVertex = adjVertices.get(i);
      if (!visited[nextVertex])
        topologicalHelper(nextVertex, visited, stack);
    }

    stack.push(v);
  }

  public List<Integer> topologicalSort() {
    System.out.println("Topological sort only works if given graph is DAG");
    List<Integer> res = new ArrayList<>();
    // for keeping the processed nodes in reverse order
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      if (!visited[i])
        topologicalHelper(i, visited, stack);
    }

    while (stack.size() > 0)
      res.add(stack.pop());

    return res;
  }


  public static void main(String[] args) {
    System.out.println("This is a simple graph via adjacency list");

//    GraphSimple graph = new GraphSimple(6);
//    graph.addEdge(5, 2);
//    graph.addEdge(5, 0);
//    graph.addEdge(4, 1);
//    graph.addEdge(4, 0);
//    graph.addEdge(2, 3);
//    graph.addEdge(3, 1);

    GraphSimple graph = new GraphSimple(7);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 6);

    List<Integer> res = graph.topologicalSort();
    System.out.println(res);
  }
}
