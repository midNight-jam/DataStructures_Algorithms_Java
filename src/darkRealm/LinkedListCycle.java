package darkRealm;

public class LinkedListCycle {

//  #141. Linked List Cycle
//  Given a linked list, determine if it has a cycle in it.
//  Follow up:
//  Can you solve it without using extra space?


  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != null && fast != null) {
      if (slow == fast) return true;
      slow = slow.next;
      fast = fast.next != null ? fast.next.next : fast.next;
    }

    return false;
  }

  public static void main(String[] args) {

  }
}
