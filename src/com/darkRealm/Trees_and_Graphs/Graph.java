package com.darkRealm.Trees_and_Graphs;

import com.darkRealm.Stacks_and_queues.MyQueue;
import com.darkRealm.Stacks_and_queues.MyStack;

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
    buildOrder="";
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
      if( !oneVisited && (trav.name.equals(p.name))) {
        System.out.println(p.name + " - visisted ");
        oneVisited = true;
      } else if (oneVisited && (trav.name.equals(q.name))){
        System.out.println(q.name + " - visisted ");
        System.out.println("Route present between "+p.name+"  & "+q.name);
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
      if(trav.incomingEdges==0){
        trav.status = Node.Status.Processed;
        processed--;
        buildOrder+=" "+trav.name;
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

}