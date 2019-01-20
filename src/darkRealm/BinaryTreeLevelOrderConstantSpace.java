package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderConstantSpace {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next; // have a 3rd pointer in each tree node which will point to the next node on the same level

    TreeNode(int x) {
      val = x;
    }

    public static List<List<Integer>> levelOrderConstantSpace(TreeNode root){
      connectLevel(root);
      // as all the levels are connected, the left most nodes are the head of each level, just find these heads + traverse
      // and add to the result.
      List<List<Integer>> res = new ArrayList<>();
      findAndFill(root, res, 1);
      return res;
    }

    private static void connectLevel(TreeNode root) {
      // if its also a leaf return, as we will not be able to modify pointers of below level
      if (root == null || root.left == null && root.right == null) return;
      TreeNode current, left, next;
      current = root;

      while (current != null) {
        left = current.left;
        next = current.next;
        // make the left child point to the right child
        if (left != null)
          left.next = current.right;

        // make the right child point to the next left
        if (next != null)
          current.right.next = next.left;

        // move ahead on this level
        current = current.next;
      }
      connectLevel(root.left);
      connectLevel(root.right);
    }

    private static void findAndFill(TreeNode root, List<List<Integer>> res, int levelNo){
      if(root == null)
        return;
      // only capture this level if we haven't yet
      if(levelNo > res.size()) {
        TreeNode trav = root;
        List<Integer> level = new ArrayList<>();
        while (trav != null) {
          level.add(trav.val);
          trav = trav.next;
        }
        res.add(level);
      }
      findAndFill(root.left, res, levelNo + 1);
      findAndFill(root.right, res, levelNo + 1);
    }

    public static void main(String[] args) {
//      TreeNode root = new TreeNode(3);
//      root.left = new TreeNode(9);
//      root.right = new TreeNode(20);
//      root.right.left = new TreeNode(15);
//      root.right.right = new TreeNode(7);

//      TreeNode root = new TreeNode(1);
//      root.left = new TreeNode(2);
//      root.left.left = new TreeNode(4);
//      root.left.right = new TreeNode(5);
//      root.right = new TreeNode(3);
//      root.right.left = new TreeNode(6);
//      root.right.right = new TreeNode(7);

      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(3);
      root.right.left.left = new TreeNode(4);
      root.right.left.left.right = new TreeNode(5);
      root.right.left.left.right.left = new TreeNode(6);
      root.right.left.left.right.right = new TreeNode(7);

      List<List<Integer>> res = levelOrderConstantSpace(root);
      System.out.println(res);
    }
  }
}
