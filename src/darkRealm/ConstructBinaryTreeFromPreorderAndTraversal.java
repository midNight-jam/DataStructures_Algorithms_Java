package darkRealm;

public class ConstructBinaryTreeFromPreorderAndTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  
// 889. Construct Binary Tree from Preorder and Postorder Traversal
// Return any binary tree that matches the given preorder and postorder traversals.
// Values in the traversals pre and post are distinct positive integers.
// Example 1:
// Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
// NOte
// 1 <= pre.length == post.length <= 30
// pre[] and post[] are both permutations of 1, 2, ..., pre.length.
// It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
  
  
  static int preIndex;

  /*
  (can be refined, was first attempt)
  Intuition : pick root from preorder, select subtrees using post order.
  Preorder consumption is tracked using incrementing pointer
  Postorder cosumption is tracked by erasing the valuse from postOrder array
  */
  public static TreeNode constructFromPrePost(int[] pre, int[] post) {
    if (pre == null || post == null || pre.length < 1 || pre.length != post.length) return null;
    preIndex = 0;
    TreeNode res = helper(pre, post, 0, post.length - 1);
    return res;
  }

  private static TreeNode helper(int [] pre, int [] post, int start, int end){
    if(start > end || preIndex >= pre.length) return null;
    TreeNode root = new TreeNode(pre[preIndex++]);
    int rootIndex = end;
    for(; rootIndex >= start; rootIndex--)
      if(post[rootIndex] == root.val) break;
    
    int treeEnd = rootIndex - 1; // subtree ends before root in postorder
    
    int treeStart = start;
    for(; treeStart <= treeEnd; treeStart++)
      if(post[treeStart] != Integer.MAX_VALUE)
        break;
    
    root.left = helper(pre, post, treeStart, treeEnd);
    
    treeStart = start;
    for(; treeStart <= treeEnd; treeStart++)
      if(post[treeStart] != Integer.MAX_VALUE)  // first available value from the postorder will be the start of subtree
        break;
    
    root.right = helper(pre, post, treeStart, treeEnd);
    
    post[rootIndex] = Integer.MAX_VALUE; // make tree end point to root again
    return root;
  }


  public static void main(String[] args) {
    int[] post = new int[]{5, 2, 4, 7, 3, 1};
    int[] pre = new int[]{1, 2, 5, 3, 4, 7};
    TreeNode res = constructFromPrePost(pre, post);
    System.out.println(res);

  }
}
