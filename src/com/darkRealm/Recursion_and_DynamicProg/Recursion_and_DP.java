package com.darkRealm.Recursion_and_DynamicProg;

/**
 * Created by Jayam on 12/20/2016.
 */
public class Recursion_and_DP {

  private static long[] fiboArray;

  /* [Example - Ch 8 - FibonacciNos]
  * @params   takes a number n to calcluate the Nth fibonacci number
  * @return   returns a long which is the Nth fibonacci number
  * */
  public static long NthFibonacci(int n) {
    long [] arr =  new long[n+1];
    long res = getNthFibonacciNumber(n,arr);
    return res;
  }

  private static long getNthFibonacciNumber(int n, long[] fiboArray) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (fiboArray[n] == 0) {
      fiboArray[n] = getNthFibonacciNumber(n - 1,fiboArray) + getNthFibonacciNumber(n - 2,fiboArray);
    }
    return fiboArray[n];
  }
}