package darkRealm;

public class AddTwoNumbers {

//
//  2. Add Two Numbers
//  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
//  order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//      Example:
//
//  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output: 7 -> 0 -> 8
//  Explanation: 342 + 465 = 807.


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode addTwoNumbers(ListNode a, ListNode b) {
    if (a == null || b == null) {
      return null;
    }
    int carry = 0;
    ListNode sumList = null;
    ListNode sumTrav = null;
    ListNode atrav, btrav;
    atrav = a;
    btrav = b;
    int sum;
    while (atrav != null && btrav != null) {
      int aNo = atrav != null ? atrav.val : 0;
      int bNo = btrav != null ? btrav.val : 0;
      sum = aNo + bNo + carry;
      carry = sum < 10 ? 0 : 1;
      sum = sum % 10;
      if (sumList == null) {
        sumList = new ListNode(sum);
        sumTrav = sumList;
      } else {
        sumTrav.next = new ListNode(sum);
        sumTrav = sumTrav.next;
      }
      atrav = atrav.next;
      btrav = btrav.next;
    }

    ListNode nextPart = null;
    if (atrav == null && btrav != null) {
      nextPart = btrav;
    } else if (btrav == null && atrav != null) {
      nextPart = atrav;
    }
    while (nextPart != null) {
      sum = nextPart.val + carry;
      carry = sum < 10 ? 0 : 1;
      sum = sum % 10;
      sumTrav.next = new ListNode(sum);
      sumTrav = sumTrav.next;
      nextPart = nextPart.next;
    }
    if (carry == 1) {
      sumTrav.next = new ListNode(carry);
    }

    return sumList;
  }

  public static void main(String[] args) {

  }
}
