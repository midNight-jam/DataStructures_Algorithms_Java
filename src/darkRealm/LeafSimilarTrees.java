package darkRealm;

public class LeafSimilarTrees {

//  872. Leaf-Similar Trees
//
//  Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value
//  sequence.
////          3
//          /   \
//         5       1
//        /  \    |   \
//      6     2   9    8
//          /   \
//        7       4
//
//  For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//  Two binary trees are considered leaf-similar if their leaf value sequence is the same.
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//      Note:
//  Both of the given trees will have between 1 and 100 nodes.




  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    StringBuffer sbr = new StringBuffer();
    inorder(root1, sbr);
    String first = sbr.toString();
    sbr.setLength(0);
    inorder(root2, sbr);
    String second = sbr.toString();
    return first.equals(second);
  }

  private void inorder(TreeNode root, StringBuffer sbr){
    if(root == null) return;
    if(root.left == null && root.right == null){
      sbr.append(root.val);
      return;
    }

    inorder(root.left, sbr);
    inorder(root.right, sbr);
  }

}
