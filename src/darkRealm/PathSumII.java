package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

/*
  #113. Path Sum II
  DescriptionHintsSubmissionsDiscussSolution
  Discuss Pick One
  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
  For example:
  Given the below binary tree and sum = 22,
           5
          / \
         4   8
        /   / \
      11  13  4
     /  \    / \
   7    2  5   1

    return
    [
    [5,4,11,2],
    [5,8,4,5]
    ]
  */


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    helper(root, sum, new ArrayList<>(), res);
    return res;
  }

  private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
    if (root == null) return;
    sum -= root.val;
    list.add(root.val);
    if (sum == 0 && root.left == null && root.right == null) {
      res.add(new ArrayList<>(list));
      list.remove(list.size() - 1);
      return;
    }
    helper(root.left, sum, list, res);
    helper(root.right, sum, list, res);
    list.remove(list.size() - 1);
  }

  public static void main(String[] args) {

  }
}
