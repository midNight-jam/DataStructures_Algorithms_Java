package darkRealm;

public class LargestBSTSubtree {

//  #333. Largest BST Subtree
//  Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
//  Note:
//  A subtree must include all of its descendants.
//  Here's an example:
//         10
//        / \
//       5  15
//      / \   \
//    1   8   7
//  The Largest BST Subtree in this case is the highlighted one.
//  The return value is the subtree's size, which is 3.
//  Follow up:
//  Can you figure out ways to solve it with O(n) time complexity?

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;
    helper(root);
    return maxBST;
  }

  static int maxBST = Integer.MIN_VALUE;

  private static int [] helper(TreeNode trav) {
    // Meta array denotes [0] - number of nodes in subtree, [1] - leftmost value in subtree , [2] - rightmost value in subtree
    int[] meta = new int[3];
    if (trav == null) return meta;
    int[] leftResult = helper(trav.left);
    int[] rightResult = helper(trav.right);
    if ((leftResult[0] == 0 || leftResult[0] > 0 && leftResult[2] < trav.val)
        && (rightResult[0] == 0 || rightResult[0] > 0 && rightResult[1] >= trav.val)) {
      int size = leftResult[0] + rightResult[0] + 1;
      maxBST = Math.max(maxBST, size);
      meta[0] = size;
      meta[1] = leftResult[0] == 0 ? trav.val : leftResult[1]; // left most value from left subtree
      meta[2] = rightResult[0] == 0 ? trav.val : rightResult[2]; // right most value from left subtree
    } else {
      meta[0] = -1;
    }
    return meta;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(8);
    root.right.right = new TreeNode(7);

//    TreeNode root = new TreeNode(1);
//    root.right = new TreeNode(2);

    int res = largestBSTSubtree(root);
    System.out.println(res);
  }
}
