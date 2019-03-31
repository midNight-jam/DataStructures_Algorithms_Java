package darkRealm;

public class MinimumDistanceBetweenBSTNodes {

  //  783. Minimum Distance Between BST Nodes
//  Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any
//  two different nodes in the tree.
//
//  Example :
//
//  Input: root = [4,2,6,1,3,null,null]
//  Output: 1
//  Explanation:
//  Note that root is a TreeNode object, not an array.
//
//  The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//      4
//      /   \
//      2      6
//      / \
//      1   3
//
//  while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
//  Note:
//
//  The size of the BST will be between 2 and 100.
//  The BST is always valid, each node's value is an integer, and each node's value is different.
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int last = Integer.MAX_VALUE;
  int res = -1;

  public int minDiffInBST(TreeNode root) {
    last = Integer.MAX_VALUE;
    res = Integer.MAX_VALUE;
    helper(root);
    return res;
  }

  private void helper(TreeNode root) {
    if (root == null) return;
    helper(root.left);
    if (last != Integer.MAX_VALUE)
      res = Math.min(Math.abs(last - root.val), res);
    last = root.val;
    helper(root.right);
  }

  public static void main(String[] args) {

  }
}
