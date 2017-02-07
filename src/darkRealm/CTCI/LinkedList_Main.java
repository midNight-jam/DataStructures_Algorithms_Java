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
//    Node n1 = new Node(1);
//    Node n2 = new Node(9);
//    n0.next = n1;
//    n1.next = n2;
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
}