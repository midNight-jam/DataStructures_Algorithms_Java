package darkRealm.LeetCode.Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by Jayam on 2/21/2017.
 */
public class LFU {
  private DLinkNode head = null;
  private int capacity = 0;
  private HashMap<Integer, Integer> valueHash;
  private HashMap<Integer, DLinkNode> nodeHash;

  public LFU(int cap) {
    valueHash = new HashMap<>();
    nodeHash = new HashMap<>();
    capacity = cap;
  }

  private void addToHead(int key) {
    if (head == null) {
      head = new DLinkNode(0);
      head.keys.add(key);
    } else if (head.count > 0) {
      DLinkNode node = new DLinkNode(0);
      node.keys.add(key);
      node.next = head;
      head.prev = node;
      head = node;
    } else {
      head.keys.add(key);
    }
    nodeHash.put(key, head);
  }

  public void increaseCount(int key) {
    DLinkNode node = nodeHash.get(key);
    node.keys.remove(key);
    if (node.next == null) {
      node.next = new DLinkNode(node.count + 1);
      node.next.prev = node;
      node.next.keys.add(key);
    } else if (node.next.count == node.count + 1) {
      node.next.keys.add(key);
    } else {
      DLinkNode temp = new DLinkNode(node.count + 1);
      temp.keys.add(key);
      temp.prev = node;
      temp.next = node.next;
      node.next.prev = temp;
      node.next = temp;
    }
    nodeHash.put(key, node.next);
    if (node.keys.size() == 0) remove(node);
  }

  private void remove(DLinkNode node) {
    // node is the head
    if (node.prev == null) head = node.next;
    else node.prev = node.next;
    if (node.next != null) node.next.prev = node.prev;
  }

  private void removeOld() {
    if (head == null) return;
    int old = 0;
    // remove the first node from the linkedHashSet
    for (int n : head.keys) {
      old = n;
      break;
    }
    head.keys.remove(old);
    if (head.keys.size() == 0) remove(head);
    nodeHash.remove(old);
    valueHash.remove(old);
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (valueHash.containsKey(key)) valueHash.put(key, value);
    else {
      if (valueHash.size() < capacity) {
        valueHash.put(key, value);
      } else {
        removeOld();
        valueHash.put(key, value);
      }
      addToHead(key);
    }
    increaseCount(key);
  }

  public int get(int key) {
    if (valueHash.containsKey(key)) {
      increaseCount(key);
      return valueHash.get(key);
    }
    return -1;
  }

  private class DLinkNode {
    int count;
    LinkedHashSet<Integer> keys;
    DLinkNode prev;
    DLinkNode next;

    DLinkNode(int count) {
      this.count = count;
      prev = next = null;
      keys = new LinkedHashSet<>();
    }
  }
}