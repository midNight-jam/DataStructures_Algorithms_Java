package darkRealm.LeetCode;

import java.util.*;

/**
 * Created by Jayam on 2/3/2017.
 */
public class RandomizedCollection {
  ArrayList<Integer> numbers;
  HashMap<Integer, Set<Integer>> locs;
  Random rand = new Random();

  /**
   * Initialize your data structure here.
   */
  public RandomizedCollection() {
    numbers = new ArrayList<>();
    locs = new HashMap<>();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    boolean contain = locs.containsKey(val);
    if (!contain) locs.put(val, new LinkedHashSet<>());
    locs.get(val).add(numbers.size());
    numbers.add(val);
    return !contain;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    boolean contain = locs.containsKey(val);
    if (!contain) return false;
    int loc = locs.get(val).iterator().next();
    locs.get(val).remove(loc);
    if (loc < numbers.size() - 1) {
      int lastone = numbers.get(numbers.size() - 1);
      numbers.set(loc, lastone);
      locs.get(lastone).remove(numbers.size() - 1);
      locs.get(lastone).add(loc);
    }
    numbers.remove(numbers.size() - 1);

    if (locs.get(val).isEmpty()) locs.remove(val);
    return true;
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return numbers.get(rand.nextInt(numbers.size()));
  }
}