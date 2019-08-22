package darkRealm;

import java.util.*;

public class DeleteNodesAndReturnForest {

//  1110. Delete Nodes And Return Forest
//  Given the root of a binary tree, each node in the tree has a distinct value.
//  After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//  Return the roots of the trees in the remaining forest.  You may return the result in any order.
//
//      Example 1:
//
//  Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//  Output: [[1,2,null,4],[6],[7]]
//
//  Constraints:
//
//  The number of nodes in the given tree is at most 1000.
//  Each node has a distinct value between 1 and 1000.
//  to_delete.length <= 1000
//  to_delete contains distinct values between 1 and 1000.

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static List<TreeNode> res;
  static List<TreeNode> roots;

  private static List<TreeNode> delNodes(TreeNode root, int[] td) {
    res = new ArrayList<>();
    roots = new ArrayList<>();
    if (root == null) return res;
    Set<Integer> set = new HashSet<Integer>();

    for (int d : td)
      set.add(d);

    findNewRoots(null, root, set, true);
    if (!set.contains(root.val))
      roots.add(root);

    return roots;
  }

  private static void findNewRoots(TreeNode par, TreeNode root, Set<Integer> set, boolean lr) {
    if (root == null) return;
    if (set.contains(root.val)) {
      if (root.left != null && !set.contains(root.left.val))
        roots.add(root.left);
      if (root.right != null && !set.contains(root.right.val))
        roots.add(root.right);

      if (lr && par != null)
        par.left = null;
      else if (!lr && par != null)
        par.right = null;
    }

    findNewRoots(root, root.left, set, true);
    findNewRoots(root, root.right, set, false);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(3);
    int[] d = new int[]{2, 3};

    List<TreeNode> res = delNodes(root, d);
  }
}
