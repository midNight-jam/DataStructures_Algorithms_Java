package darkRealm;

public class SwapNodesInPairs {

// #24. Swap Nodes in Pairs
//  Given a linked list, swap every two adjacent nodes and return its head.
//  For example,
//  Given 1->2->3->4, you should return the list as 2->1->4->3.
//  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
//  changed.

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode swapPairsIterative(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = null;
    ListNode trav, next, temp, prev;
    prev = null;
    trav = head;
    next = trav.next;
    newHead = next;
    while (trav != null && trav.next != null) {
      next = trav.next;
      if (prev != null)
        prev.next = next;

      temp = next.next;
      next.next = trav;
      trav.next = temp;
      prev = trav;
      trav = trav.next;
    }
    return newHead;
  }

  public static ListNode swapPairs(ListNode head) {
    return helper(head);
  }

  private static ListNode helper(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode newNext = helper(head.next.next);
    ListNode next = head.next;
    head.next = newNext;
    next.next = head;
    return next;
  }
}
