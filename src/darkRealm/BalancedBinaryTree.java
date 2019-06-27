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

  static boolean res;

  private static int helper(TreeNode root){
    if(root == null || !res) return 0;
    int l = helper(root.left);
    int r = helper(root.right);
    int diff = Math.abs(l - r);
    res = res & diff < 2;
    return Math.max(l, r) + 1;
  }

  public static boolean isBalanced(TreeNode root) {
    res = true;
    helper(root);
    return res;
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
