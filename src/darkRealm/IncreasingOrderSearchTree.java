package darkRealm;

public class IncreasingOrderSearchTree {

  static TreeNode nroot;
  static TreeNode trav;

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode increasingBST(TreeNode root) {
    if (root == null) return root;
    TreeNode res = null;
    helper(root);
    return res;
  }

  private static void helper(TreeNode root) {
    if (root == null) return;

    helper(root.left);


    if (nroot == null) {
      nroot = new TreeNode(root.val);
      trav = nroot;
    } else {
      trav.right = new TreeNode(root.val);
      trav = trav.right;
    }

    helper(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    TreeNode res = increasingBST(root);
  }
}
