package darkRealm;

import java.util.*;

public class BinaryTreeLevelOrderII {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

//  Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//  For example:
//  Given binary tree [3,9,20,null,null,15,7],
//        3
//       / \
//      9  20
//        /  \
//       15   7
//      return its bottom-up level order traversal as:
//      [
//      [15,7],
//      [9,20],
//      [3]
//      ]

  public static List<List<Integer>> levelOrderBottomUp(TreeNode node) {
    if (null == node) return new ArrayList<>();
    Queue<TreeNode> que = new LinkedList<>();
    List<List<Integer>> bottomupList = new ArrayList<>();
    que.add(node);
    int size;
    TreeNode trav;
    while (!que.isEmpty()) {
      size = que.size();
      List<Integer> levelList = new ArrayList<>();
      while (size-- != 0) {
        trav = que.poll();
        levelList.add(trav.val);
        if (trav.left != null) que.add(trav.left);
        if (trav.right != null) que.add(trav.right);
      }
      bottomupList.add(0, levelList);
    }
    return bottomupList;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> res = levelOrderBottomUp(root);
    System.out.println(res);
  }
}