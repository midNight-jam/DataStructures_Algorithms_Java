package com.darkRealm;

import com.darkRealm.Trees_and_Graphs.TNode;
import com.darkRealm.Trees_and_Graphs.Tree;
import com.darkRealm.Trees_and_Graphs.Trees_and_Graphs;

/**
 * Created by Jayam on 12/27/2016.
 */
public class Trees_and_Graphs_Main {

  public static void testBFSAndDFS() {
    Trees_and_Graphs.doBFSAndDFS();
  }

  public static void testIsRoutePresentBetweenNodes() {
    Trees_and_Graphs.isRoutePresentBetweenNodes();
  }

  public static void testMinimalHeightTree() {
    int[] arr = new int[]{2, 5, 7, 10, 19, 20, 25};
    Trees_and_Graphs.createMinimalHeightTree(arr);
  }

  public static void testListOfDepths() {
    Trees_and_Graphs.listOfDepths();
  }

  public static void testIsBalanced() {
    Tree tree = Trees_and_Graphs.getSampleTree();
    Trees_and_Graphs.isBalanced(tree);
  }

  public static void testIsBST() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.right = new TNode(30);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.left = new TNode(5);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);
    Trees_and_Graphs.isBST(tree);
  }
}
