package com.darkRealm.Trees_and_Graphs;

/**
 * Created by Jayam on 12/28/2016.
 */
public class Node {
  public String name;
  public Node[] childs;
  public Status status;
  private int childsCount;
  public int incomingEdges;

  public Node(int childs) {
    this.childs = new Node[childs];
    status = Status.NotProcessed;
  }

  public void addChild(Node child) {
    childs[childsCount] = child;
    childsCount++;
    child.incomingEdges++;
  }

  public enum Status {
    NotProcessed,
    UnderProcessing,
    Processed
  }

  public void reset() {
    status = Status.NotProcessed;
  }
}