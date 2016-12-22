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

  public static void testNthFiboIterative() {
    long n = Recursion_and_DP.NthFibonacciIterative(6);
    System.out.println("It fibo : " + n);
  }

  public static void testTripleSteps() {
    long startTime = System.currentTimeMillis();
    long nofways = Recursion_and_DP.TripleSteps(37, 3);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("no of ways " + nofways);
    System.out.println("time - " + elapsedTime + " ms");
  }

  public static void testRobotGrid() {
    int[][] matrix = new int[][]{
        {1, 0, 0, 1},
        {1, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 1, 0, 0},
    };
    long startTime = System.currentTimeMillis();
    String result = Recursion_and_DP.RobotGridPath(matrix);
    long stopTime = System.currentTimeMillis();
    System.out.println("Path results   - " + result);
    long elapsedTime = stopTime - startTime;
    System.out.println("time - " + elapsedTime + " ms");
  }
}