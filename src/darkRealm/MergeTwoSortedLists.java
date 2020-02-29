package darkRealm;

public class MergeTwoSortedLists {


//
//  21. Merge Two Sorted Lists
//  Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
//  nodes of the first two lists.
//
//  Example:
//
//  Input: 1->2->4, 1->3->4
//  Output: 1->1->2->3->4->4

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
    return mergeSortedList(list1,list2);
  }

  public ListNode mergeSortedList(ListNode list1,ListNode list2) {
    if (list1==null) {
      return list2;
    }
    if (list2==null) {
      return list1;
    }
    if(list1.val<list2.val) {
      list1.next=mergeSortedList(list1.next, list2);
      return list1;
    }
    else {
      list2.next=mergeSortedList(list1, list2.next);
      return list2;
    }
  }

}
