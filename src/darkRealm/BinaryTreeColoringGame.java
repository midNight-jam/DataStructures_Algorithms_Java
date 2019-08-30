package darkRealm;

public class BinaryTreeColoringGame {

//  1145. Binary Tree Coloring Game
//  Two players play a turn based game on a binary tree.  We are given the root of this binary tree, and the number of
//  nodes n in the tree.  n is odd, and each node has a distinct value from 1 to n.
//
//  Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with
//  1 <= y <= n and y != x.  The first player colors the node with value x red, and the second player colors the node
//  with value y blue.
//
//  Then, the players take turns starting with the first player.  In each turn, that player chooses a node of their
//  color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left
//  child, right child, or parent of the chosen node.)
//
//  If (and only if) a player cannot choose such a node in this way, they must pass their turn.  If both players pass
//  their turn, the game ends, and the winner is the player that colored more nodes.
//
//  You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.
//  If it is not possible, return false.
//
//
//  Example 1:
//
//
//  Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//  Output: true
//  Explanation: The second player can choose the node with value 2.
//
//
//  Constraints:
//
//  root is the root of a binary tree with n nodes and distinct node values from 1 to n.
//  n is odd.
//  1 <= x <= n <= 100

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /*
   * Dont fall in the trap pf taking turns & coloring the nodes & finally at the end conculding win or loss, it gets
   * complicated very easily.
   * Intead,  we hv 2 helps already in the question
   * 1: N is odd
   * 2: x, the node that opponent is choosing is given
   * If we draw the tree on the paper as per the constraints of the question we can easily see that to make opponnent
   * loose we hv to limit the nodes he can color, to restrict him to the fewest nodes the can color from node x there are
   * only 3 ways, left child, right child or the parent. The crux is we try to find the size which we will get to color
   * from x (i.e if we color then he cant color & is restricted).
   * Thus, if at x, we try to get the size of left & right sub tress & as the total is given we can also find what it size
   * of rest if the tree which is the parent size. Now we hv to pick just the largest one & opponent cannot use any node from
   * it & we win. Else the opponent always wins!
   * */

  public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    if (root == null) return false;
    if (root.val == x) {
      int left = size(root.left);
      int right = size(root.right);
      int par = n - (left + right + 1);

      boolean win = par > (left + right) || left > (par + right) || right > (par + left);
      if (win) return true;
    }

    return btreeGameWinningMove(root.left, n, x) || btreeGameWinningMove(root.right, n, x);
  }

  public static int size(TreeNode root) {
    if (root == null) return 0;
    return size(root.left) + size(root.right) + 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.left.left = new TreeNode(8);
    root.left.left.right = new TreeNode(9);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(11);

    boolean res = btreeGameWinningMove(root, 11, 3);
    System.out.println(res);
  }
}
