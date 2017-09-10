package darkRealm;

public class IsSubtree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

//  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
//  Example 1:
//  Given tree s:
//       3
//      / \
//     4   5
//    / \
//   1   2
//  Given tree t:
//       4
//      / \
//     1   2
//  Return true, because t has the same structure and node values with a subtree of s.
//  Example 2:
//  Given tree s:
//        3
//       / \
//      4   5
//     / \
//   1   2
//      /
//    0
//  Given tree t:
//       4
//      / \
//     1   2
//  Return false.

  public static boolean findSubTree(TreeNode s, TreeNode t) {
    if (t == null && s == null) return true;
    if (s == null || t == null) return false;
    if (s.val != t.val) return false;
    return findSubTree(s.left, t.left) && findSubTree(s.right, t.right);
  }

  public static boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (findSubTree(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(3);
    t1.left = new TreeNode(4);
    t1.right = new TreeNode(5);
    t1.left.left = new TreeNode(1);
    t1.left.right = new TreeNode(2);

    TreeNode t2 = new TreeNode(4);
    t2.left = new TreeNode(1);
    t2.right = new TreeNode(2);
    boolean res = isSubtree(t1, t2);
    System.out.println("Res : " + res);
  }
}