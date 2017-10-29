package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

//  #297. Serialize and Deserialize Binary Tree
//  Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//  Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//  For example, you may serialize the following tree
//         1
//        / \
//       2   3
//          / \
//         4   5
//  as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//      Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    inorder(root, sb);
    return sb.toString();
  }

  private void inorder(TreeNode trav, StringBuilder sb) {
    if (trav == null) {
      sb.append("N ");
      return;
    }
    sb.append(trav.val + " ");
    inorder(trav.left, sb);
    inorder(trav.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(" ")));
    return helper(nodes);
  }

  private TreeNode helper(Queue<String> nodes) {
    if (nodes == null || nodes.size() < 1) return null;
    String n = nodes.poll();
    if (n.equals("N")) return null;
    TreeNode trav = new TreeNode(Integer.parseInt(n));
    trav.left = helper(nodes);
    trav.right = helper(nodes);
    return trav;
  }

  public static void main(String[] args) {
    System.out.println("Deserialize and Serialize tree");
  }
}