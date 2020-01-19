package darkRealm;

public class BinaryTreeToString {

//  You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing
//  way.
//
//  The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
//  parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary
//  tree.
//
//  Example 1:
//  Input: Binary tree: [1,2,3,4]
//        1
//      /   \
//     2     3
//    /
//   4
//
//  Output: "1(2(4))(3)"
//
//  Explanation: Originallay it needs to be "1(2(4)())(3()())",
//  but you need to omit all the unnecessary empty parenthesis pairs.
//  And it will be "1(2(4))(3)".
//  Example 2:
//  Input: Binary tree: [1,2,3,null,4]
//        1
//      /   \
//     2     3
//      \
//       4
//
//  Output: "1(2()(4))(3)"
//
//  Explanation: Almost the same as the first example,
//  except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static String tree2str(TreeNode t) {
    if (t == null)
      return "";
    String left = tree2str(t.left);
    String right = tree2str(t.right);

    // no children of root
    if (left.length() + right.length() == 0)
      return t.val + "";

    String fromRight = right.length() > 0 ? right : "";

    String res = t.val + "(" + left + ")"; // left will always be appended unless there are no children of the root;

    // right only gets appended if there is a right subTree
    if (fromRight.length() > 0)
      res += "(" + fromRight + ")";

    return res;
  }

  public static String treeToString(TreeNode node) {
    if (null == node) return "";
    String left = treeToString(node.left);
    String right = treeToString(node.right);
    String nodeStr = node.val + "";
    if (left == "" && right == "")
      return nodeStr;
    if (right == "")
      return nodeStr + "(" + left + ")";
    if (left == "")
      return nodeStr + "()(" + right + ")";
    return nodeStr + "(" + left + ")" + "(" + right + ")";
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(4);
    String res = treeToString(root);
    System.out.println("TreeString : " + res);

    res = tree2str(root);
    System.out.println("TreeString : " + res);
  }
}