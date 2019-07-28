package darkRealm;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

  int capacity;
  Map<Integer, Integer> valueMap;
  Map<Integer, DLinkNode> nodeMap;
  DLinkNode head;

  /* GIST
  * The Idea is to have list of frequency nodes & each node will keep the list of keys in order of their arrival(linkedHashSet)
  * The nodes are in increasing order of frequency from 0 to N (not neccesarily continious)
  * We always add the the new key at head, with 0 frequency & then update its frequency so its gets added to the correct
  * frequency node (1 freq)
  * When accessing we move the key from its current frequency node to the next frequency node
  * When we hit the limit, we will remove the lowestFrequency (node at Head) & the oldest key in the lowestFrequency (which
  * will be the first key at the lowest frequency node)
  * */

  public LFUCache(int c) {
    if (c < 1) return;
    capacity = c;
    valueMap = new HashMap<>();
    nodeMap = new HashMap<>();
  }

  public int get(int key) {
    if (valueMap == null) return -1;

    if (!valueMap.containsKey(key)) return -1;
    // inrease the frequency of this key
    increaseFrequency(key);
    // return the value against this key
    return valueMap.get(key);
  }

  public void put(int key, int value) {
    if (valueMap == null) return;

    // this key is already present in the cache,  update its value + increase frequency of that key;
    if (valueMap.containsKey(key)) {
      valueMap.put(key, value);
    }
    // this key is not present in cache, but we have capacity to accomodate a new key in cache
    // add this key in valueMap & insert a new node to head
    else if (valueMap.size() < capacity) {
      valueMap.put(key, value);
      addToHead(key);
    } else {
      // we have reached capacity, we should make room by deleting the oldest + lowest freq key in cache
      removeOldestLowestFrequencyKey();
      // now we have room, so again we insert at head
      addToHead(key);
      //insert the key in valueMap;
      valueMap.put(key, value);
    }

    // finally increase the fequency count for this key in the cache
    increaseFrequency(key);
  }


  private void addToHead(int key) {
    if (head == null) {
      head = new DLinkNode(0); // initiali frequency is always 0
      head.keys.add(key);
      nodeMap.put(key, head);// always updates agains the head
      return;
    } else if (head.frequency == 0) {// there are already 0 freq count keys present in the cache, add this new key to the same list of 0 freq
      head.keys.add(key);
      nodeMap.put(key, head);// always updates agains the head
      return;
    }
    // the head contains already accessed keys that have freq count > 0, then create a new node & make it head
    else {
      DLinkNode node = new DLinkNode(0);
      node.prev = null;
      node.next = head;
      head.prev = node;
      head = node;
      nodeMap.put(key, head); // always updates agains the head
      return;
    }
  }

  private void removeOldestLowestFrequencyKey() {
    if (head == null) return; // no keys in cache
    // remove the first key that arrived in the cache & has the current lowest frequency, (thats why it will be at head)
    int oldestLowestFreqKey = -1;
    for (int k : head.keys) {
      oldestLowestFreqKey = k;
      break;
    }
    // remove this oldestLowestFreqKey from the head's linkedHashSet of keys
    head.keys.remove(oldestLowestFreqKey);
    // if after removal there are no more keys of this frequency in the head, then remove the head * point to the next Frequency node
    if (head.keys.size() == 0) {
      updateHead();
    }
    nodeMap.remove(oldestLowestFreqKey);
    valueMap.remove(oldestLowestFreqKey);
  }

  private void updateHead() {
    removeNode(head);
  }

  private void removeNode(DLinkNode node) {
    // its the head node
    if (node == null) return;
    if (node.prev == null) {
      // there is a next node
      if (head.next != null)
        head.next.prev = null;
      head = head.next;
      return;
    }

    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void increaseFrequency(int key) {
    // get the freq node of this key
    DLinkNode node = nodeMap.get(key);
    //remove this key from its present frequency place
    node.keys.remove(key);
    int nextFreq = node.frequency + 1;
    // we will have the correct frequency of node as the next of this node;
    // there is no next freqency node;
    if (node.next == null) {
      node.next = new DLinkNode(nextFreq);
      node.next.prev = node;
      node.next.keys.add(key);
    }
    // next frequency node is present, just add this key in that frequency node
    else if (node.next.frequency == nextFreq) {
      node.next.keys.add(key);
    }
    // we dont have the next Frequency node as next to this node, so we must insert it here
    else {
      DLinkNode nfNode = new DLinkNode(nextFreq);
      nfNode.keys.add(key);
      nfNode.prev = node;
      nfNode.next = node.next;
      node.next.prev = nfNode;
      node.next = nfNode;
    }
    // remember, we will have the correct frequency of node as the next of this node
    nodeMap.put(key, node.next);
    // finally if after removal there are no keys of this frequency in the current node then delete this node
    if (node.keys.size() == 0)
      removeNode(node);
  }

  class DLinkNode {
    DLinkNode prev;
    DLinkNode next;
    int frequency;
    LinkedHashSet<Integer> keys; // keys of same fequency in the same order which they arrived

    DLinkNode(int f) {
      frequency = f;
      keys = new LinkedHashSet<>();
    }
  }

  public static void main(String[] args) {
//    LFUCache cache = new LFUCache(2);
//    cache.put(1, 11);
//    cache.put(2, 22);
//    cache.get(1);
//    cache.put(3, 33);
//    cache.get(2);
//    cache.get(3);
//    cache.put(4, 44);
//    cache.get(1);
//    cache.get(3);
//    cache.get(4);

//    LFUCache cache = new LFUCache(1);
//    cache.put(2, 11);
//    cache.get(2);
//    cache.put(3, 22);
//    cache.get(2);
//    cache.get(3);

    LFUCache cache = new LFUCache(0);
    cache.put(0, 0);
    cache.get(0);
  }
}
