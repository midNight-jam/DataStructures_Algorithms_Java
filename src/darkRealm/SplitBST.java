package darkRealm;

import java.util.Arrays;

public class SplitBST {
  
//   776. Split BST
// Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one
// subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater 
// than the target value.  It's not necessarily the case that the tree contains a node with value V.

// Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original
// tree, if they are both in the same subtree after the split, then node C should still have the parent P.

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
