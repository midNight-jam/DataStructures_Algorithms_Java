package darkRealm;

public class LinkedListCycle {

//  #141. Linked List Cycle
//  Given a linked list, determine if it has a cycle in it.
//  Follow up:
//  Can you solve it without using extra space?

  public static boolean hasCycle(DeleteNode.ListNode head) {
    if(head == null || head.next == null) return false;
    DeleteNode.ListNode slow = head, fast = head.next;
    while(slow != null && slow.next!= null && fast != null && fast.next != null){
      if(slow == fast) return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
  public static void main(String[] args) {

  }
}
