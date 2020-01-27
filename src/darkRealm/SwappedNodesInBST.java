package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class SwappedNodesInBST {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int v) {
      val = v;
    }
  }

  private static TreeNode res1, res2;

  private static List<Integer> swappedNodes(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private static int[] helper(TreeNode root, List<Integer> res) {
    if (root == null || res.size() == 2)
      return new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE};

    int[] left = helper(root.left, res);
    if (left[2] > root.val) {
      res.add(left[2]);
    }

    int[] right = helper(root.right, res);
    if (root.val > right[0]) {
      res.add(right[0]);
    }

    return new int[]{
        left[2],
        root.val,
        right[0]
    };
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(8);

    root.right = new TreeNode(7);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(9);

    List<Integer> res = swappedNodes(root);
    System.out.println(res);

  }
}
