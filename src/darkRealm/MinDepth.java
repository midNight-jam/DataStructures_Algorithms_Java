package darkRealm;

public class MinDepth {

//  111. Minimum Depth of Binary Tree
//  Given a binary tree, find its minimum depth.
//  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

  public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
      val = x;
    }
  }

  public static int MIN_DEPTH = Integer.MAX_VALUE;
  private static void findDepth(TreeNode node, int level) {
    if (node == null) return;
    if (node.left == null && node.right == null)
      MIN_DEPTH = Math.min(MIN_DEPTH, level);
    findDepth(node.left, level + 1);
    findDepth(node.right, level + 1);
  }

  public static int minDepth(TreeNode node) {
    if (node == null) return 0;
    findDepth(node, 0);
    return MIN_DEPTH;
  }

  public static void main(String[] args) {

  }
}
