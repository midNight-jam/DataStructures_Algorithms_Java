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


  static int preIndex;
  public static TreeNode buildTree(int[] preord, int[] inord) {
    if(preord == null || inord == null || preord.length < 1 || preord.length != inord.length) return null;
    preIndex = 0;
    return helper(preord, 0, preord.length - 1, inord);
  }
  
  private static TreeNode helper(int [] pre, int low, int high, int [] inord){
    if( preIndex >= pre.length || high < low) return null;
    
    TreeNode root = new TreeNode(pre[preIndex++]);
    int rootIndex = 0;
    
    // find the position of root in this subtree
    for(; rootIndex < inord.length; rootIndex++)
      if(inord[rootIndex] == root.val)
        break;
    
    // reduce the tree size for the left Subtree
    root.left = helper(pre, low, rootIndex - 1, inord);
    // reduce the tree size for the right Subtree
    root.right = helper(pre, rootIndex + 1, high, inord);
    
    return root;
  }

  public static void main(String[] args) {
    int[] inorder = new int[]{4, 2, 7, 6, 5, 1, 3, 8, 9};
    int[] postorder = new int[]{1, 2, 4, 5, 6, 7, 3, 8, 9};
    TreeNode root = buildTree(inorder, postorder);
    System.out.println("R : " + root.val);
  }
}
