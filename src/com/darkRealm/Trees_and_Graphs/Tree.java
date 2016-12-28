package com.darkRealm.Trees_and_Graphs;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Tree {
  public TNode root;

  public void printInorderTraversal() {
    inOrder(root);
  }

  private void inOrder(TNode node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(" " + node.data);
      inOrder(node.right);
    }
  }
}