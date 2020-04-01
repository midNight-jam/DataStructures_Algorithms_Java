package darkRealm;

public class ConstructBinarySearchTreeFromPreorderTraversal {

//  1008. Construct Binary Search Tree from Preorder Traversal
//  Return the root node of a binary search tree that matches the given preorder traversal.
//
//  (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left
//  has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder
//  traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//
//  Example 1:
//
//  Input: [8,5,1,7,10,12]
//  Output: [8,5,10,1,7,null,12]
//
//
//  Note:
//
//      1 <= preorder.length <= 100
//  The values of preorder are distinct.


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  int ri;

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null) return null;
    ri = 0; // root index to start with 0, incrementally use elements from preorder to create nodes
    return create(preorder, Integer.MAX_VALUE);
  }

  // the idea is simple, when we move in left subtree, we want to take only values that are smaller than the root as this is a bst.
  // when we move in the right sub tree we want to take values bigger than root, but smaller than max.
  private TreeNode create(int[] preorder, int bound) {
    if (ri >= preorder.length || preorder[ri] > bound) return null;
    TreeNode root = new TreeNode(preorder[ri++]);
    root.left = create(preorder, root.val);  // set the bound as root val
    root.right = create(preorder, bound); // carry on with the given bound
    return root;
  }
}
