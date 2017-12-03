package darkRealm;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<TreeNode> uniqueBinarySearchTrees(int n) {
    if (n < 1) return new ArrayList<>();
    return createTree(1, n);
  }

  private static List<TreeNode> createTree(int start, int end) {
    List<TreeNode> treeList = new ArrayList<>();
    if (start > end) {
      treeList.add(null);
      return treeList;
    }
    if (start == end) {
      List<TreeNode> list = new ArrayList<>();
      list.add(new TreeNode(start));
      return list;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = createTree(start, i - 1);
      List<TreeNode> right = createTree(i + 1, end);
      // cartesian Product
      for (TreeNode lnode : left) {
        for (TreeNode rnode : right) {
          TreeNode node = new TreeNode(i);
          node.left = lnode;
          node.right = rnode;
          treeList.add(node);
        }
      }
    }
    return treeList;
  }

  public static void main(String[] args) {
    
  }
}