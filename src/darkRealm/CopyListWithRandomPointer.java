package darkRealm;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


//  138. Copy List with Random Pointer
//  A linked list is given such that each node contains an additional random pointer which could point to any node in
//  the list or null.
//
//  Return a deep copy of the list.
//
//  The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of
//  [val, random_index] where:
//
//  val: an integer representing Node.val
//  random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not
//  point to any node.
//
//
//      Example 1:
//
//
//  Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//  Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//  Example 2:
//
//
//  Input: head = [[1,1],[2,1]]
//  Output: [[1,1],[2,1]]
//  Example 3:
//
//
//
//  Input: head = [[3,null],[3,0],[3,null]]
//  Output: [[3,null],[3,0],[3,null]]
//  Example 4:
//
//  Input: head = []
//  Output: []
//  Explanation: Given linked list is empty (null pointer), so return null.
//
//
//  Constraints:
//
//      -10000 <= Node.val <= 10000
//  Node.random is null or pointing to a node in the linked list.
//  Number of Nodes will not exceed 1000.

  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };



  public RandomListNode copyRandomList(RandomListNode head) {

    Map<RandomListNode,RandomListNode> map=new HashMap<>();
    RandomListNode p1=head;

    RandomListNode p2=head==null?null:new RandomListNode(p1.label);
    RandomListNode res=p2;
    map.put(p1,p2);

    while(p1!=null && p1.next!=null){
      p2.next=new RandomListNode(p1.next.label);
      p1=p1.next;
      p2=p2.next;
      map.put(p1,p2);
    }

    p1=head;
    p2=res;

    while(p1!=null){
      p2.random=map.get(p1.random);
      p1=p1.next;
      p2=p2.next;
    }

    return res;
  }

  public static void main(String[] args) {

  }
}
