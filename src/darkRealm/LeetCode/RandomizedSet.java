package darkRealm.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jayam on 2/3/2017.
 */
public class RandomizedSet {
  Map<Integer, Integer> valueMap;
  Map<Integer, Integer> indexMap;
  Random rand;

  RandomizedSet() {
    valueMap = new HashMap<>();
    indexMap = new HashMap<>();
    rand = new Random();
  }

  public boolean insert(int value) {
    // already present, cannot re add
    if (valueMap.containsKey(value)) return false;

    // store the new index of the value in both valu & indexMap
    valueMap.put(value, valueMap.size());
    indexMap.put(indexMap.size(), value);
    return true;
  }

  public boolean remove(int value) {
    if (!valueMap.containsKey(value)) return false;

    int index = valueMap.get(value);
    valueMap.remove(value);
    indexMap.remove(index);

    if (valueMap.isEmpty()) return true; // map empty
    if (index == indexMap.size()) return true; // last element is removed

    // update last elements index
    int last = indexMap.get(indexMap.size());

    valueMap.put(last, index); // replacing in value map, this way the preivous index is now used by the last element
    indexMap.remove(indexMap.size()); // removing the last element from the indexMap
    indexMap.put(index, last);  // updating the index of the last value
    return true;
  }

  public int getRandom() {
    if (valueMap.isEmpty()) return -1;  // map is still empty
    int ri = rand.nextInt(valueMap.size()); // get the random index
    return indexMap.get(ri);  // get the val at that index, using the indexMap
  }
}