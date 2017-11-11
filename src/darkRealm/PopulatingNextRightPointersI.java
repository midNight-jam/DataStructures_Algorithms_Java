package darkRealm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersI {

//  #116. Populating Next Right Pointers in Each Node
//  Given a binary tree
//  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//  Initially, all next pointers are set to NULL.
//  Note:
//  You may only use constant extra space.
//  You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//  For example,
//  Given the following perfect binary tree,
//              1
//             /  \
//           2    3
//          / \  / \
//         4  5  6  7
//  After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//     2 -> 3 -> NULL
//    / \  / \
//   4->5->6->7 -> NULL


  static class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    int val;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  public static void connect(TreeLinkNode root) {
    if (root == null) return;
    Queue<TreeLinkNode> que = new LinkedList<>();
    que.offer(root);
    TreeLinkNode trav;
    while (!que.isEmpty()) {
      int size = que.size();
      while (size-- != 0) {
        trav = que.poll();
        trav.next = size ==0 ? null : que.peek();
        if (trav.left != null) que.offer(trav.left);
        if (trav.right != null) que.offer(trav.right);
      }
    }
  }

  public static void main(String[] args) {
    Queue<String> que = new LinkedList<>();
    que.offer("a");
    que.offer("b");
    que.offer("c");
    String pop = que.poll();
    String peek = que.peek();

    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);
    root.left.left = new TreeLinkNode(4);
    root.left.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    connect(root);
    System.out.println(root.val);
  }
}
