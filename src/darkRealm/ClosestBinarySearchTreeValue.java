package darkRealm;

public class ClosestBinarySearchTreeValue {

//  270. Closest Binary Search Tree Value
//  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//      Note:
//  Given target value is a floating point.
//  You are guaranteed to have only one unique value in the BST that is closest to the target.
//  Example:
//
//  Input: root = [4,2,5,1,3], target = 3.714286
//
//       4
//      / \
//     2   5
//    / \
//   1   3
//
//  Output: 4

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int res;
  double minDiff = Double.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
    if (root == null) return res;
    bst(root, target);
    return res;
  }

  private void bst(TreeNode root, double target) {
    if (root == null) return;
    double diff = Math.abs(root.val - target);
    if (diff < minDiff) {
      res = root.val;
      minDiff = diff;
    }
    if (target < root.val)
      bst(root.left, target);
    else
      bst(root.right, target);
  }

  public static void main(String[] args) {

  }
}
