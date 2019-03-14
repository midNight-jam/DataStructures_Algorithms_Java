package darkRealm;

import java.util.Random;

public class LinkedListRandomNode {

  private class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

//  Given a singly linked list, return a random node's value from the linked list. Each node must have the same
//  probability of being chosen.
//  Follow up:
//  What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently
//  without using extra space?
//
//  Example:
//
//  // Init a singly linked list [1,2,3].
//  ListNode head = new ListNode(1);
//  head.next = new ListNode(2);
//  head.next.next = new ListNode(3);
//  Solution solution = new Solution(head);
//
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
// solution.getRandom();



  ListNode head;
  Random random;

  public LinkedListRandomNode(ListNode h) {
    head = h;
    random = new Random();
  }


  /** Reservoir sampling : from the given incoming stream of nos we have to select k samples with equal probablity
   * For example k = 4 and the current nos in reservoir are [1, 2, 3, 4] (from step 1)
   *  Step 1 : first fill the reservoir with first k elements
   *  Step 2 : now when the (k + 1)th element arrives, we have to make a decision with equal probablity that it can be
   *    in reservoir.
   *    Now comes '5', the probablity of NOT selecting 5 among all the nos seen till now (1, 2, 3, 4, 5) is "1/5"
   *    the probablity of selecting '5' is (1 - selecting prob) i.e 1 - 1/5 , which evaluates to "4/5"
   *    So, the probablity of including '5' in reservoir is "4/5"
   *    Extending this for any k, probablity of any k+1 th element to be in the reservoir of size k will be "k/k+1"
   *    Again extending it for any ith element, probablity of it being in reservoir of size k will be "k/k+i"
   *
   *  This question is the case of k = 1, as we have pick only one random node,
   *  So the probablity of ith element to be in reservoir will be "1/i+1"
   *  Start
   *  for i = 0 the probality of it being in reservoir is 1/0+1 == 1/1
   *  So we generate a random no between (0-1] (excluding 1), which will be always 0
   *  for i = 1 the probality of it being in reservoir is 1/1+1 == 1/2
   *  So we generate a random no between (0-2] (excluding 2), which will be always 0 or 1, inorder to maintain "1/i+1"
   *  probablity if the random no is equal to 0 among o to i, is also 1/i+1.
   *  i.e shouldSelect = (random.nextInt(i + 1) == 0);
   */


  public int getRandom() {
    ListNode randomNode = head;
    ListNode trav = head;
    for (int i = 0; trav != null; i++) {
      boolean shouldSelect = (random.nextInt(i + 1) == 0); // i + 1 bcoz the upperbound is excluded
      if (shouldSelect)
        randomNode = trav;

      trav = trav.next;
    }

    return randomNode.val;
  }

  public static void main(String[] args) {

  }
}
