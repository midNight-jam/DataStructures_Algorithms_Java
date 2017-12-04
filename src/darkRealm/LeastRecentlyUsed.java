package darkRealm;

import java.util.HashMap;

/**
 * Created by Jayam on 2/21/2017.
 */
public class LeastRecentlyUsed {
  private int capacity, count;
  private DLinkNode head, tail;
  HashMap<Integer, DLinkNode> cache = new HashMap<>();

  public LeastRecentlyUsed(int cap) {
    count = 0;
    capacity = cap;
    cache = new HashMap<>();
    head = new DLinkNode();
    tail = new DLinkNode();
    head.prev = null;
    head.next = tail;
    tail.prev = head;
    tail.next = null;
  }

  private void addNode(DLinkNode node) {
    // always add the new node after the head node
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;  // the prev link of the next of the node next to head
    head.next = node;
  }

  private void removeNode(DLinkNode node) {
    // removes the exisiting node from the linked list
    DLinkNode prev = node.prev;
    DLinkNode next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DLinkNode node) {
    removeNode(node);
    addNode(node);
  }

  private DLinkNode popTail() {
    DLinkNode lastPrev = tail.prev;
    this.removeNode(lastPrev);
    return lastPrev;
  }

  public int get(int key) {
    DLinkNode node = cache.get(key);
    if (node == null) return -1;
    // move the accessed node to the head of the list
    this.moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkNode node = cache.get(key);
    if (node == null) {
      DLinkNode newNode = new DLinkNode();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      addNode(newNode);

      ++count;

      if (count > capacity) {
        // pop from the tail
        DLinkNode tail = popTail();
        cache.remove(tail.key);
        --count;
      }
    } else {
      node.value = value;
      this.moveToHead(node);
    }
  }

  private class DLinkNode {
    int key;
    int value;
    DLinkNode prev;
    DLinkNode next;
  }
}