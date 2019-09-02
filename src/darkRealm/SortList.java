package darkRealm;

public class SortList {


  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }


//  148. Sort List
//  Sort a linked list in O(n log n) time using constant space complexity.
//
//  Example 1:
//
//  Input: 4->2->1->3
//  Output: 1->2->3->4
//  Example 2:
//
//  Input: -1->5->3->4->0
//  Output: -1->0->3->4->5



  /*
   * Initially I thought constant space means we cant even use the space of recursion stack, but its not that.
   * */

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow, fast, prevSlow = null;
    slow = fast = head;

    while (fast != null && fast.next != null) {
      prevSlow = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (prevSlow != null)
      prevSlow.next = null;
    ListNode first = sortList(head);
    ListNode second = sortList(slow);

    return merge(first, second);
  }

  private static ListNode merge(ListNode l1, ListNode l2) {
    ListNode head, trav;
    head = trav = null;
    int l1val, l2val;
    l1val = l2val = Integer.MAX_VALUE;
    while (l1 != null || l2 != null) {
      l1val = l1 == null ? Integer.MAX_VALUE : l1.val;
      l2val = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (l1val < l2val) {
        if (head == null) {
          head = l1;
          trav = head;
        } else {
          trav.next = l1;
          trav = trav.next;
        }
        l1 = l1.next;
      } else {
        if (head == null) {
          head = l2;
          trav = head;
        } else {
          trav.next = l2;
          trav = trav.next;
        }
        l2 = l2.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
//    ListNode head = new ListNode(4);
//    head.next = new ListNode(2);
//    head.next.next = new ListNode(1);
//    head.next.next.next = new ListNode(3);

    ListNode head = new ListNode(-1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(0);

    head = sortList(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
