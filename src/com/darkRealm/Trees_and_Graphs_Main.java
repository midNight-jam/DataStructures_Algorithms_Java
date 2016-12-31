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

  public static void testPredecessorAndSuccessor() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.left.parent = tree.root;
    tree.root.right = new TNode(30);
    tree.root.right.parent = tree.root;
    tree.root.left.left = new TNode(5);
    tree.root.left.left.parent = tree.root.left;
    tree.root.left.right = new TNode(15);
    tree.root.left.right.parent = tree.root.left;

    tree.root.left.right.right = new TNode(17);
    tree.root.left.right.right.parent = tree.root.left.right;
//    tree.root.left.left.left = new TNode(3);
//    tree.root.left.left.right = new TNode(7);
    Trees_and_Graphs.printPredecessorAndSucessor(tree, 17);
  }

  public static void testCommonAncestor() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(10);
    tree.root.right = new TNode(30);
    tree.root.right.left = new TNode(25);
    tree.root.right.right = new TNode(40);
    tree.root.left.left = new TNode(5);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);
    Trees_and_Graphs.findCommonAncestor(tree, 3, 17);
  }

  public static void testCheckSubtree() {
    Tree tree = new Tree();
    tree.root = new TNode(20);
    tree.root.left = new TNode(15);
    tree.root.right = new TNode(30);
    tree.root.right.left = new TNode(25);
    tree.root.right.right = new TNode(40);
    tree.root.left.left = new TNode(5);
    tree.root.left.right = new TNode(15);
    tree.root.left.right.left = new TNode(13);
    tree.root.left.right.left.right = new TNode(14);
    tree.root.left.right.left.left = new TNode(11);
    tree.root.left.right.left.left.left = new TNode(9);
    tree.root.left.right.left.left.right = new TNode(12);
    tree.root.left.right.right = new TNode(17);
    tree.root.left.right.right.left = new TNode(16);
    tree.root.left.right.right.right = new TNode(19);
    tree.root.left.left.left = new TNode(3);
    tree.root.left.left.right = new TNode(7);

    Tree t2 = new Tree();
    t2.root = new TNode(15);
    t2.root.left = new TNode(13);
    t2.root.right = new TNode(17);
    t2.root.left.left = new TNode(11);

    Tree t3 = new Tree();
//    t3.root = new TNode(7);

    Trees_and_Graphs.checkSubtree(tree, t2);
  }


  public static void testInsertNode() {
    Tree tree = new Tree(20);
    tree.insert(30);
    tree.insert(10);
    tree.insert(25);
    tree.insert(15);
    tree.insert(5);
    tree.insert(3);
    tree.insert(7);
    tree.insert(25);
    tree.insert(40);
    tree.insert(13);
    tree.insert(17);
    TNode node = tree.getRandomNode();
    System.out.println("res - " + node.data);
  }

  public static void testBuildOrder(){
    String projs = "a,b,c,d,e,f";
    String dependencies = "(a,d), (f,b), (b,d), (f,a), (d,c), (e,f)";
    String res = Trees_and_Graphs.buildOrder(projs,dependencies);
    System.out.println("build order res - "+res);
  }
}