package darkRealm;

public class LowestCommonAncestorOfDeepestLeaves {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  TreeNode res;
  int max;

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    if (root == null)
      return null;

    res = null;
    max = Integer.MIN_VALUE;

    getDepth(root, 0);
    return res;
  }

  private int getDepth(TreeNode root, int lvl) {

    // First calculate the max depth
    // ask for the ma depth from the childs
    // at a node if both the left & right report the max Depth then this node is one of the result.
    // Note, we are also returning the max depth to the par from this node, when travelling upwards
    // if the above becomes true again then that node has max depth from childs & is a lowest/earliest ancestor from bottom
    max = Math.max(max, lvl);

    if (root == null)
      return lvl;

    int left = getDepth(root.left, lvl + 1);
    int right = getDepth(root.right, lvl + 1);

    if (left == right && left == max)
      res = root;

    return Math.max(left, right);
  }
}
