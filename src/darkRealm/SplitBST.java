package darkRealm;

import java.util.Arrays;

public class SplitBST {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }


  public static TreeNode[] splitBST(TreeNode root, int V) {
    TreeNode[] res = new TreeNode[2];
    if (root == null) return res;
    // the idea is the node which is smallerorEqual to the target where we make the split, this node should notonly include all the nodes in its left subtree
    // becoz its already smaller, but it shoould also inlcude any smaller nodes from the right subtree that are smaller than the target,
    // thus the problem can be broken down in to subproblem
    // if the node is <= target the small part of res will include this node + smaleer node from the right subtree
    // else if  the node is > target the smaller part of res will include this smaleer node from the left subtree
    if (root.val <= V) {
      TreeNode[] sub = splitBST(root.right, V);
      root.right = sub[0];
      res[0] = root;
      res[1] = sub[1];
    } else {
      TreeNode[] sub = splitBST(root.left, V);
      root.left = sub[1];
      res[0] = sub[0];
      res[1] = root;
    }
    return res;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);

    int v = 6;
    TreeNode[] res = splitBST(root, v);
    System.out.println(Arrays.toString(res));
  }
}
