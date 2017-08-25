package darkRealm;

public class MergeTwoBinaryTrees {

//  Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//
//  You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
//
//      Example 1:
//  Input:
//  Tree 1                     Tree 2
//      1                         2
//      / \                       / \
//      3   2                     1   3
//      /                           \   \
//      5                             4   7
//  Output:
//  Merged tree:
//      3
//      / \
//      4   5
//      / \   \
//      5   4   7


  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode getLeftChild(TreeNode node) {
    return node != null ? node.left : null;
  }

  public static TreeNode getRightChild(TreeNode node) {
    return node != null ? node.right : null;
  }

  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (null == t1 && null == t2) return null;
    int val = 0;
    if (t1 != null)
      val += t1.val;
    if (t2 != null)
      val += t2.val;
    TreeNode trav = new TreeNode(val);
    trav.left = mergeTrees(getLeftChild(t1), getLeftChild(t2));
    trav.right = mergeTrees(getRightChild(t1), getRightChild(t2));
    return trav;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(3);
    t1.right = new TreeNode(2);
    t1.left.left = new TreeNode(5);

    TreeNode t2 = new TreeNode(2);
    t2.left = new TreeNode(1);
    t2.right = new TreeNode(3);
    t2.left.right = new TreeNode(4);
    t2.right.right = new TreeNode(7);

    TreeNode mergedTree = mergeTrees(t1, t2);
    System.out.println("MergedTree : " + mergedTree.val);
  }
}