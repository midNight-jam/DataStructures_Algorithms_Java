package darkRealm;

public class InvertBinaryTree {

//  Invert a binary tree.
//         4
//       /   \
//      2     7
//    / \   / \
//   1   3 6   9
//  to
//            4
//         /   \
//       7     2
//      / \   / \
//    9    6  3  1

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    invertTree(root.left);
    invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    root = invertTree(root);
  }
}
