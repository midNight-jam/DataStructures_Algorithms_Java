package darkRealm;

import java.util.LinkedList;
import java.util.List;

public class SymmetricTree {

//  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//       1
//      / \
//     2   2
//    / \ / \
//   3  4 4  3
//  But the following [1,2,2,null,3,null,3] is not:
//        1
//       / \
//      2   2
//       \   \
//       3    3
//  Note:
//  Bonus points if you could solve it both recursively and iteratively.

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static boolean levelOrder(TreeNode trav) {
    List<TreeNode> queue = new LinkedList<>();
    queue.add(trav);
    int size = queue.size();
    while (queue.size() != 0) {
      size = queue.size();
      for(int i = 0, j = size - 1; i <= j; i++, j--)
          if(queue.get(i).val != queue.get(j).val) return false;
      while(size!=0){
        TreeNode processed = queue.remove(0);
        size--;
        if(processed.val == Integer.MIN_VALUE) continue;
        if(processed.left == null) queue.add(new TreeNode(Integer.MIN_VALUE));
        else queue.add(processed.left);
        if(processed.right == null) queue.add(new TreeNode(Integer.MIN_VALUE));
        else queue.add(processed.right);
      }
    }
    return true;
  }


  public static boolean isSymmetricTreeLevel(TreeNode node) {
    return levelOrder(node);
  }


  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(2);
//    root.right.left = new TreeNode(4);
//    root.right.right = new TreeNode(3);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    root.right.left = new TreeNode(2);
//    root.left.left = new TreeNode(3);
//
    boolean res = isSymmetricTreeLevel(root);
    System.out.println("IsSymmetric : " + res);
  }
}
