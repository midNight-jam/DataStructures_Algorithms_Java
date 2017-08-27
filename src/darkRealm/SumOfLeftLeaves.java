package darkRealm;


public class SumOfLeftLeaves {

//  Find the sum of all left leaves in a given binary tree.
//
//  Example:
//
//       3
//      / \
//     9  20
//       /   \
//     15     7
//
//  There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int leftLeavesSum = 0;

  public static void findAndSumLeftLeaves(TreeNode node, TreeNode par) {
    if (node == null) return;
    if (par != null && par.left == node && node.left == null && node.right == null)
      leftLeavesSum += node.val;
    findAndSumLeftLeaves(node.left, node);
    findAndSumLeftLeaves(node.right, node);
  }

  public static int sumOfLeftLeaves(TreeNode node) {
    findAndSumLeftLeaves(node, null);
    return leftLeavesSum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    int res = sumOfLeftLeaves(root);
    System.out.println("Res : " + res);
  }
}