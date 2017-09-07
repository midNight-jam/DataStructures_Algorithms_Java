package darkRealm;

public class PathSumIII {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

//  You are given a binary tree in which each node contains an integer value.
//
//  Find the number of paths that sum to a given value.
//
//  The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
//
//  The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//
//  Example:
//
//  root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//       10
//      /  \
//     5   -3
//    / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//  Return 3. The paths that sum to 8 are:
//
//      1.  5 -> 3
//      2.  5 -> 2 -> 1
//      3. -3 -> 11

  static int path = 0;

  public static void pathFind(TreeNode node, int sum) {
    if (node == null) return;
    calculatePathSum(node, sum, 0);
    pathFind(node.left, sum);
    pathFind(node.right, sum);
  }

  public static void calculatePathSum(TreeNode node, int sum, int runninSum) {
    if(null == node) return;
    if(runninSum + node.val == sum) path++;
    calculatePathSum(node.left, sum, runninSum + node.val);
    calculatePathSum(node.right, sum, runninSum + node.val);
  }

  public static int pathSum(TreeNode node, int sum) {
    if (null == node) return path;
    pathFind(node, sum);
    return path;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);
    root.right.right = new TreeNode(11);
    root.left.left = new TreeNode(3);
    root.left.right= new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);

    int path = pathSum(root, 8);
    System.out.println("Path : " + path);
  }
}