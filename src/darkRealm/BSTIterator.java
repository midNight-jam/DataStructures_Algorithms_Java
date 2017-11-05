package darkRealm;

import java.util.Stack;

public class BSTIterator {

//  #173. Binary Search Tree Iterator
//  Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//  Calling next() will return the next smallest number in the BST.
//  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
//  Credits:
//  Special thanks to @ts for adding this problem and creating all test cases.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    init(root);
  }

  private void init(TreeNode trav) {
    while (trav != null) {
      stack.push(trav);
      trav = trav.left;
    }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    if (!hasNext()) return Integer.MIN_VALUE;
    TreeNode trav = stack.pop();
    init(trav.right);
    return trav.val;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(2);
    root.left.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(7);
    root.left.right.left = new TreeNode(6);

    root.right = new TreeNode(17);
    root.right.left = new TreeNode(15);
    root.right.left.right = new TreeNode(16);

    BSTIterator bst = new BSTIterator(root);
    while (bst.hasNext())
      System.out.println(bst.next());
  }
}
