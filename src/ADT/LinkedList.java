package ADT;

/**
 * Created by Jayam on 1/4/2017.
 */
public class LinkedList {
  public LLNode head;
  public LLNode tail;
  int size;

  public void appendToTail(LLNode d) {
    if (d == null) {
      return;
    }
    if (head == null) {
      head = new LLNode(d.data);
      tail = head;
      size++;
      return;
    }
    tail.next = new LLNode(d.data);
    tail = tail.next;
    size++;
  }

  public void add(int d) {
    appendToTail(new LLNode(d));
  }

  public void appendToHead(LLNode d) {
    if (head == null) {
      head = new LLNode(d.data);
      tail = head;
      size++;
      return;
    }
    LLNode temp = new LLNode(d.data);
    temp.next = head;
    head = temp;
    size++;
  }

  public LLNode removeFirst() {
    if (size() > 0) {
      LLNode temp = head;
      head = head.next;
      size--;
      return temp;
    }
    return null;
  }

  public LLNode removeLast() {
    LLNode trav = head;
    while (trav.next.next != null) {
      trav = trav.next;
    }
    LLNode temp = trav;
    tail = trav;
    size--;
    return temp;
  }

  public int size() {
    return size;
  }

  public LinkedList clone() {
    LLNode travA = this.head;
    LinkedList clone = new LinkedList();
    while (travA != null) {
      clone.add(travA.data);
      travA = travA.next;
    }
    return clone;
  }

  public void addAll(LinkedList list) {
    LLNode trav = list.head;
    while (trav != null) {
      if (this.tail == null) {
        this.tail = new LLNode(trav.data);
      } else {
        this.tail.next = new LLNode(trav.data);
      }
      this.tail = this.tail.next;
      trav = trav.next;
    }
  }

  public LLNode reverseBetween(int m, int n) {
    if (m < 1 || n < 1) {
      return head;
    }
    LLNode trav = head;
    LLNode pos = head;
    for (int i = 1; i < m; i++) {
      pos = trav;
      trav = trav.next;
    }
    LLNode prev = null;
    LLNode curr = trav;
    LLNode last = curr;
    LLNode temp = curr.next;
    int t = m;
    while (t <= n) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
      t++;
    }
    if (m == 1) {
      head = prev;
    } else {
      pos.next = prev;
    }
    last.next = temp;
    return head;
  }

  public LLNode getMid(LLNode head) {
    LLNode slow = head;
    LLNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    LLNode mid = slow;
    if (fast == null) {//even
      mid = slow;
    } else {
      mid = slow.next;
    }
    return mid;
  }

  // will go till mid & reverse the link from mid to end , now will read from haed & mid & keep matching if all matched true
  public boolean isPalindrome(LLNode head) {
    if (head == null) {
      return true;
    }
    LLNode trav = head;
    LLNode slow = head;
    LLNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    LLNode otherHalf;
    if (fast == null) { // even
      otherHalf = slow;
    } else {  // odd
      otherHalf = slow.next;
    }
    LLNode prev = null;
    LLNode trav2 = otherHalf;
    LLNode temp;
    while (trav2 != null) {
      temp = trav2.next;
      trav2.next = prev;
      prev = trav2;
      trav2 = temp;
    }
    otherHalf = prev;
    while (otherHalf != null & trav != slow) {
      if (otherHalf.data != trav.data) {
        break;
      }
      trav = trav.next;
      otherHalf = otherHalf.next;
    }
    if (otherHalf != null) {
      return false;
    }
    return true;
  }

  public void reverse(LLNode trav) {
    if (trav == null) return;

    if (trav.next == null) {
      head = trav;
      return;
    }

    reverse(trav.next);
    trav.next.next = trav;
    trav.next = null;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    LLNode trav = head;
    while (trav != null) {
      stringBuilder.append(" " + trav.data);
      trav = trav.next;
    }
    return stringBuilder.toString();
  }

  /*Sorting a linked list using Insertion Sort*/
  public LLNode sortLinkedList() {
    if (head == null || head.next == null) return head;
    LLNode dummyHead = new LLNode(0);
    LLNode curr = head;
    LLNode prev = dummyHead;
    LLNode next = null;
    while (curr != null) {
      next = curr.next; // preserving the next
      // scanning the list to find the right place to insert
      while (prev.next != null && prev.next.data <= curr.data) prev = prev.next;

      // inseritng in between
      curr.next = prev.next;
      prev.next = curr;
      prev = dummyHead;
      curr = next;
    }
    return dummyHead.next;
  }

  public LLNode mergeWith(LinkedList secondList) {
    return mergeTwoLists(head, secondList.head);
  }

  private LLNode mergeTwoLists(LLNode n1, LLNode n2) {
    if (n1 == null) return n2;
    if (n2 == null) return n1;

    if (n1.data < n2.data) {
      n1.next = mergeTwoLists(n1.next, n2);
      return n1;
    } else {
      n2.next = mergeTwoLists(n1, n2.next);
      return n2;
    }
  }

  public LLNode reverseInKGroups(LLNode head, int k) {
    LLNode curr = head;
    int count = 0;
    while (curr != null && count < k) {
      curr = curr.next;
      count++;
    }

    if (count == k) {
      curr = reverseInKGroups(curr, k);
      while (count > 0) {
        LLNode next = head.next;
        head.next = curr;
        curr = head;
        head = next;
      }
      head = curr;
    }
    return head;
  }

  public boolean hasCycle() {
    if (head == null) return false;
    LLNode fast = head;
    LLNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  /* [19] Remove Nth LLNode From End of List
  * */
  public LLNode removeKthFromEnd(LLNode LLNode, int n) {
    if (LLNode == null) return LLNode;
    LLNode trav = LLNode;
    while (trav != null && n-- > 0)
      trav = trav.next;
    if (trav == null && n != 0) return null;
    LLNode prev = null, pivot = LLNode;
    while (trav != null) {
      trav = trav.next;
      prev = pivot;
      pivot = pivot.next;
    }
    if (prev != null)
      prev.next = pivot.next;
    else
      this.head = this.head.next;
    return this.head;
  }
}