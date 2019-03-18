package darkRealm;

import java.util.Stack;

public class CousinsInBinaryTree {

//  993. Cousins in Binary Tree
//  In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//  Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//  We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//  Return true if and only if the nodes corresponding to the values x and y are cousins.

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Helper {
    TreeNode root;
    TreeNode par;
    int depth;

    Helper(TreeNode r, TreeNode p, int d) {
      root = r;
      par = p;
      depth = d;
    }
  }

  public static boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) return false;

    TreeNode xPar, yPar;
    int xd, yd;
    xd = yd = -1;
    xPar = yPar = null;


    Stack<Helper> stack = new Stack<>();
    stack.push(new Helper(root, null, 0));
    Helper trav;
    while (stack.size() > 0) {
      trav = stack.pop();
      if (trav.root == null) continue;
      if (trav.root.val == x) {
        xd = trav.depth;
        xPar = trav.par;
      }
      if (trav.root.val == y) {
        yd = trav.depth;
        yPar = trav.par;
      }
      stack.push(new Helper(trav.root.left, trav.root, trav.depth + 1));
      stack.push(new Helper(trav.root.right, trav.root, trav.depth + 1));
    }

    return xd == yd && xd != -1 && xPar != null && yPar != null && xPar != yPar;
  }
}
