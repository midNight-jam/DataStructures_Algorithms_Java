package PatternsZ.Startegy;

import java.util.Arrays;

/**
 * Created by Jayam on 3/7/2017.
 */
public class StrategyA implements Strategy {

  public void algorithm(int[] arr) {
    System.out.println(" Using Quick Sort");
    Arrays.sort(arr);
  }
}
