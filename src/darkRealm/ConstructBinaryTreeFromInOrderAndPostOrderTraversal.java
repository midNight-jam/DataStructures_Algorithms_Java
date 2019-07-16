package darkRealm;

public class ConstructBinaryTreeFromInOrderAndPostOrderTraversal {

//  #106. Construct Binary Tree from Inorder and Postorder Traversal
//  Given inorder and postorder traversal of a tree, construct the binary tree.
//  Note:
//  You may assume that duplicates do not exist in the tree.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int postIndex = Integer.MIN_VALUE;

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    postIndex = postorder.length - 1;
    return helper(inorder, 0, inorder.length - 1, postorder);
  }

  private static TreeNode helper(int[] inorder, int low, int high, int[] postorder) {
    if (postIndex < 0 || low > high) return null;
    TreeNode root = new TreeNode(postorder[postIndex]);
    postIndex--;
    int inIdx = -1;
    for (int i = 0; i < inorder.length; i++)
      if (inorder[i] == root.val) {
        inIdx = i;
        break;
      }
    // right first, because we are doing in reverse order of left->right->root
    root.right = helper(inorder, inIdx + 1, high, postorder);
    root.left = helper(inorder, low, inIdx - 1, postorder);
    return root;
  }

  public static void main(String[] args) {
    int[] inorder = new int[]{2, 3, 1, 5, 4};
    int[] postorder = new int[]{3, 2, 5, 4, 1};
    TreeNode root = buildTree(inorder, postorder);
    System.out.println("R : " + root.val);
  }
}
