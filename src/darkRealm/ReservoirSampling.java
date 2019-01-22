package darkRealm;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {

  // Given an array, returns random K items
  private static int[] selectKItems(int[] items, int K) {
    int[] reservoir = new int[K];

    // Why it works
    // the probablity of an ith item to be chosen from k = 10 items is selecting the ith item and not selecting any other item
    // (10/i) * (1 - 10/(i+1)) * (1 - 10/(i+2)) * ... (1 - 10/(n -1)) *   (1 - 10/(n))
    // if we expand these terms and simplfy all will get canceled out and the remainder is 1/10
    // meaning each element as k/i probablity of getting selecting

    for (int i = 0; i < K; i++)
      reservoir[i] = items[i];

    Random r = new Random();


    // get a random between K to length, if the number is less than K, replace its vale with another number from stream
    for (int i = K; i < items.length; i++) {
      // pick a random from 0 to i
      int j = r.nextInt(i + 1);
      if (j < K)
        reservoir[j] = items[i];
    }
    return reservoir;
  }

  public static void main(String[] args) {
    int[] items = new int[]{0, 1, 2, 3, 4, 5};
    int K = 3;
    int[] res = selectKItems(items, K);
    System.out.println(Arrays.toString(items));
    System.out.println(Arrays.toString(res));
  }
}
