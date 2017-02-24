package darkRealm.CTCI.Trees_and_Graphs;

import darkRealm.CTCI.Stacks_and_queues.MyQueue;
import darkRealm.CTCI.Stacks_and_queues.MyStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Jayam on 12/28/2016.
 */

public class Graph {
  public int vertices;
  public Node start;
  public Node[] allVertices;
  int processed;
  String buildOrder;

  public Graph(int v) {
    vertices = v;
    start = new Node(vertices);
    allVertices = new Node[vertices];
    buildOrder = "";
  }

  public void BreadthFirstTraversal() {
    MyQueue<Node> queue = new MyQueue<>();
    queue.enqueue(start);
    start.status = Node.Status.UnderProcessing;
    Node trav;
    System.out.println("Breadth First traversal");
    while (!queue.isEmpty()) {
      trav = queue.deque();
      visitNode(trav);
      trav.status = Node.Status.Processed;
      // add the next adjacent vertices in queue for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the queue
        if ((trav.childs[i] != null) && trav.childs[i].status == Node.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = Node.Status.UnderProcessing;
        }
      }
    }
    resetNodesStatus();
  }

  public void DepthFirstTraversal() {
    Node trav;
    MyStack<Node> stack = new MyStack<>();
    stack.push(start);
    start.status = Node.Status.UnderProcessing;
    System.out.println("Depth First traversal");

    while (!stack.isEmpty()) {
      trav = stack.pop();
      visitNode(trav);
      trav.status = Node.Status.Processed;
      // add the next adjacent vertices in stack for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the stack
        if ((trav.childs[i] != null) && trav.childs[i].status == Node.Status.NotProcessed) {
          stack.push(trav.childs[i]);
          trav.childs[i].status = Node.Status.UnderProcessing;
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


  static void dijkstra(int graph[][], int src) {
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

  private void visitNode(Node n) {
    System.out.println("Visiting - " + n.name);
  }

  private void reduceIncoming(Node n) {
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
          allVertices[i].childs[j].status = Node.Status.NotProcessed;
        }
      }
    }
  }

  /*  [Prob 4.1]
  *   Q) Route Between NOdes : Given a directed Graph, design an alogrithm to findout whether there is a route between
  *   two nodes.
  *   A) Will use BFS for finding if we can reach the node 2 from node 1 (as the given is directed)
  * */
  public boolean isRouteBetween(Node p, Node q) {
    return modifiedBFS(p, q);
  }

  private boolean modifiedBFS(Node p, Node q) {
    MyQueue<Node> queue = new MyQueue<>();
    queue.enqueue(p);
    p.status = Node.Status.UnderProcessing;
    Node trav;
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
      trav.status = Node.Status.Processed;
      for (int i = 0; i < trav.childs.length; i++) {
        if ((trav.childs[i] != null) && trav.childs[i].status == Node.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = Node.Status.UnderProcessing;
        }
      }
    }
    resetNodesStatus();
    return false;
  }

  public void modifiedBreadthFirstTraversal() {
    MyQueue<Node> queue = new MyQueue<>();
    queue.enqueue(start);
    start.status = Node.Status.UnderProcessing;
    Node trav;
    System.out.println("Breadth First traversal");
    while (!queue.isEmpty()) {
      trav = queue.deque();
      reduceIncoming(trav);
      if (trav.incomingEdges == 0) {
        trav.status = Node.Status.Processed;
        processed--;
        buildOrder += " " + trav.name;
      }
      // add the next adjacent vertices in queue for processing
      for (int i = 0; i < trav.childs.length; i++) {
        // if the next vertex has not been processed put it in for processing in the queue
        if ((trav.childs[i] != null) && trav.childs[i].status == Node.Status.NotProcessed) {
          queue.enqueue(trav.childs[i]);
          trav.childs[i].status = Node.Status.UnderProcessing;
        }
      }
    }
  }

  public String topologicalSort() {
    Set<Node> visited = new HashSet<>();
    Stack<Node> stack = new Stack<>();
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

  private void topologicalSortUtil(Node trav, Set<Node> visited, Stack<Node> stack) {
    visited.add(trav);
    for (int i = 0; i < trav.childs.length; i++) {
      // i have null check because of my implementation, Originally its not required
      if (visited.contains(trav.childs[i]) || trav.childs[i] == null) continue;
      topologicalSortUtil(trav.childs[i], visited, stack);
    }
    stack.push(trav);
  }
}