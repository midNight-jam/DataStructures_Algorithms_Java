package darkRealm.CTCI;

import darkRealm.CTCI.LinkedLists.LinkedList;
import darkRealm.CTCI.LinkedLists.Node;

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
    LinkedList_Main.RandomNode r1 = new LinkedList_Main.RandomNode(11);
    LinkedList_Main.RandomNode r2 = new LinkedList_Main.RandomNode(22);
    LinkedList_Main.RandomNode r3 = new LinkedList_Main.RandomNode(33);
    LinkedList_Main.RandomNode r4 = new LinkedList_Main.RandomNode(44);

    r1.next = r2;
    r2.next = r3;
    r3.next = r4;
    r4.next = null;

    r1.randomPointer = r3;
    r2.randomPointer = r4;
    r3.randomPointer = r1;
    r4.randomPointer = r2;

    LinkedList_Main.RandomList rand = new LinkedList_Main.RandomList(r1);
    RandomNode trav = rand.head;
    while (trav != null) {
      System.out.println("Data : " + trav.data + " rand : " + trav.randomPointer.data + " Next : " + trav.next);
      trav = trav.next;
    }
    LinkedList_Main.RandomList randDeepCopy = deepCopyOfRandomList(rand);
    trav = randDeepCopy.head;
    while (trav != null) {
      System.out.println("Data : " + trav.data + " rand : " + trav.randomPointer.data + " Next : " + trav.next);
      trav = trav.next;
    }
  }


  /*  [138] Copy List with Random Pointer
  * A linked list is given such that each node contains an additional random pointer which could point to any node in
   * the list or null. Return a deep copy of the list.
  * */
  public static RandomList deepCopyOfRandomList(RandomList list) {
    RandomNode trav = list.head;
    // First Insert newly created deep copy of nodes in to the list
    while (trav != null) {
      RandomNode deepNode = new RandomNode(trav.data);
      deepNode.next = trav.next;
      trav.next = deepNode;
      trav = deepNode.next;
    }

    //Now set the random pointer using the new next operations avalable after insertion of new nodes
    trav = list.head;
    while (trav != null) {
      trav.next.randomPointer = trav.randomPointer;
      trav = trav.next.next;
    }
    // now lets seperate the the newly deeply copied list in to a seprate list
    trav = list.head;
    RandomNode newHead = trav.next;
    trav = trav.next.next;
    RandomNode newTrav = newHead;
    while (trav != null) {
      newTrav.next = trav.next;
      trav = trav.next.next;
      newTrav = newTrav.next;
    }
    return new RandomList(newHead);
  }

  public static class RandomList extends LinkedList {
    RandomNode head;

    public RandomList(RandomNode head) {
      this.head = head;
    }
  }

  public static class RandomNode {
    RandomNode randomPointer;
    RandomNode next;
    int data;

    public RandomNode(int d) {
      data = d;
    }
  }

  public static void testReverseBetween() {
    LinkedList list = new LinkedList();
//    list.add(1);
//    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
//    list.add(6);
    Node temp = list.reverseBetween(0,3);
    System.out.println(" List : ");
  }
}