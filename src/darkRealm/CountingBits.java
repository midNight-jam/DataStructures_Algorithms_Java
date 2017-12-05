package darkRealm;

public class CountingBits {

  /*  #338 Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 * Example:For num = 5 you should return [0,1,1,2,1,2].
 * Sol : There is a recurence relation of adding the previously counted 1 bits
 * res[i] = res[i / 2] + i % 2;
 * */
  public static int[] countingBits(int n) {
    if (n >= 0) {
      int[] res = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        res[i] = res[i / 2] + i % 2;
      }
      return res;
    }
    return new int[]{0};
  }

  public static void main(String[] args) {

  }
}
