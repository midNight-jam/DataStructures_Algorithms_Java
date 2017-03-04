package darkRealm.CTCI;

/**
 * Created by Jayam on 3/3/2017.
 */
public class JHashMap<K,V> {
  int bucketSize = 17;
  MapNode<K, V>[] table = new MapNode[bucketSize];

  public void put(K key, V value) {
    int hashIndex = Math.abs(key.hashCode()) % bucketSize;
    MapNode<K, V> newNode = new MapNode<K, V>(key, value);
    if (table[hashIndex] == null) {
      table[hashIndex] = newNode;
      return;
    }

    MapNode<K, V> prev = null, trav = table[hashIndex];
    while (trav.next != null) {
      if (trav.key.equals(key)) { // replace the content
        if (prev == null) {
          newNode.next = trav.next;
          table[hashIndex] = newNode;
          return;
        } else {
          newNode.next = trav.next;
          prev.next = trav;
          return;
        }
      }
      prev = trav;
      trav = trav.next;
    }
    prev.next = newNode;
  }

  public V get(K key) {
    if (key == null) return null;
    int hashIndex = Math.abs(key.hashCode()) % bucketSize;
    if (table[hashIndex] == null) return null;

    MapNode<K, V> trav = table[hashIndex];
    while (trav != null) {
      if (trav.key == key) return trav.value;
      trav = trav.next;
    }
    return null;
  }
}

class MapNode<K, V> {
  K key;
  V value;
  MapNode<K, V> next;

  MapNode(K k, V v) {
    key = k;
    value = v;
    next = null;
  }
}