package darkRealm;

public class BST_To_GreaterTree {

//  538. Convert BST to Greater Tree
//  Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the 
//  original key plus sum of all keys greater than the original key in BST.
//
//  Example:
//
//  Input: The root of a Binary Search Tree like this:
//        5
//      /   \
//      2     13
//
//  Output: The root of a Greater Tree like this:
//        18
//      /   \
//      20     13

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static int runningSum = 0;

  public static void convertBSTSum(TreeNode node) {
    // drop down to the right most & keep track of running sum, while returning add it to the current node val
    if(null == node) return;
    convertBSTSum(node.right);
    runningSum += node.val;
    node.val = runningSum;
    convertBSTSum(node.left);
  }

  public static TreeNode convertBST(TreeNode root) {
    convertBSTSum(root);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

//    TreeNode root = new TreeNode(2);
//    root.left = new TreeNode(0);
//    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(-4);
//    root.left.right = new TreeNode(1);

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(0);
//    root.right = new TreeNode(4);
//    root.left.left = new TreeNode(-2);
//    root.right.left = new TreeNode(3);


    convertBST(root);
    System.out.println("Root : " + root.val);
  }
}
