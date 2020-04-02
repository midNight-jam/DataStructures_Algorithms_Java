package darkRealm;

public class MaximumDifferenceBetweenNodeAndAncestor {

//  1026. Maximum Difference Between Node and Ancestor
//  Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B
//  where V = |A.val - B.val| and A is an ancestor of B.
//
//      (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
//
//
//
//  Example 1:
//
//
//
//  Input: [8,3,10,1,6,null,14,null,null,4,7,13]
//  Output: 7
//  Explanation:
//  We have various ancestor-node differences, some of which are given below :
//      |8 - 3| = 5
//      |3 - 7| = 4
//      |8 - 1| = 7
//      |10 - 13| = 3
//  Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
//
//
//  Note:
//
//  The number of nodes in the tree is between 2 and 5000.
//  Each node will have value between 0 and 100000.


  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  int res;

  public int maxAncestorDiff(TreeNode root) {
    res = Integer.MIN_VALUE;
    helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    return res;
  }

  private void helper(TreeNode root, int min, int max) {
    if (root == null) return;

    int d1 = max != Integer.MIN_VALUE ? Math.abs(max - root.val) : Integer.MIN_VALUE;
    int d2 = min != Integer.MAX_VALUE ? Math.abs(min - root.val) : Integer.MIN_VALUE;

    int diff = Math.max(d1, d2);
    res = Math.max(diff, res);

    min = Math.min(min, root.val);
    max = Math.max(max, root.val);

    helper(root.left, min, max);
    helper(root.right, min, max);
  }

  public static void main(String[] args) {

  }
}
