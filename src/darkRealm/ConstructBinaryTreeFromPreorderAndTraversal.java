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

  private static TreeNode helper(int[] pre, int[] post, int low, int high) {
    if (preIndex >= pre.length || high < low) return null;

    int rootVal = pre[preIndex++];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = post.length - 1;

    for (; rootIndex > -1; rootIndex--)
      if (post[rootIndex] == rootVal)
        break;

    int avail = 0;
    for (; avail < rootIndex; avail++)
      if (post[avail] != Integer.MAX_VALUE)
        break;

    root.left = helper(pre, post, avail, rootIndex - 1);

    avail = 0;
    for (; avail < rootIndex; avail++)
      if (post[avail] != Integer.MAX_VALUE)
        break;


    root.right = helper(pre, post, avail, rootIndex - 1);
    post[rootIndex] = Integer.MAX_VALUE; // erase the value from post order
    return root;
  }


  public static void main(String[] args) {
    int[] post = new int[]{5, 2, 4, 7, 3, 1};
    int[] pre = new int[]{1, 2, 5, 3, 4, 7};
    TreeNode res = constructFromPrePost(pre, post);
    System.out.println(res);

  }
}
