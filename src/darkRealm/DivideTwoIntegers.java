package darkRealm;

public class DivideTwoIntegers {

  /*
  #29 Divide two integers
  Divide two integers without using multiplication, division and mod operator.
  If it is overflow, return MAX_INT.
  */
  public int divide(int dividend, int divisor) {
    // I have no clue why we need this base case
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

    boolean sameSign = ((dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0));
    int dvd = Math.abs(dividend);
    int dvs = Math.abs(divisor);
    int times = 0;

    // The idea is multiply divisor in power of 2's untill it is smaller than the dividend, when we cant do so
    // we reduce the 2 multipled divisor from the dividend. And the remainder as the new dividend & solve the same problem again.

    // untill we can reduce divisor from dividend
    while (dvd - dvs >= 0) {
      int count = 1;
      int rem = 0;
      int sum = dvs;

      // why are we adding sum 2ce in the condition, because the count is already 1, so we already know,
      // one reduction is possible, as this is binary search, we are doing it 2ce.
      while (dvd - (sum + sum) >= 0) {
        sum = sum + sum; // multiply by 2
        count = count + count; // multiply by 2
      }

      times += count;
      dvd = dvd - sum;
    }

    return sameSign ? times : -times;
  }


  public static void main(String[] args) {

  }
}
