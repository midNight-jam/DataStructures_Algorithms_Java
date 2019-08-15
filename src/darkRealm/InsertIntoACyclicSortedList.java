package darkRealm;

public class InsertIntoACyclicSortedList {

//  708. Insert into a Cyclic Sorted List
//  Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into
//  the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the
//  list, and may not be necessarily the smallest value in the cyclic list.
//
//  If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the
//  insertion, the cyclic list should remain sorted.
//
//  If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the
//  reference to that single node. Otherwise, you should return the original given node.
//
//  The following example may help you understand the problem better:
//
//  In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with
//  value 3, and we need to insert 2 into the list.
//
//  The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and
//  we should still return node 3.


  private static class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  }

  public static Node insert(Node head, int insertVal) {
    if (head == null) {
      Node nn = new Node(insertVal, null);
      nn.next = nn;
      return nn;
    }

    Node trav = head;
    Node maxN = head;
    int max = Integer.MIN_VALUE;

    do {
      if (trav.val <= insertVal && insertVal < trav.next.val) {
        Node nn = new Node(insertVal, trav.next);
        trav.next = nn;
        return head;
      }
      if (trav.val >= max) {  // keep the last node of max
        maxN = trav;
        max = trav.val;
      }
      trav = trav.next;
    } while (trav != head);

    // always insert after max, bcoz at this point either the insert val is smaller than the MIN or greater than the MAX
    // in both case inserting it after the max will keep the circular linked list sorted.
    Node nn = new Node(insertVal, maxN.next);
    maxN.next = nn;
    return head;
  }

  public static void main(String[] args) {
    Node head = null;
//    head = insert(null, 6);
//    insert(head, 2);
//    insert(head, 4);
//    head = insert(null, 6);
//    insert(head, 4);
//    insert(head, 2);
//    head = insert(null, 2);
//    insert(head, 6);
//    insert(head, 4);
//    head = insert(null, 2);
//    insert(head, 4);
//    insert(head, 6);
//    head = insert(null, 4);
//    insert(head, 6);
//    insert(head, 2);
    head = insert(null, 4);
    insert(head, 2);
    insert(head, 6);


    Node trav = head;
    do {
      System.out.print(trav.val + " ");
      trav = trav.next;
    } while (trav != head);

  }
}
