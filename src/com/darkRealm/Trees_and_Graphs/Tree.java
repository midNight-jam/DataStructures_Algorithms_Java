package com.darkRealm.Trees_and_Graphs;

import java.util.Random;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Tree {
  public TNode root;

  public Tree() {
  }

  public Tree(int data) {
    root = new TNode(data);
  }

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

  public void insert(int d) {
    if (root == null) {
      root = new TNode(d);
    } else {
      root.insertInorder(d);
    }
  }

  public TNode getRandomNode(){
    Random random =new Random();
//    int index = random.nextInt(root.size);
    int index = 2;
    return root.getIndexNode(index);
  }

}