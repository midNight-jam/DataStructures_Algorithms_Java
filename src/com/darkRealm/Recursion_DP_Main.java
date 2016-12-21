package com.darkRealm;

import com.darkRealm.Recursion_and_DynamicProg.Recursion_and_DP;

/**
 * Created by Jayam on 12/20/2016.
 */
public class Recursion_DP_Main {

  public static void testNthFibonacciMemoized() {
    long n = Recursion_and_DP.NthFibonacciMemoized(0);
    System.out.println(" fibo " + n);
  }

  public static void testNthFiboIterative(){
    long n = Recursion_and_DP.NthFibonacciIterative(6)
        ;
    System.out.println("It fibo : "+n);
  }
}