package com.darkRealm.Trees_and_Graphs;

/**
 * Created by Jayam on 1/22/2017.
 */
// RankTreeNode
public class RTNode {
  public int leftChilds;
  public int data;
  public int rightChilds;
  RTNode left;
  RTNode right;

  RTNode(int d) {
    data = d;
    leftChilds = rightChilds = 0;
  }
}
