package darkRealm.CTCI;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Linked_List;
import darkRealm.CTCI.LinkedLists.Node;

import static darkRealm.CTCI.LinkedLists.Linked_List.deepCopyOfRandomList;

/**
 * Created by Jayam on 1/4/2017.
 */
public class LinkedList_Main {
  public static void testLinkedListOperations() {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.appendToTail(new Node(3));
    list.appendToHead(new Node(0));
    LinkedList l2 = list.clone();
    list.addAll(l2);
    System.out.println("list - " + list);
  }

  public static void testDeepCopyRandomList() {
    Linked_List.RandomNode r1 = new Linked_List.RandomNode(11);
    Linked_List.RandomNode r2 = new Linked_List.RandomNode(22);
    Linked_List.RandomNode r3 = new Linked_List.RandomNode(33);
    Linked_List.RandomNode r4 = new Linked_List.RandomNode(44);

    r1.next = r2;
    r2.next = r3;
    r3.next = r4;
    r4.next = null;

    r1.randomPointer = r3;
    r2.randomPointer = r4;
    r3.randomPointer = r1;
    r4.randomPointer = r2;

    Linked_List.RandomList rand = new Linked_List.RandomList(r1);
    Linked_List.RandomNode trav = rand.head;
    while (trav != null) {
      System.out.println("Data : " + trav.data + " rand : " + trav.randomPointer.data + " Next : " + trav.next);
      trav = trav.next;
    }
    Linked_List.RandomList randDeepCopy = deepCopyOfRandomList(rand);
    trav = randDeepCopy.head;
    while (trav != null) {
      System.out.println("Data : " + trav.data + " rand : " + trav.randomPointer.data + " Next : " + trav.next);
      trav = trav.next;
    }
  }

  public static void testPalindrome() {
    LinkedList list = new LinkedList();
    list.add(11);
    list.add(22);
    list.add(33);
    list.add(22);
    list.add(11);
    boolean res = list.isPalindrome(list.head);
    System.out.println("res : " + res + " List : " + list);
  }

  public static void testReverseBetween() {
    LinkedList list = new LinkedList();
//    list.add(1);
//    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
//    list.add(6);
    Node temp = list.reverseBetween(0, 3);
    System.out.println(" List : ");
  }

  public static void testIntersection() {
    Node n0 = new Node(0);
    Node n1 = new Node(11);
    Node n2 = new Node(22);
    Node n3 = new Node(33);
    Node n4 = new Node(44);
    Node n5 = new Node(55);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    LinkedList l1 = new LinkedList();
    l1.head = n0;

//    Node p1 = new Node(101);
//    Node p2 = n0;
//    p1.next = p2;
    LinkedList l2 = new LinkedList();
    l2.head = n0;

    Node intersection = Linked_List.intersection(l1, l2);
    System.out.println(" intersection : " + intersection.data);
  }

  public static void testSumList() {
    Node n0 = new Node(1);
    Node n1 = new Node(1);
    Node n2 = new Node(9);
    n0.next = n1;
    n1.next = n2;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node n3 = new Node(9);
    Node n4 = new Node(8);
    Node n5 = new Node(8);
    Node n6 = new Node(8);
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    LinkedList L2 = new LinkedList();
    L2.head = n3;
    LinkedList res = Linked_List.sumList(L1, L2);
    System.out.println(" a : " + L1);
    System.out.println(" b : " + L2);
    System.out.println(" r : " + res);
  }

  public static void testSumListII() {
    //7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Node n0 = new Node(7);
//    Node n1 = new Node(2);
//    Node n2 = new Node(4);
//    Node n3 = new Node(3);
//    n0.next = n1;
//    n1.next = n2;
//    n2.next = n3;
//    LinkedList L1 = new LinkedList();
//    L1.head = n0;
//
//    Node n4 = new Node(5);
//    Node n5 = new Node(6);
//    Node n6 = new Node(4);
//    n4.next = n5;
//    n5.next = n6;
//    LinkedList L2 = new LinkedList();
//    L2.head = n4;

    Node n0 = new Node(1);
    Node n1 = new Node(0);
    Node n2 = new Node(0);
    Node n3 = new Node(1);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node n4 = new Node(9);
    Node n5 = new Node(9);
    Node n6 = new Node(9);
    n4.next = n5;
    n5.next = n6;
    LinkedList L2 = new LinkedList();
    L2.head = n4;

    LinkedList res = Linked_List.addTwoNumbers(L1, L2);
    System.out.println(" a : " + L1);
    System.out.println(" b : " + L2);
    System.out.println(" r : " + res);
  }

  public static void testSumListNatural() {
    Node n0 = new Node(1);
    Node n1 = new Node(1);
    Node n2 = new Node(9);
    n0.next = n1;
    n1.next = n2;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node n3 = new Node(9);
    Node n4 = new Node(9);
    Node n5 = new Node(9);
    Node n6 = new Node(9);
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    LinkedList L2 = new LinkedList();
    L2.head = n3;
    LinkedList res = Linked_List.sumListNatural(L1, L2);
    System.out.println(" a : " + L1);
    System.out.println(" b : " + L2);
    System.out.println(" r : " + res);
  }

  public static void testReverseMid() {
    Node n0 = new Node(1);
//    Node n1 = new Node(2);
//    Node n2 = new Node(3);
//    Node n3 = new Node(4);
//    Node n4 = new Node(5);
//    Node n5 = new Node(6);
//    n0.next = n1;
//    n1.next = n2;
//    n2.next = n3;
//    n3.next = n4;
//    n4.next = n5;
    LinkedList L1 = new LinkedList();
    L1.head = n0;
    System.out.println(" List : " + L1);
    LinkedList res = Linked_List.reverseFromMid(L1);
    System.out.println("  Res : " + res);
  }

  public static void testMergeTwoList() {
    Node n0 = new Node(1);
    Node n1 = new Node(5);
    Node n2 = new Node(8);
    n0.next = n1;
    n1.next = n2;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node n3 = new Node(3);
    Node n4 = new Node(7);
    Node n5 = new Node(9);
    Node n6 = new Node(10);
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    LinkedList L2 = new LinkedList();
    L2.head = n3;

//    Node res = Linked_List.mergeSortedList(n0, n3);
    Node res = Linked_List.mergeSortedListRecur(n0, n3);
//    Node res = Linked_List.mergeSortedList(null, n3);
//    Node res = Linked_List.mergeSortedListRecur(null, n3);
//    Node res = Linked_List.mergeSortedList(n0, null);
    System.out.println("Result : " + res.data);
  }

  public static void testMergeKLists() {
    Node n0 = new Node(1);
    Node n1 = new Node(5);
//    Node n2 = new Node(8);
    n0.next = n1;
//    n1.next = n2;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node n3 = new Node(3);
    Node n4 = new Node(7);
//    Node n5 = new Node(9);
//    Node n6 = new Node(10);
    n3.next = n4;
//    n4.next = n5;
//    n5.next = n6;
    LinkedList L2 = new LinkedList();
    L2.head = n3;

    Node n10 = new Node(2);
    Node n11 = new Node(4);
//    Node n5 = new Node(9);
//    Node n6 = new Node(10);
    n10.next = n11;

    Node[] lists = new Node[]{n0, n3, n10};

//    Node res = Linked_List.mergeKLists(lists);
//    Node res = Linked_List.mergeKLists(lists);
    Node res = Linked_List.mergeKListsFinal(lists);
    System.out.println(" Res : " + res.data);
  }

  public static void testReverse() {
    Node n0 = new Node(1);
    Node n1 = new Node(2);
    Node n2 = new Node(3);
    Node n3 = new Node(4);
    Node n4 = new Node(5);
    Node n5 = new Node(6);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    LinkedList L1 = new LinkedList();
    L1.head = n0;


    L1.reverse(L1.head);
    System.out.println(L1);
  }

  public static void testMergerLinkedList() {
    Node n0 = new Node(1);
    Node n1 = new Node(3);
    Node n2 = new Node(5);
    Node n3 = new Node(7);
    Node n4 = new Node(9);
    Node n5 = new Node(11);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    LinkedList L1 = new LinkedList();
    L1.head = n0;

    Node m0 = new Node(2);
    Node m1 = new Node(4);
    Node m2 = new Node(6);
    Node m3 = new Node(8);
    Node m4 = new Node(10);
    Node m5 = new Node(12);
    m0.next = m1;
    m1.next = m2;
    m2.next = m3;
    m3.next = m4;
    m4.next = m5;
    LinkedList L2 = new LinkedList();
    L2.head = m0;

    Node mergeHead = L1.mergeWith(L2);
    System.out.println(mergeHead);
  }
}