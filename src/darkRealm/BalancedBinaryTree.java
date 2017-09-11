package darkRealm;

public class BalancedBinaryTree {

//  Given a binary tree, determine if it is height-balanced.
//  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
//  of every node never differ by more than 1.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static boolean notBalanced = false;

  public static int getHeightBalance(TreeNode node) {
    if (null == node || notBalanced) return 0;
    int left = getHeightBalance(node.left);
    if (notBalanced) return left;
    int right = getHeightBalance(node.right);
    if (notBalanced) return right;
    int diff = Math.abs(left - right);
    notBalanced = diff > 1;
    if (notBalanced) return diff;
    return Math.max(left, right) + 1;
  }

  public static boolean isBalanced(TreeNode node) {
    getHeightBalance(node);
    return !notBalanced;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(0);
    boolean res = isBalanced(root);
    System.out.println("bal : " + res);
  }
}
