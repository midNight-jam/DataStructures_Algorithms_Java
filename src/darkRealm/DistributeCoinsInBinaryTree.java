package darkRealm;

public class DistributeCoinsInBinaryTree {

//  979. Distribute Coins in Binary Tree
//  Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
//
//  In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from
//  parent to child, or from child to parent.)
//
//  Return the number of moves required to make every node have exactly one coin.
//
//  Example 1:
//  Input: [3,0,0]
//  Output: 2
//  Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
//
//      Example 2:
//  Input: [0,3,0]
//  Output: 3
//  Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one
//  coin from the root of the tree to the right child.
//
//  Example 3:
//  Input: [1,0,2]
//  Output: 2
//
//  Example 4:
//  Input: [1,0,0,null,3]
//  Output: 4
//
//  Note:
//      1<= N <= 100
//      0 <= node.val <= N

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int moves;

  public int distributeCoins(TreeNode root) {
    moves = 0;
    helper(root);
    return moves;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;
    // do post order the childs will return the value to the parent
    // -ve val means more coins are required
    // +ve val means extra coins are there & can be transfered
    int left = helper(root.left);
    int right = helper(root.right);
    moves += Math.abs(left);
    moves += Math.abs(right);
    int send = (root.val - 1) + (left + right);
    return send;// whatever is left +ve or -ve will require equal no of moves, that why this works
  }

  public static void main(String[] args) {

  }
}
