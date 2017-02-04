package darkRealm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Jayam on 2/3/2017.
 */
public class RandomizedSet {
  ArrayList<Integer> numbers;
  HashMap<Integer, Integer> map;

  public RandomizedSet() {
    numbers = new ArrayList<>();
    map = new HashMap<>();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    map.put(val, numbers.size());
    numbers.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int size = numbers.size();
    // if last number just remove
    int pos = map.get(val);

    if (pos < numbers.size() - 1) {
      // if not the last number we will have to place the last number on the vacated spot, to get this spot we use the
      // value against key, and also update the value of last element in the map
      int last = numbers.get(size - 1);
      numbers.set(pos, last); // putting the last number to its new position
      map.put(last, pos);  // updating the location of last in the map
    }

    map.remove(val);
    numbers.remove(pos);
    return true;
  }

  public int getRandom() {
    Random random = new Random();
    int index = random.nextInt(map.size());
    return numbers.get(index);
  }
}