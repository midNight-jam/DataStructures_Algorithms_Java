package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {

//  863. All Nodes Distance K in Binary Tree
//  We are given a binary tree (with root node root), a target node, and an integer value K.
//  Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned
//  in any order.
//
//  Example 1:
//
//  Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//  Output: [7,4,1]
//
//  Explanation:
//  The nodes that are a distance 2 from the target node (with value 5)
//  have values 7, 4, and 1.
//
//  Note that the inputs "root" and "target" are actually TreeNodes.
//  The descriptions of the inputs above are just serializations of these objects.
//
//  Note:
//
//  The given tree is non-empty.
//  Each node in the tree has unique values 0 <= node.val <= 500.
//  The target node is a node in the tree.
//  0 <= K <= 1000.

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // a signal for starting to record the node as a result
  class State {
    boolean record;
    int dist;

    State(boolean r, int d) {
      record = r;
      dist = d;
    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> res = new ArrayList<>();
    if (root == null || K < 0 || target == null)
      return res;

    helper(root, target, K, 0, res, false);
    return res;
  }

  private State helper(TreeNode root, TreeNode target, int k, int d, List<Integer> res, boolean record) {
    if (root == null) {
      return new State(false, Integer.MAX_VALUE);
    }

    if (root.val == target.val) {
      if (k == 0) {
        res.add(root.val);
        return new State(false, Integer.MAX_VALUE);
      }
      helper(root.left, target, k, 1, res, true);
      helper(root.right, target, k, 1, res, true);
      return new State(true, 1);
    }

    if (record && d == k) {
      res.add(root.val);
      return new State(false, Integer.MAX_VALUE);
    }

    State leftSt = helper(root.left, target, k, d + 1, res, record);
    if (leftSt.record) {
      if (leftSt.dist == k) {
        res.add(root.val);
        return new State(false, Integer.MAX_VALUE);
      }
      helper(root.right, target, k, leftSt.dist + 1, res, leftSt.dist + 1 <= k);
      return new State(true, leftSt.dist + 1);
    }

    State rightSt = helper(root.right, target, k, d + 1, res, record);
    if (rightSt.record) {
      if (rightSt.dist == k) {
        res.add(root.val);
        return new State(false, Integer.MAX_VALUE);
      }
      helper(root.left, target, k, rightSt.dist + 1, res, rightSt.dist + 1 <= k); // search again in leftSubtree
      return new State(true, rightSt.dist + 1);
    }

    return new State(false, Integer.MAX_VALUE);
  }

  public static void main(String[] args) {

  }
}
