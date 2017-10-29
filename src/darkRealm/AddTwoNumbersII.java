package darkRealm;

import java.util.Stack;

public class AddTwoNumbersII {

//  #445. Add Two Numbers II
//  You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
//  first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//  Follow up:
//  What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//  Example:
//  Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output: 7 -> 8 -> 0 -> 7

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<ListNode> first = new Stack<>();
    Stack<ListNode> second = new Stack<>();
    ListNode trav1 = l1;
    ListNode trav2 = l2;
    while (trav1 != null) {
      first.push(trav1);
      trav1 = trav1.next;
    }
    while (trav2 != null) {
      second.push(trav2);
      trav2 = trav2.next;
    }
    ListNode res = null, trav;
    int carry = 0;
    while (!first.isEmpty() || !second.isEmpty()) {
      trav = new ListNode(carry);
      if (!first.isEmpty()) trav.val += first.pop().val;
      if (!second.isEmpty()) trav.val += second.pop().val;
      carry = trav.val / 10;
      trav.val = trav.val % 10;
      trav.next = res;
      res = trav;
    }
    if (carry > 0) {
      trav = new ListNode(carry);
      trav.next = res;
      res = trav;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("Runs");
  }
}