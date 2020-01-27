package darkRealm;

public class DiameterBinaryTree {

//  543. Diameter of Binary Tree
//  Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
//  the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//  Example:
//  Given a binary tree
//               1
//              / \
//             2   3
//            / \
//           4   5
//  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int max = 0;

  public static int inorder(TreeNode node) {
    if (null == node) return 0;
    int l = inorder(node.left);
    int r = inorder(node.right);
    max = Math.max(max, l + r); // record the sum of maxDepths from both subTree
    return Math.max(l, r) + 1; // return the maxDepth
  }

  public static int diameter(TreeNode node) {
    inorder(node);
    return max;
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(2);
//    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(-7);
    root.right = new TreeNode(-3);
    root.right.left = new TreeNode(-9);
    root.left.right = new TreeNode(-3);
    root.left.right.left = new TreeNode(-4);
    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(-7);
    root.right.left.left.left = new TreeNode(6);
    root.right.left.right.left = new TreeNode(-6);
    root.right.left.right.right = new TreeNode(-6);
    root.right.left.left.left.left = new TreeNode(0);
    root.right.left.left.left.right = new TreeNode(6);
    root.right.left.right.left.left = new TreeNode(-5);
    root.right.left.right.right.left = new TreeNode(9);
    root.right.left.left.left.left.right = new TreeNode(-1);
    root.right.left.left.left.right.left = new TreeNode(-4);
    root.right.left.right.right.left.left = new TreeNode(-2);

    int res = diameter(root);
    System.out.println("Dmt : " + res);
  }
}
