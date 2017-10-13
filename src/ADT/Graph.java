package ADT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Jayam on 12/28/2016.
 */

public class Graph {
  public int vertices;
  public GNode start;
  public GNode[] allVertices;
  public int processed;
  public String buildOrder;

  public Graph(int v) {
    vertices = v;
    start = new GNode(vertices);
    allVertices = new GNode[vertices];
    buildOrder = "";
  }

  public void BreadthFirstTraversal() {
    MyQueue<GNode> queue = new MyQueue<>();
    queue.enqueue(start);
    start.status = GNode.Status.UnderProcessing;
    GNode trav;
    System.out.println("Breadth First traversal");
    while (!queue.isEmpty()) {
      trav = queue.deque();
      visitNode(trav);
      trav.status = GNode.Status.Processed;
      // add the next adjacent vertices in queue for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the queue
        if ((trav.childs[i] != null) && trav.childs[i].status == GNode.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = GNode.Status.UnderProcessing;
        }
      }
    }
    resetNodesStatus();
  }

  public void DepthFirstTraversal() {
    GNode trav;
    MyStack<GNode> stack = new MyStack<>();
    stack.push(start);
    start.status = GNode.Status.UnderProcessing;
    System.out.println("Depth First traversal");

    while (!stack.isEmpty()) {
      trav = stack.pop();
      visitNode(trav);
      trav.status = GNode.Status.Processed;
      // add the next adjacent vertices in stack for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the stack
        if ((trav.childs[i] != null) && trav.childs[i].status == GNode.Status.NotProcessed) {
          stack.push(trav.childs[i]);
          trav.childs[i].status = GNode.Status.UnderProcessing;
        }
      }
    }
    resetNodesStatus();
  }

  private static int minDistance(int dist[], Boolean shortestPathSet[]) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < dist.length; v++)
      if (shortestPathSet[v] == false && dist[v] <= min) {
        min = dist[v];
        min_index = v;
      }

    return min_index;
  }


  public static void dijkstra(int graph[][], int src) {
    int vertices = graph.length;
    int dist[] = new int[vertices]; // The output array. dist[i] will hold
    // the shortest distance from src to i
    // sptSet[i] will true if vertex i is included in shortest
    // path tree or shortest distance from src to i is finalized
    Boolean shortestPathSet[] = new Boolean[vertices];

    // Initialize all distances as INFINITE and stpSet[] as false
    for (int i = 0; i < vertices; i++) {
      dist[i] = Integer.MAX_VALUE;
      shortestPathSet[i] = false;
    }

    // Distance of source vertex from itself is always 0
    dist[src] = 0;

    // Find shortest path for all vertices
    for (int count = 0; count < vertices - 1; count++) {
      // Pick the minimum distance vertex from the set of vertices
      // not yet processed. u is always equal to src in first
      // iteration.
      int u = minDistance(dist, shortestPathSet);

      // Mark the picked vertex as processed
      shortestPathSet[u] = true;

      // Update dist value of the adjacent vertices of the
      // picked vertex.
      for (int v = 0; v < vertices; v++)

        // Update dist[v] only if is not in sptSet, there is an
        // edge from u to v, and total weight of path from src to
        // v through u is smaller than current value of dist[v]
        if (!shortestPathSet[v] && graph[u][v] != 0 &&
            dist[u] != Integer.MAX_VALUE &&
            dist[u] + graph[u][v] < dist[v])
          dist[v] = dist[u] + graph[u][v];
    }
    System.out.println("Dist : " + Arrays.toString(dist));
  }

  private void visitNode(GNode n) {
    System.out.println("Visiting - " + n.name);
  }

  private void reduceIncoming(GNode n) {
    for (int i = 0; i < n.childs.length; i++) {
      if (n.childs[i] != null && n.childs[i].incomingEdges > 0) {
        n.childs[i].incomingEdges--;
      }
    }
  }

  public void resetNodesStatus() {
    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        if (allVertices[i] != null && allVertices[i].childs[j] != null) {
          allVertices[i].childs[j].status = GNode.Status.NotProcessed;
        }
      }
    }
  }

  /*  [Prob 4.1]
  *   Q) Route Between NOdes : Given a directed Graph, design an alogrithm to findout whether there is a route between
  *   two nodes.
  *   A) Will use BFS for finding if we can reach the node 2 from node 1 (as the given is directed)
  * */
  public boolean isRouteBetween(GNode p, GNode q) {
    return modifiedBFS(p, q);
  }

  private boolean modifiedBFS(GNode p, GNode q) {
    MyQueue<GNode> queue = new MyQueue<>();
    queue.enqueue(p);
    p.status = GNode.Status.UnderProcessing;
    GNode trav;
    boolean oneVisited;
    oneVisited = false;
    while (!queue.isEmpty()) {
      trav = queue.deque();
      if (!oneVisited && (trav.name.equals(p.name))) {
        System.out.println(p.name + " - visisted ");
        oneVisited = true;
      } else if (oneVisited && (trav.name.equals(q.name))) {
        System.out.println(q.name + " - visisted ");
        System.out.println("Route present between " + p.name + "  & " + q.name);
        return true;
      }
      trav.status = GNode.Status.Processed;
      for (int i = 0; i < trav.childs.length; i++) {
        if ((trav.childs[i] != null) && trav.childs[i].status == GNode.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = GNode.Status.UnderProcessing;
        }
      }
    }
    resetNodesStatus();
    return false;
  }

  public void modifiedBreadthFirstTraversal() {
    MyQueue<GNode> queue = new MyQueue<>();
    queue.enqueue(start);
    start.status = GNode.Status.UnderProcessing;
    GNode trav;
    System.out.println("Breadth First traversal");
    while (!queue.isEmpty()) {
      trav = queue.deque();
      reduceIncoming(trav);
      if (trav.incomingEdges == 0) {
        trav.status = GNode.Status.Processed;
        processed--;
        buildOrder += " " + trav.name;
      }
      // add the next adjacent vertices in queue for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the queue
        if ((trav.childs[i] != null) && trav.childs[i].status == GNode.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = GNode.Status.UnderProcessing;
        }
      }
    }
  }

  public String topologicalSort() {
    Set<GNode> visited = new HashSet<>();
    Stack<GNode> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < allVertices.length; i++) {
      if (visited.contains(allVertices[i])) continue;
      topologicalSortUtil(allVertices[i], visited, stack);
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop().name + " ");
    }
    return sb.toString();
  }

  private void topologicalSortUtil(GNode trav, Set<GNode> visited, Stack<GNode> stack) {
    visited.add(trav);
    for (int i = 0; i < trav.childs.length; i++) {
      // i have null check because of my implementation, Originally its not required
      if (visited.contains(trav.childs[i]) || trav.childs[i] == null) continue;
      topologicalSortUtil(trav.childs[i], visited, stack);
    }
    stack.push(trav);
  }
}