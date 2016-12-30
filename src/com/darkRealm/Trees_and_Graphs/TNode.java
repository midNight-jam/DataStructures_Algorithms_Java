package com.darkRealm.Trees_and_Graphs;

/**
 * Created by Jayam on 12/27/2016.
 */
public class TNode {
  public int data;
  public TNode left;
  public TNode right;
  public TNode parent;

  public int size;

  public TNode(int data) {
    this.data = data;
    size = 1;
  }

  public void insertInorder(int d) {
    if (d <= data) {
      if (left == null) {
        left = new TNode(d);
      } else {
        left.insertInorder(d);
      }
    } else {
      if (right == null) {
        right = new TNode(d);
      } else {
        right.insertInorder(d);
      }
    }
    size++;
  }

  public TNode getIndexNode(int index) {
    int leftSize = left == null ? 0 : left.size;
    if (index <= leftSize) {
      return left.getIndexNode(index);
    }
    if (index == size) {
      System.out.println("node reached - " + data);
      return this;
    }
    else {
      int skipLeftSubTree = index - (leftSize + 1); // plus one is for counting the node from which we are skipping
      return right.getIndexNode(skipLeftSubTree);
    }
  }

  public boolean isLeaf() {
    return ((left == null) && (right == null));
  }
}