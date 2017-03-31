package darkRealm;

import java.util.*;

/**
 * Created by Jayam on 3/30/2017.
 */
class Node {
  String name;
  List<Node> childs;
  boolean status;
  Node(String name) {
    this.name = name;
    childs = new LinkedList<>();
  }
}

public class Graph {
  Node start;
  public int size;

  Graph(Node s) {
    this.start = s;
  }

  public void doBFS() {
    Node trav = start;
    Queue<Node> que = new LinkedList<>();
    que.add(trav);
    trav.status = true;
    while (!que.isEmpty()) {
      trav = que.poll();
      System.out.println("Processed : " + trav.name);
      for (int i = 0; i < trav.childs.size(); i++) {
        if (!trav.childs.get(i).status)
          que.add(trav.childs.get(i));
      }
    }
  }

  public void doDFS() {
    Node trav = start;
    Stack<Node> stack = new Stack<>();
    stack.push(trav);
    trav.status = true;
    while (!stack.isEmpty()) {
      trav = stack.pop();
      System.out.println("Processed : " + trav.name);
      for (int i = 0; i < trav.childs.size(); i++) {
        if (!trav.childs.get(i).status)
          stack.push(trav.childs.get(i));
      }
    }
  }

  // have done dijkstras using Adjacenny Matrix iimplementation
  public void Djikstras(int[][] adjMat, int src) {
    int size = adjMat.length;
    int[] dist = new int[size];
    boolean[] calculated = new boolean[size];
    for (int i = 0; i < dist.length; i++) {
      dist[i] = Integer.MAX_VALUE;  // initialize whoe array with infinite dist
      calculated[i] = false;  // and nothing calculated
    }
    // we are assuming the source vertex to be 0, if anythign else then the dist from dource vertex to itself is always 0
    dist[src] = 0;
    for (int count = 0; count < size - 1; count++) {
      int shortestVertex = closestVertex(dist, calculated);
      // Mark the picked vertex as processed
      calculated[shortestVertex] = true;

      for (int i = 0; i < size; i++) {
        // 3 Conditions
        // 1 : the node has not been processed for shortest dist
        // 2 : there is a vertex between this node & the current shortest found node
        // 3 : the calculated dist for this node is is biggen than the sum of dist from shortestNode + origianl dist
        if (calculated[i] == false && adjMat[shortestVertex][i] != 0
            && dist[shortestVertex] != Integer.MAX_VALUE && dist[shortestVertex] + dist[i] < dist[i]) {
          dist[i] = dist[shortestVertex] + adjMat[shortestVertex][i];
        }
      }
    }

    System.out.println(Arrays.toString(dist));
  }

  public int closestVertex(int[] dist, boolean[] calculated) {
    int minDist = Integer.MIN_VALUE;
    int minIndex = -1;
    for (int i = 0; i < dist.length; i++)
      if (calculated[i] == false && dist[i] < minDist) {
        minDist = dist[i];
        minIndex = i;
      }
    return minIndex;
  }

  public static void main(String[] args) {
    Node n1 = new Node("A");
    Node n2 = new Node("B");
    Node n3 = new Node("C");
    Node n4 = new Node("D");
    Node n5 = new Node("E");
    n1.childs.add(n2);
    n1.childs.add(n3);
    n2.childs.add(n4);
    n4.childs.add(n5);

    Graph g = new Graph(n1);

//    g.doBFS();
    g.doDFS();
    g.size = 5;
  }
}