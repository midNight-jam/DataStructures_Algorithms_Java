package darkRealm;

public class BinaryTreeLongestConsecutiveSequence {
//  #298. Binary Tree Longest Consecutive Sequence
//  Given a binary tree, find the length of the longest consecutive sequence path.
//  The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
//  For example,
//      1
//        \
//         3
//        / \
//        2   4
//            \
//            5
//  Longest consecutive sequence path is 3-4-5, so return 3.
//       2
//        \
//        3
//       /
//      2
//     /
//    1
//  Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int maxLen = 0;

  public static int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    dfs(root, 0, root.val);
    return maxLen;
  }

  public static void dfs(TreeNode node, int curr, int target) {
    if (node == null) return;
    if (node.val == target) curr++; // if target matches increase this subsequence count
    else curr = 1; // else reset the subsequence count
    dfs(node.left, curr, node.val + 1);
    dfs(node.right, curr, node.val + 1);
    maxLen = Math.max(curr, maxLen);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    int res = longestConsecutive(root);
    System.out.println("R : " + res);
  }
}