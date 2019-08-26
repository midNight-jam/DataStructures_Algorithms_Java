package darkRealm;

public class IncreasingOrderSearchTree {

//   897. Increasing Order Search Tree
// Easy

// 332

// 335

// Favorite

// Share
// Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root
// of the tree, and every node has no left child and only 1 right child.

// Example 1:
// Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

//        5
//       / \
//     3    6
//    / \    \
//   2   4    8
//  /        / \ 
// 1        7   9

// Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

//  1
//   \
//    2
//     \
//      3
//       \
//        4
//         \
//          5
//           \
//            6
//             \
//              7
//               \
//                8
//                 \
//                  9  
// Note:

// The number of nodes in the given tree will be between 1 and 100.
// Each node will have a unique integer value from 0 to 1000.
  
  
  static TreeNode nroot;
  static TreeNode trav;

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode increasingBST(TreeNode root) {
    if (root == null) return root;
    TreeNode res = null;
    helper(root);
    return res;
  }

  private static void helper(TreeNode root) {
    if (root == null) return;

    helper(root.left);


    if (nroot == null) {
      nroot = new TreeNode(root.val);
      trav = nroot;
    } else {
      trav.right = new TreeNode(root.val);
      trav = trav.right;
    }

    helper(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    TreeNode res = increasingBST(root);
  }
}
