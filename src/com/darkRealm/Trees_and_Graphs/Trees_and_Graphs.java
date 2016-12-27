package com.darkRealm.Trees_and_Graphs;
/**
 * Created by Jayam on 12/28/2016.
 */
public class Trees_and_Graphs {


  private static Graph getSampleGraph() {
    int vertices = 6;
    Graph graph = new Graph(vertices);
    Node vertex0 = new Node(vertices);
    vertex0.name = "0";
    graph.start = vertex0;
    Node vertex1 = new Node(vertices);
    vertex1.name = "1";
    graph.start.childs[1] = vertex1;

    Node vertex5 = new Node(vertices);
    vertex5.name = "5";
    graph.start.childs[5] = vertex5;

    Node vertex4 = new Node(vertices);
    vertex4.name = "4";
    graph.start.childs[4] = vertex4;

    vertex1.childs[4] = vertex4;

    Node vertex2 = new Node(vertices);
    vertex2.name = "2";
    vertex2.childs[1] = vertex1;

    Node vertex3 = new Node(vertices);
    vertex3.name = "3";
    vertex3.childs[2] = vertex2;
    vertex3.childs[4] = vertex4;
    vertex1.childs[3] = vertex3;

    graph.allVertices[0] = vertex0;
    graph.allVertices[1] = vertex1;
    graph.allVertices[2] = vertex2;
    graph.allVertices[3] = vertex3;
    graph.allVertices[4] = vertex4;
    graph.allVertices[5] = vertex5;
    return graph;
  }

  public static void doBFSAndDFS() {
    Graph graph = getSampleGraph();
    graph.BreadthFirstTraversal();
    graph.DepthFirstTraversal();
  }

  public static void isRoutePresentBetweenNodes(){
    Graph graph = getSampleGraph();
    Node p = graph.allVertices[0];
    Node q = graph.allVertices[0];
    System.out.println("Route Present - "+graph.isRouteBetween(p,q));
  }

}