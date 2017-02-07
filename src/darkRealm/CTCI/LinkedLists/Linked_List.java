package darkRealm.CTCI.LinkedLists;

/**
 * Created by Jayam on 2/6/2017.
 */
public class Linked_List {

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
    public RandomNode head;

    public RandomList(RandomNode head) {
      this.head = head;
    }
  }

  public static class RandomNode {
    public RandomNode randomPointer;
    public RandomNode next;
    public int data;

    public RandomNode(int d) {
      data = d;
    }
  }

  /*  [Prob 2.7] Intersection
  *   Q) Given 2 linked list that meet each other at some node , find the node at which these two linked list intersect
  *   A) we traverse both list while measuring their lengths and if we end up from both list at the last node, then there
   *   is a intersection. Now we take diff of lengths, this is crucial in deciding where the intersecting node will be
   *   the list which is longer, we send a pointer in that list which is ahead by the diff of lengths. Now we traverse
    *   with this pointers onw that is skipped in longer & one from the start of the shorter list, The point at which
    *   they meet at a same node, is the intersection Node.
  * */
  public static Node intersection(LinkedList l1, LinkedList l2) {
    Node trav1, trav2;
    trav1 = l1.head;
    trav2 = l2.head;
    int len1, len2;
    len1 = len2 = 0;
    while (trav1.next != null) {
      trav1 = trav1.next;
      len1++;
    }
    while (trav2.next != null) {
      trav2 = trav2.next;
      len2++;
    }
    if (trav1 == trav2) {// they both intersect
      // get the longer list
      Node longer, shorter;
      if (len1 > len2) {
        longer = l1.head;
        shorter = l2.head;
      } else {
        longer = l2.head;
        shorter = l1.head;
      }
      int diff = Math.abs(len1 - len2);
      Node skipped = longer;
      // skip the longer list, this is done in order to bring both pointers at same dist from end.
      while (diff != 0) {
        skipped = skipped.next;
        diff--;
      }
      Node second = shorter;
      while (skipped != second) {
        skipped = skipped.next;
        second = second.next;
      }
      return skipped;
    }
    return null;
  }
}