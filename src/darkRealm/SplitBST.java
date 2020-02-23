package darkRealm;

import java.util.Arrays;

public class SplitBST {

//   776. Split BST
// Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees
// where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes
// that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

// Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in
// the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

// You should output the root TreeNode of both subtrees after splitting, in any order.

// Example 1:

// Input: root = [4,2,6,1,3,5,7], V = 2
// Output: [[2,1],[4,3,6,null,null,5,7]]
// Explanation:
// Note that root, output[0], and output[1] are TreeNode objects, not arrays.

// The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

//           4
//         /   \
//       2      6
//      / \    / \
//     1   3  5   7

// while the diagrams for the outputs are:

//           4
//         /   \
//       3      6      and    2
//             / \           /
//            5   7         1
// Note:

// The size of the BST will not exceed 50.
// The BST is always valid and each node's value is different.

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


  public static TreeNode[] splitBST(TreeNode root, int tar) {
    TreeNode[] res = new TreeNode[2];
    if (root == null)
      return res;

    // First of all, we can see that the given root is always there in the answer (either in the bigger subtree or in
    // the smaller subtree). After that, if root->val > V, there is a chance that there is some subtree within the
    // subtree root->left which maybe greater than V and that subtree needs to be attached to root->left. Now, we see
    // that this problem of finding "subtree in root->left which is greater than V" is the same as the current problem
    // of splitting root.

    // we always return value in this format [small, big] small is at 0, big is at 1.

    // if the tar is in left subTree, get the result from left subTree
    if (root.val > tar) {
      TreeNode[] subTree = splitBST(root.left, tar);
      // remember the format [small, big]
      res[0] = subTree[0]; // small from left is small for res also
      res[1] = root; // big is root itself, we are standing at it
      root.left = subTree[1]; // make the big of leftSubtree the new left of this node;
    }
    // else the tar is in right subTree, get the result from right subTree
    else {
      TreeNode[] subTree = splitBST(root.right, tar);
      // remember the format [small, big]
      res[0] = root; // small is root itself, we are standing at it
      res[1] = subTree[1]; // big from right is big for res also
      root.right = subTree[0]; // make the small of rightSubtree the new right of this node;
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
