package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jayam on 3/30/2017.
 */
public class PermutationsKLength {

  static int combinationNO = 0;

  private static void getSubArrayCombinations(Integer[] arr, int k) {
    if (k > arr.length) {
      return;
    }
    combinationNO = 0;
    ArrayList<Integer> nos = new ArrayList<Integer>(Arrays.asList(arr));
    ArrayList<Integer> res = new ArrayList<Integer>();
    combine(nos, res, k);
  }

  private static void combine(ArrayList<Integer> nos, ArrayList<Integer> res, int k) {
    if (res.size() == k) {
      combinationNO++;
      System.out.println(Arrays.toString(res.toArray()) + "  - " + combinationNO);
      return;
    }
    ArrayList<Integer> numbers = (ArrayList<Integer>) nos.clone();
    for (int i = 0; i < numbers.size(); i++) {
      int trav = numbers.get(i);
      // making a clone else will have to simarly remove the elements from the results combinations, its easier to have
      // a discardable clone. Thus below Clone
      ArrayList<Integer> results = (ArrayList<Integer>) res.clone();
      results.add(trav);
      numbers.remove(i);  // removing at the index
      combine(numbers, results, k);
      numbers = (ArrayList<Integer>) nos.clone(); // resetting to original SEQUENCE for more combinaitons,
      // THIS PART IS REALLY ESSENTIAL, beacuse if we simply add the element back to the list, it is not maintaining the
      // ORIGINAL sequence of numbers, due to this our combinations are repeating inspite of runing for correct no
      // of times
    }
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    getSubArrayCombinations(arr,3);
  }
}