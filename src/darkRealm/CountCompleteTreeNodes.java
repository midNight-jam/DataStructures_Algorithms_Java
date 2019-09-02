package darkRealm;

public class CountCompleteTreeNodes {

//  222. Count Complete Tree Nodes
//  Given a complete binary tree, count the number of nodes.
//
//      Note:
//
//  Definition of a complete binary tree from Wikipedia:
//  In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
//  in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//  Example:
//
//  Input:
//         1
//       /  \
//      2     3
//     / \   /
//    4  5  6
//
//  Output: 6


  /* Time Complexity O(H^2) ::: height sqaure
   * Idea is to try to find such subtrees that are complete binary trees, & have their nodes count with 2^h - 1.
   * For the subtrees which are not balanced on extreme left + extreme right, call this problem recursively by
   * accounting for the count of self node, which reduces to 1 + coutnNodes(left) + countNodes(right)
   * */

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    int lh = leftHeight(root);
    int rh = rightHeight(root);

    // its  a complete binary tree on both sides
    if (lh == rh) {
      int totalNodes = (1 << lh) - 1; // 2 ^ h - 1
      return totalNodes;
    }

    int selfCount = 1;
    int totalNodes = selfCount + countNodes(root.left) + countNodes(root.right);
    return totalNodes;
  }


  private static int rightHeight(TreeNode root) {
    int h = 0;
    while (root != null) {
      root = root.right;
      h++;
    }
    return h;
  }

  private static int leftHeight(TreeNode root) {
    int h = 0;
    while (root != null) {
      root = root.left;
      h++;
    }
    return h;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    int res = countNodes(root);
    System.out.println(res);
    System.out.println(res == 6 ? "Pass" : "Fail");
  }
}
