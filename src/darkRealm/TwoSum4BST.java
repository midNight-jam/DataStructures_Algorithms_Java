package darkRealm;

import java.util.*;

public class TwoSum4BST {

//  Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such
//  that their sum is equal to the given target.
//
//      Example 1:
//  Input:
//       5
//      / \
//     3   6
//    / \   \
//   2   4   7
//
//  Target = 9
//
//  Output: True
//  Example 2:
//  Input:
//       5
//      / \
//     3   6
//    / \   \
//   2   4   7
//
//  Target = 28
//
//  Output: False

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Space : O(n), time : O(n)
  public static boolean findTarget(TreeNode node, int x, Set<Integer> set) {
    if (node == null) return false;
    if (set.contains(x - node.val)) return true;
    set.add(node.val);
    return findTarget(node.left, x, set) || findTarget(node.right, x, set);
  }

  public static boolean findTarget(TreeNode node, int x) {
    if (node == null) return false;
    Set<Integer> set = new HashSet<>();
    return findTarget(node, x, set);
  }

  public static void main(String[] args) {
//    TreeNode root = new TreeNode(5);
//    root.left = new TreeNode(3);
//    root.right = new TreeNode(6);
//    root.left.left = new TreeNode(2);
//    root.left.right = new TreeNode(4);
//    //root.right.left = new TreeNode(2);
//    root.right.right = new TreeNode(7);
//    boolean res = findTarget(root, 9);


//    TreeNode root = new TreeNode(2);
//    root.left = new TreeNode(1);
//    root.right = new TreeNode(3);
////    boolean res = findTarget(root, 1);
//    boolean res = findTarget(root, 4);

//    TreeNode root = new TreeNode(1);
//    boolean res = findTarget(root, 2);

    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(-3);
//    root.left.right = new TreeNode(4);
//    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    boolean res = findTarget(root, -4);

    System.out.println("Res : " + res);
  }
}