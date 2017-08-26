package darkRealm;

public class MinimumAbsoluteDifferenceBST {
  //  Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
//  Example:
//
//  Input:
//
//      1
//      \
//      3
//      /
//      2
//
//  Output:
//      1
//
//  Explanation:
//  The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int minAbsDiff = Integer.MAX_VALUE;
  static TreeNode prev;

  public static int getMinimumDifference(TreeNode node) {
    inorder(node);
    return minAbsDiff;
  }

  public static void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    if (prev != null) minAbsDiff = Math.min(node.val - prev.val, minAbsDiff);
    prev = node;
    inorder(node.right);
  }

  public static int getMinimumDifferenceOLD(TreeNode node) {
    TreeNode trav;
    if (node == null) return minAbsDiff;
    int leftVal, diff, rightVal;
    if (node.left != null) {
      leftVal = node.left.val;
      diff = Math.abs(leftVal - node.val);
      minAbsDiff = Math.min(diff, minAbsDiff);
      trav = node.left;
      while (trav.right != null)  // drill downto find the rightmost cihld in the left subtree
        trav = trav.right;
      int nearestLeftVal = trav.val;
      diff = Math.abs(nearestLeftVal - node.val);
      minAbsDiff = Math.min(minAbsDiff, diff);
    }
    if (node.right != null) {
      rightVal = node.right.val;
      diff = Math.abs(rightVal - node.val);
      minAbsDiff = Math.min(diff, minAbsDiff);
      trav = node.right;
      while (trav.left != null)// drill downto find the leftmost cihld in the right subtree
        trav = trav.left;
      int nearestRightVal = trav.val;
      diff = Math.abs(nearestRightVal - node.val);
      minAbsDiff = Math.min(minAbsDiff, diff);
    }
    getMinimumDifference(node.left);
    getMinimumDifference(node.right);
    return minAbsDiff;
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.right = new TreeNode(3);
//    root.right.left = new TreeNode(2);

    TreeNode root = new TreeNode(600);
    root.left = new TreeNode(424);
    root.left.right = new TreeNode(499);
    root.right = new TreeNode(612);
    root.right.right = new TreeNode(689);

    int res = getMinimumDifference(root);
    System.out.println("Res : " + res);
  }
}