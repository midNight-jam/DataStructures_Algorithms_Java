package darkRealm;

public class ConstructBinaryTreeFromInorderAndPreOrderTraversal {

//  #105. Construct Binary Tree from Preorder and Inorder Traversal
//  Given preorder and inorder traversal of a tree, construct the binary tree.
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


  public static TreeNode buildTree(int[] inorder, int[] preorder) {
    return helper(inorder, 0, inorder.length - 1, preorder, 0);
  }

  private static TreeNode helper(int[] inorder, int low, int high, int[] preOrder, int preIdx) {

    // root will be the first element in the preorder traversal
    // the left subtree will be all the elements that are to the left of the root in the inorder traversal
    // the right subtree will be all the elements that are to the right of the root in the inorder traversal
    if (preIdx >= preOrder.length || low > high) return null;// either we have completed or invalid
    TreeNode root = new TreeNode(preOrder[preIdx]);
    int inIdx = -1; // Inorder position of the root.
    for (int i = 0; i < inorder.length; i++)  // finding the root position in the inorder traversal
      if (inorder[i] == root.val) {
        inIdx = i;
        break;
      }
    int rootOfLeftSubTree = preIdx + 1; //  leftSubTree will be the next element in preOrder traversal
    root.left = helper(inorder, low, inIdx - 1, preOrder, rootOfLeftSubTree);
    int rootOfRightSubTree = preIdx + inIdx - low + 1;  // rightSubTree will be after skipping all the element in the left subtree
    root.right = helper(inorder, inIdx + 1, high, preOrder, rootOfRightSubTree);
    return root;
  }

  public static void main(String[] args) {
    int[] inorder = new int[]{4, 2, 7, 6, 5, 1, 3, 8, 9};
    int[] postorder = new int[]{1, 2, 4, 5, 6, 7, 3, 8, 9};
    TreeNode root = buildTree(inorder, postorder);
    System.out.println("R : " + root.val);
  }
}