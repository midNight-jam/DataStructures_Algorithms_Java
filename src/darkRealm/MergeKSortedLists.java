package darkRealm;

public class MergeKSortedLists {

//  23. Merge k Sorted Lists
//  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//      Example:
//
//  Input:
//      [
//      1->4->5,
//      1->3->4,
//      2->6
//      ]
//  Output: 1->1->2->3->4->4->5->6


  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length < 1) return null;
    return mergeList(lists, 0, lists.length - 1);
  }

  private  ListNode mergeList(ListNode[] lists, int low, int high) {
    if (low > high) return null;
    if (low == high) return lists[low];
    ListNode head = new ListNode(0);
    ListNode trav = head;
    ListNode a, b;
    int mid = low + (high - low) / 2;

    a = mergeList(lists, low, mid);
    b = mergeList(lists, mid + 1, high);
    while (a != null && b != null) {
      if (a.val < b.val) {
        trav.next = a;
        a = a.next;
      } else {
        trav.next = b;
        b = b.next;
      }
      trav = trav.next;
    }
    trav.next = a != null ? a : b;
    return head.next;
  }
}
