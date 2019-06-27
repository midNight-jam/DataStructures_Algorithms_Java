package darkRealm;

//117. Populating Next Right Pointers in Each Node II
//    Given a binary tree
//
//    struct Node {
//    int val;
//    Node *left;
//    Node *right;
//    Node *next;
//    }
//    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
//    should be set to NULL.
//
//    Initially, all next pointers are set to NULL.
//    Example:
//
//    Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},
//    "next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,
//    "right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},
//    "val":3},"val":1}
//
//    Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,
//    "next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},
//    "next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},
//    "next":null,"right":{"$ref":"6"},"val":1}
//
//    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point
//    to its next right node, just like in Figure B.
//
//    Note:
//
//    You may only use constant extra space.
//    Recursive approach is fine, implicit stack space does not count as extra space for this problem.


public class PopulatingNextRightPointersInEachNodeII {
  private static class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int x) {
      val = x;
    }
  }

  public Node connect(Node root) {
    helper(root);
    return root;
  }

  private void helper(Node root) {
    if (root == null) return;
    Node trav = root;
    Node head = null;
    while (trav != null) {
      if (trav.left != null) {
        if (head == null)
          head = trav.left;
        else {
          head.next = trav.left;
          head = head.next;
        }
      }

      if (trav.right != null) {
        if (head == null)
          head = trav.right;
        else {
          head.next = trav.right;
          head = head.next;
        }
      }

      trav = trav.next;
    }

    helper(root.left);
    helper(root.right);
  }

  public static void main(String[] args) {
    System.out.println("Levels");
  }
}