package darkRealm;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
  
//  #314. Binary Tree Vertical Order Traversal
//  Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//  If two nodes are in the same row and column, the order should be from left to right.
//      Examples:
//  Given binary tree [3,9,20,null,null,15,7],
//         3
//        /\
//      /  \
//     9  20
//        /\
//       /  \
//     15   7
//      return its vertical order traversal as:
//      [
//      [9],
//      [3,15],
//      [20],
//      [7]
//      ]

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<TreeNode> que = new LinkedList<>();
    Queue<Integer> colQue = new LinkedList<>();
    que.add(root);
    colQue.add(0);
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    while (!que.isEmpty()) {
      int size = que.size();
      while (size > 0) {
        TreeNode trav = que.poll();
        int col = colQue.poll();
        if (col < min) min = col;
        if (col > max) max = col;
        if (!map.containsKey(col)) map.put(col, new ArrayList<>());
        map.get(col).add(trav.val);
        if (trav.left != null) {
          que.add(trav.left);
          colQue.add(col - 1);
        }
        if (trav.right != null) {
          que.add(trav.right);
          colQue.add(col + 1);
        }
        size--;
      }
    }

    for (int i = min; i <= max; i++)
      res.add(map.get(i));
    return res;
  }

  public static void main(String[] args) {

  }
}