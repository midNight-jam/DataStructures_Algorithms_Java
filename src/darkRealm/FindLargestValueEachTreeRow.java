package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueEachTreeRow {


  /*
    #515. Find Largest Value in Each Tree Row
    You need to find the largest value in each row of a binary tree.
    Example:
    Input:
          1
         / \
        3   2
       / \   \
      5   3   9
    Output: [1, 3, 9]
    */
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<Integer> largestValues(TreeNode node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) return list;
    levelwise(node, 0, list);
    return list;
  }

  private static void levelwise(TreeNode node, int level, List<Integer> list) {
    if (node == null) return;
    if (list.size() < level + 1)
      list.add(Integer.MIN_VALUE);

    levelwise(node.left, level + 1, list);
    list.set(level, Math.max(node.val, list.get(level)));
    levelwise(node.right, level + 1, list);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(5);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(7);
    root.left.right.left = new TreeNode(1);
    root.left.right.right = new TreeNode(12);
    root.left.right.right.left = new TreeNode(2);
    root.right.right = new TreeNode(11);
    root.right.right.left = new TreeNode(3);

    List<Integer> list = largestValues(root);
    System.out.println(" Largest : " + list);
  }
}
