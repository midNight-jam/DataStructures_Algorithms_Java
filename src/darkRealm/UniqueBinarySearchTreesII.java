package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

//  #95. Unique Binary Search Trees II
//  Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//  For example,
//  Given n = 3, your program should return all 5 unique BST's shown below.
//
//      1         3     3      2      1
//      \       /     /      / \      \
//      3     2     1      1   3      2
//      /     /       \                 \
//      2     1         2                 3


  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

 public static List<TreeNode> generateTrees(int n) {
    if(n < 1) return new ArrayList<>();
    return helper(1, n);
  }
  
  private static List<TreeNode> helper(int start, int end){
    List<TreeNode> list = new ArrayList<>();
    if(start > end){
      list.add(null);
      return list;
    }
    
    if(start == end){
      list.add(new TreeNode(start));
      return list;
    }
    
    for(int i = start; i <= end; i++){
      List<TreeNode> leftSubTree = helper(start, i - 1);
      List<TreeNode> rightSubTree = helper(i + 1, end);
      // now create all the combinations of this subtree using the cartesian product
      for(TreeNode left : leftSubTree){
        for(TreeNode right : rightSubTree){
          TreeNode root = new TreeNode(i); // create a new root for each combination of tree
          root.left = left;
          root.right = right;
          list.add(root);
        } 
      }
    }
    
    return list;
  }
  public static void main(String[] args) {

  }
}
