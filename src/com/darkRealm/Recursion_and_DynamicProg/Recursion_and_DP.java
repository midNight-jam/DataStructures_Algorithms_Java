package com.darkRealm.Recursion_and_DynamicProg;

/**
 * Created by Jayam on 12/20/2016.
 */
public class Recursion_and_DP {

  /* [Example - Ch 8 - FibonacciNos]
  *  Top down approach - memoization
  * @params   takes a number n to calcluate the Nth fibonacci number
  * @return   returns a long which is the Nth fibonacci number
  * */
  public static long NthFibonacciMemoized(int n) {
    long[] arr = new long[n + 1];
    long res = getNthFibonacciNumber(n, arr);
    return res;
  }

  private static long getNthFibonacciNumber(int n, long[] fiboArray) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (fiboArray[n] == 0) {
      fiboArray[n] = getNthFibonacciNumber(n - 1, fiboArray) + getNthFibonacciNumber(n - 2, fiboArray);
    }
    return fiboArray[n];
  }

  /*  [Example - Ch 8 - FibonacciNos]
  *   Bottom Up approach - iteration
  *   @params   takes a number n to calculate the Nth fibonacci number
  *   @return   returns a long which is the Nth fibonacci number
  * */
  public static long NthFibonacciIterative(int n) {
    int temp, a, b, c;
    a = 0;
    b = 1;
    c = a + b;
    if (n == 0) {
      return 0;
    }

    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return (long) c;
  }
}