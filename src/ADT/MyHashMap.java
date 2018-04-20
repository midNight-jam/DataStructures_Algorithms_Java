package ADT;


public class MyHashMap {

  private static class MapNode {
    String key;
    String value;
    MapNode next;
  }

  private MapNode[] hashTable;
  private int elements;
  private double loadFactor;

  MyHashMap(int capacity) {
    hashTable = new MapNode[capacity];
    loadFactor = 0.75;
  }

  public String get(String k) {
    if (k == null || k.length() == 0) return k;
    int bucketIndex = getBucketIndex(k, hashTable.length);

    if (hashTable[bucketIndex] == null) // key is not present in the hash table as no entry at the bucketIndex
      return null;

    MapNode trav = hashTable[bucketIndex];

    while (trav != null && !trav.key.equals(k)) // as there is some node bucketIndex do linear probing to confirm
      trav = trav.next;


    return trav.key.equals(k) ? trav.value : null;  // if key was found on this list else null, bcoz despite some node
    // at bucketIndex, the actual key is not present
  }

  public void put(String k, String v) {
    if (k == null || k.length() == 0) return;

    int bucketIndex = getBucketIndex(k, hashTable.length);
    MapNode node = new MapNode();
    node.key = k;
    node.value = v;

    if (hashTable[bucketIndex] == null) {
      // we insert at head so that we make at least insertion as close to O(1) as possible, if no collision
      node.next = hashTable[bucketIndex];
      hashTable[bucketIndex] = node;
      elements++; // as the new element is inserted
      return;
    }


    MapNode trav = hashTable[bucketIndex];

    while (trav != null && !trav.key.equals(k)) // linear probing to resolve collision
      trav = trav.next;


    if(trav == null) {  // add a new node as we have traversed the list, but this will cause the resize
      if (elements >= loadFactor * hashTable.length) {
        resize();
        bucketIndex = getBucketIndex(k, hashTable.length); // recompute the bucket index as after resize allocation may change
      }
      node.next = hashTable[bucketIndex];
      hashTable[bucketIndex] = node;
      elements++;
    }
    else if (trav.key.equals(k))
      trav.value = v; // key already present in the hashtable, just update the value

  }

  public int size() {
    return elements;
  }

  public boolean containsKey(String k) {
    if (k == null || k.length() == 0) return false;
    int bucketIndex = getBucketIndex(k, hashTable.length);
    MapNode trav = hashTable[bucketIndex];
    while (trav != null && !trav.key.equals(k))
      trav = trav.next;
    return trav != null ? trav.key.equals(k) : false;
  }

  public String remove(String k) {
    String removed = null;
    if (k == null || k.length() == 0) return removed;
    int bucketIndex = getBucketIndex(k, hashTable.length);


    if (hashTable[bucketIndex] == null) return removed; // key not present in the hashTable

    if (hashTable[bucketIndex].key.equals(k)) { // to be deleted node is the first node in the bucket
      removed = hashTable[bucketIndex].value;
      hashTable[bucketIndex] = hashTable[bucketIndex].next;
      elements--;
      return removed;
    }

    MapNode prev = hashTable[bucketIndex];
    MapNode trav = hashTable[bucketIndex].next;

    while (trav != null && !trav.key.equals(k)) {
      prev = trav;
      trav = trav.next;
    }

    if (trav != null) {
      prev.next = trav.next;
      elements--;
      removed = trav.value;
    }
    return removed;
  }

  private void resize() {
    MapNode[] newHashTable = new MapNode[hashTable.length * 2];
    int newBucketIndex = 0;
    MapNode trav = null, next = null;
    for (int i = 0; i < hashTable.length; i++) {
      trav = hashTable[i];
      // copy all the nodes on to the new hastable as per the new size
      while (trav != null) {
        newBucketIndex = getBucketIndex(trav.key, newHashTable.length); // bucketIndex as per new resized hashtable
        next = trav.next;
        trav.next = newHashTable[newBucketIndex]; // again insertion at head
        newHashTable[newBucketIndex] = trav;
        trav = next;
      }
    }
    hashTable = newHashTable; // discard the old hashtable
  }

  private int getBucketIndex(String k, int bucketSize) {
    return k.hashCode() % bucketSize;
  }

  public void dump() {
    MapNode trav = null;
    for (int i = 0; i < hashTable.length; i++) {
      trav = hashTable[i];
      System.out.print("["+i+ "]");
      while (trav != null) {
        System.out.print("  "+trav.key + " : " + trav.value);
        trav = trav.next;
      }
      System.out.print("\n");
    }
    System.out.println("- - - - - - - - - - - - - - - - ");
    System.out.println("HashMap Elements : " + elements + "   hashtable length : " + hashTable.length);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public static void main(String[] args) {
    MyHashMap map = new MyHashMap(2);  // Initial size of table is 2.
    map.dump();
    map.put("cat","furr");
    map.dump();
    map.put("dog","bite");
    map.dump();
    System.out.println(map.containsKey("cat"));
    System.out.println(map.get("dog"));
    System.out.println(map.containsKey("ca"));
    System.out.println(map.get("do"));
    map.put("toad","frog");
    map.dump();
    map.remove("toad");
    map.dump();
  }
}
