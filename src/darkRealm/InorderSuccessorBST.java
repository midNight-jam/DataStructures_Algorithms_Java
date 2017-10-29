package darkRealm;

public class InorderSuccessorBST {

//  #285. Inorder Successor in BST
//  Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//  Note: If the given node has no in-order successor in the tree, return null.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  // MY solution ::: Do inorder traversal and if the prev node was the target then this node is its successor
  static TreeNode succ = null;
  static TreeNode prev = null;

  public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    helper(root, p);
    return succ;
  }

  private static void helper(TreeNode root, TreeNode tar) {
    if (root == null || succ != null) return;
    helper(root.left, tar);
    // if prev is set & this node is greater than prev means we are in right subtree and prev was thr target, then this is the successor
    if (prev != null && root.val > prev.val && prev.val == tar.val) succ = root;
    prev = root;  // set prev as we are going in right subtree
    helper(root.right, tar);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    TreeNode res = inorderSuccessor(root, new TreeNode(2));
    System.out.println(res.val);
  }
}