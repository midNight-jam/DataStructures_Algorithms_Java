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
    // we always make insertion at the head nodes.
    if (head == null) {
      head = new DLinkNode(0);
      head.keys.add(key);
    } else if (head.count > 0) {
      // if the head is holding keys that are accessed at least once (thats why its count is > 0)
      // then make this new node as the new head, and its next pointing to the previous head.
      DLinkNode node = new DLinkNode(0);
      node.keys.add(key);
      node.next = head;
      head.prev = node;
      head = node;
    } else {
      // else the head is holding the keys that are not at all accessed thus we can fit this newly accesed key in to this node
      head.keys.add(key);
    }
    // update new location of this key in the nodeHash
    nodeHash.put(key, head);
  }

  public void increaseCount(int key) {
    DLinkNode node = nodeHash.get(key);
    // remvoing the key, beacause after increasing the count the key can appear in any different node, thus removal form
    // NodeHash is fine
    node.keys.remove(key);

    if (node.next == null) {
      // if there is no next node with the increased count, why Plus 1 because we have accessed this node thats why its
      // frequency count will inrease, thus we check if already a node is present that is holding the frequent items
      node.next = new DLinkNode(node.count + 1);
      node.next.prev = node;
      node.next.keys.add(key);
    } else if (node.next.count == node.count + 1) {
      // if already a node is present that has the same count then we simply put this key in that node
      node.next.keys.add(key);
    } else {
      // there is neither next nor a node that has the same count as after acessing the key, thus we have to add a new node
      // and this new node will come previuos to the next of the current node of this key.
      DLinkNode temp = new DLinkNode(node.count + 1);
      temp.keys.add(key);
      temp.prev = node;
      temp.next = node.next;
      node.next.prev = temp;
      node.next = temp;
    }
    nodeHash.put(key, node.next);
    // finally after moving the key to its new node, if the current node doesnt hold any other key, then this node is
    // safe to delete, thus removal
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
    // remove the first key from the linkedHashSet, why this is the oldest node that was accessed for this count.
    for (int n : head.keys) {
      old = n;
      break;
    }
    head.keys.remove(old);
    // same if after removal of this key , if there are no more keys in the current node then this node is safe to delete
    if (head.keys.size() == 0) remove(head);
    // also remove from the hashes
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
        // there is not enough space in the cache, thus remove the least frequently & oldest accessed key
        removeOld();
        valueHash.put(key, value);
      }
      // add the newly acceseed key to the head
      addToHead(key);
    }
    // increase its count, this might result in relocation of the key to a new node
    increaseCount(key);
  }

  public int get(int key) {
    if (valueHash.containsKey(key)) {
      // incerase the count of this key, this might cause the relocation of the key to a new node
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