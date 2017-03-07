package PatternsZ.Startegy;

import java.util.Arrays;

/**
 * Created by Jayam on 3/7/2017.
 */
public class DataSet {

  int[] data;
  Strategy strategy;

  public DataSet(int[] arr) {
    data = arr;
  }

  public void changeStrategy(Strategy st) {
    strategy = st;
  }

  public void doOperation() {
    if (strategy != null)
      strategy.algorithm(data);
  }

  public void showData() {
    System.out.println(Arrays.toString(data));
  }
}