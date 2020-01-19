package darkRealm;

public class BinaryTreeTilt {

//  563. Binary Tree Tilt
//  Given a binary tree, return the tilt of the whole tree.
//  The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
//  The tilt of the whole tree is defined as the sum of all nodes' tilt.
//
//  Example:
//  Input:
//        1
//      /   \
//     2     3
//  Output: 1
//  Explanation:
//  Tilt of node 2 : 0
//  Tilt of node 3 : 0
//  Tilt of node 1 : |2-3| = 1
//  Tilt of binary tree : 0 + 0 + 1 = 1
//  Note:
//  The sum of node values in any subtree won't exceed the range of 32-bit integer.
//  All the tilt values won't exceed the range of 32-bit integer.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int treeTilt = 0;

  static int res;
  public static  int findTiltZZZ(TreeNode root) {
    res = 0;
    helper(root);
    return res;
  }

  private static int helper(TreeNode root){
    if(root == null) return 0;
    int l = helper(root.left);
    int r = helper(root.right);
    res += Math.abs(l-r);
    return l + r + root.val;
  }


  public static int treeTilt(TreeNode node) {
    if (null == node) return 0;
    int leftVal = treeTilt(node.left);
    int rightVal = treeTilt(node.right);
    int nodeTilt = Math.abs(leftVal - rightVal);
    treeTilt += nodeTilt;
    node.val += leftVal + rightVal;
    return node.val;
  }

  public static int findTiltOLD(TreeNode root) {
    treeTilt(root);
    return treeTilt;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    int res = findTiltZZZ(root);
    System.out.println("Res : " + res);
  }
}
